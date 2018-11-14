public final class ImmutableCircle {

    private final Point center;
    private final int radius;

    public ImmutableCircle(int x, int y, int r) {
        center = new Point(x, y);
        radius = r;
    }

    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "ImmutableCircle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    public static void main(String[] args) {
        ImmutableCircle immutableCircle = new ImmutableCircle(0, 1, 5);
        System.out.println(immutableCircle);
    }

}
