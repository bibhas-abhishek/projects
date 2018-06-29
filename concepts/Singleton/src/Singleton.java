import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton implements Cloneable, Serializable {

    private static volatile Singleton instance = null;

    private Singleton() {
        if (instance != null)
            throw new RuntimeException("instance already exists");
    }

    // double checked locking
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

    public static void useInstance() {
        Singleton s = Singleton.getInstance();
        System.out.println("singleton: " + s);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        if (instance != null)
            throw new CloneNotSupportedException("clone not supported");
        return super.clone();
    }

    // fixing serialisation/deserialization problems
    private Object readResolve() {
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        /*// reflection
        Class klass = Class.forName("Singleton");
        Constructor<Singleton> constructor = klass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton s3 = constructor.newInstance();
        System.out.println("s3: " + s3);*/

        /*// cloning
        Singleton s4 = (Singleton) s2.clone();
        System.out.println("s4: " + s4);*/

        /*//serialisation/deserialization
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.txt"));
        objectOutputStream.writeObject(s2);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.txt"));
        Singleton s5 = (Singleton) objectInputStream.readObject();
        System.out.println("s5: " + s5);*/

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(Singleton::useInstance);
        executorService.submit(Singleton::useInstance);
        executorService.submit(Singleton::useInstance);
        executorService.submit(Singleton::useInstance);
        executorService.submit(Singleton::useInstance);
        executorService.shutdown();
    }

}
