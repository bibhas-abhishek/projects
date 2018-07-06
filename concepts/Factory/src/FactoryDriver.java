public class FactoryDriver {

    public static void main(String[] args) {
        MobileFactory mobileFactory = new MobileFactory();

        Apple apple = (Apple) mobileFactory.createMobile("apple");
        apple.cost();

        Samsung samsung = (Samsung) mobileFactory.createMobile("samsung");
        samsung.cost();
    }

}
