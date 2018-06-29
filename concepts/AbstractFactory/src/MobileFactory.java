public class MobileFactory implements IMobileFactory {

    @Override
    public IMobileFactory createDevice(String type) {
        IMobileFactory mobileFactory = null;
        if (type.equals("apple"))
            mobileFactory = new AppleMobileFactory();
        else if (type.equals("samsung"))
            mobileFactory = new SamsungMobileFactory();
        return mobileFactory;
    }

}
