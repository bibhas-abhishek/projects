public class SingletonBillPugh {

    private SingletonBillPugh() {
        System.out.println("creating object");
    }

    static class Holder {
        static final SingletonBillPugh instance = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return Holder.instance;
    }

    public static void main(String[] args) {
        SingletonBillPugh s1 = SingletonBillPugh.getInstance();
        SingletonBillPugh s2 = SingletonBillPugh.getInstance();
        SingletonBillPugh s3 = SingletonBillPugh.getInstance();
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);
    }

}
