public class Apple implements IMobile {

    @Override
    public void cost() {
        System.out.println("Apple cost: 100000 Rs" );
    }

    @Override
    public void capacity() {
        System.out.println("Apple capacity: 64 GB" );
    }

    @Override
    public void battery() {
        System.out.println("Apple battery: 3000 mAh" );
    }

}
