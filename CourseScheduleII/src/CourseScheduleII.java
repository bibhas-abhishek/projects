import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 24 Apr 2018
 * https://leetcode.com/problems/course-schedule-ii/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/CourseScheduleII
 **/

public class CourseScheduleII {

    private static class Course {

        private List<Course> children = new ArrayList<>();
        private Map<Integer, Course> map = new HashMap<>();
        private int name;
        private State state;

        private enum State {COMPLETE, PARTIAL, BLANK}


        Course(int name) {
            this.name = name;
            this.state = State.BLANK;
        }

        List<Course> getChildren() {
            return children;
        }

        int getName() {
            return name;
        }

        State getState() {
            return state;
        }

        void setState(State state) {
            this.state = state;
        }

        void addNeighbour(Course node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                map.put(node.getName(), node);
            }
        }

    }


    private static class Graph {

        private List<Course> nodes = new ArrayList<>();
        private Map<Integer, Course> map = new HashMap<>();

        List<Course> getNodes() {
            return nodes;
        }

        Course getOrCreateNode(int name) {
            if (!map.containsKey(name)) {
                Course node = new Course(name);
                nodes.add(node);
                map.put(name, node);
            }
            return map.get(name);
        }

        void addEdge(int startName, int endName) {
            Course start = getOrCreateNode(startName);
            Course end = getOrCreateNode(endName);
            start.addNeighbour(end);
        }

    }

    private static Graph buildGraph(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();
        for (int i = 0; i < numCourses; i++)
            graph.getOrCreateNode(i);

        for (int[] prerequisite : prerequisites)
            graph.addEdge(prerequisite[0], prerequisite[1]);

        return graph;
    }

    private static Stack<Course> orderProjects(List<Course> courses) {
        Stack<Course> stack = new Stack<>();
        for (Course course : courses) {
            if (!doDFS(course, stack))
                return null;
        }
        return stack;
    }

    private static boolean doDFS(Course course, Stack<Course> stack) {
        if (course.getState() == Course.State.PARTIAL)
            return false;

        if (course.getState() == Course.State.BLANK) {
            course.setState(Course.State.PARTIAL);
            List<Course> children = course.getChildren();
            for (Course child : children) {
                if (!doDFS(child, stack))
                    return false;
            }
            course.setState(Course.State.COMPLETE);
            stack.push(course);
        }
        return true;
    }

    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = buildGraph(numCourses, prerequisites);
        Stack<Course> stack = orderProjects(graph.getNodes());
        if (stack != null) {
            int[] result = new int[numCourses];
            int i = 0;
            for (Course c : stack) {
                result[i++] = c.name;
            }
            return result;
        } else
            return new int[0];
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] prerequisites = {{0, 1}, {1, 0}};
        int[] result = findOrder(n, prerequisites);
        for (int i : result)
            System.out.print(i + " ");
    }

}
