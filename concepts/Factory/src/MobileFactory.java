public class MobileFactory {

    public MobileFactory() {
    }

    public IMobile createMobile(String type) {
        IMobile mobile = null;
        if (type.equals("apple")) {
            System.out.println("Apple mobile created");
            mobile = new Apple();
        } else if (type.equals("samsung")) {
            System.out.println("Samsung mobile created");
            mobile = new Samsung();
        }
        return mobile;
    }

}
