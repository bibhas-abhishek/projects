public class Samsung implements IMobile {

    @Override
    public void cost() {
        System.out.println("Samsung cost: 80000 Rs");
    }

    @Override
    public void capacity() {
        System.out.println("Samsung capacity: 64 GB");
    }

    @Override
    public void battery() {
        System.out.println("Samsung battery: 3500 mAh");
    }

}
