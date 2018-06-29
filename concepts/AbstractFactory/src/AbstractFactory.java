public class AbstractFactory {

    public static void main(String[] args) {
        MobileFactory mobileFactory = new MobileFactory();
        AppleMobileFactory appleMobileFactory = (AppleMobileFactory) mobileFactory.createDevice("apple");
        Apple apple = appleMobileFactory.createAppleDevice();
        apple.battery();
    }

}
