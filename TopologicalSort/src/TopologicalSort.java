import sun.java2d.opengl.OGLSurfaceData;

import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 23 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/TopologicalSort
 **/

public class TopologicalSort {

    private static class Project {

        private List<Project> children = new ArrayList<>();
        private Map<String, Project> map = new HashMap<>();
        private String name;
        private State state;

        private enum State {COMPLETE, PARTIAL, BLANK}

        public Project(String name) {
            this.name = name;
            this.state = State.BLANK;
        }

        public List<Project> getChildren() {
            return children;
        }

        public String getName() {
            return name;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public void addNeighbour(Project node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                map.put(node.getName(), node);
            }
        }

    }

    private static class Graph {

        private List<Project> nodes = new ArrayList<>();
        private Map<String, Project> map = new HashMap<>();

        public List<Project> getNodes() {
            return nodes;
        }

        public Project getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }
            return map.get(name);
        }

        public void addEdge(String startName, String endName) {
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbour(end);
        }

    }

    private static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects)
            graph.getOrCreateNode(project);

        for (String[] dependency : dependencies)
            graph.addEdge(dependency[0], dependency[1]);

        return graph;
    }

    private static Stack<Project> orderProjects(List<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (!doDFS(project, stack))
                return null;
        }
        return stack;
    }

    private static boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL)
            return false;

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            List<Project> children = project.getChildren();
            for (Project child : children) {
                if (!doDFS(child, stack))
                    return false;
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

    private static Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
        String[][] dependencies = {{"a", "e"}, {"d", "g"}, {"c", "a"}, {"b", "a"}, {"b", "h"}, {"f", "c"}, {"f", "a"}, {"f", "b"}};
        Stack<Project> stack = findBuildOrder(projects, dependencies);
        Collections.reverse(stack);
        stack.stream().map(project -> project.name + " ").forEach(System.out::print);
    }

}
