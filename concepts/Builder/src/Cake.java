public class Cake {

    private final double sugar;
    private final double butter;
    private final double milk;
    private final int cherry;

    public static class CakeBuilder {

        private double sugar;
        private double butter;
        private double milk;
        private int cherry;

        public CakeBuilder addSugar(double sugar) {
            this.sugar = sugar;
            return this;
        }

        public CakeBuilder addButter(double butter) {
            this.butter = butter;
            return this;
        }

        public CakeBuilder addMilk(double milk) {
            this.milk = milk;
            return this;
        }

        public CakeBuilder addCherries(int cherry) {
            this.cherry = cherry;
            return this;
        }

        public Cake build() {
            return new Cake(this);
        }

    }

    private Cake(CakeBuilder builder) {
        this.sugar = builder.sugar;
        this.butter = builder.butter;
        this.milk = builder.milk;
        this.cherry = builder.cherry;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "sugar=" + sugar +
                ", butter=" + butter +
                ", milk=" + milk +
                ", cherry=" + cherry +
                '}';
    }

}
