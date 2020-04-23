/**
 * @program: algorithm
 * @description: 1.1 实验目的 练习实现Singleton模式的两种方式。
 * 1.2 实验内容 实现Lazy Singleton 和Eager Singleton，
 * 并且编写一个Client，设法测试是否确实是一个Singleton，说明测试的理由。
 * @author: Sunbuhui7
 * @create: 2020-04-11 21:30
 **/


/**
 * 这是Eager Singleton，
 * 饿汉单例模式
 * 在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快.
 * 线程安全的。
 */
class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();
    private String val;

    private EagerSingleton() {}
    public  static  EagerSingleton getInstance(){
        return INSTANCE;
    }

    /**
     * 单元测试。
     * 启动100个线程，查看getInstance方法返回的对象的hashcode是否相等。
     * 原理：Object超类的hashcode()方法返回该对象的存储地址，如果存储地址相同，那么就都是一个对象。
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()-> System.out.println(getInstance().hashCode())).start();
        }
    }

}

/**
 * 这是Lazy Singleton(懒加载单例模式)，
 * 采用DCK(double check lock)双重检查锁。
 * INSTANCE使用volatile修饰，保证了禁止指令重排序。
 * 使用synchronized关键字锁住LazySingleton.class,保证了线程安全。
 *
 */
class LazySingleton {
    private volatile static  LazySingleton INSTANCE;
    private String val;

    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if(INSTANCE==null){
            synchronized (LazySingleton.class){
                if (INSTANCE==null) {
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }
    /**
     * 同上
     * 单元测试。
     * 启动100个线程，查看getInstance方法返回的对象的hashcode是否相等。
     * 原理：Object超类的hashcode()方法返回该对象的存储地址，如果存储地址相同，那么就都是一个对象。
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()-> System.out.println(getInstance().hashCode())).start();
        }
    }

}

