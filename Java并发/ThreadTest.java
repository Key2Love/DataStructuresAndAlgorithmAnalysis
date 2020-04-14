import org.omg.PortableInterceptor.INACTIVE;

/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-04-09 09:37
 **/

/**
 * 最简单的写法，推荐。
 * 唯一的缺点，初始化的时候就实例化INSTANCE
 */
class DCLmode {
    private static final DCLmode INSTANCE = new DCLmode();

    private DCLmode() {

    }

    public static DCLmode getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        DCLmode a = DCLmode.getInstance();
    }

}

class DCLmode1 {
    private static volatile DCLmode1 INSTANCE;

    private DCLmode1() {}

    public static DCLmode1 getInstance() {
        if (INSTANCE == null) { //第一次检查
            synchronized (DCLmode1.class) { //加锁
                if (INSTANCE == null) { //第二次检查
                    INSTANCE = new DCLmode1();
                }
            }
        }
        return INSTANCE;
    }
}

class T {
    public synchronized static void m() {
        System.out.println(1);
    }

    public static void main(String[] args) {

    }
}