package chapter04;

/**
 * 6-10
 */
public class Synchronized {
    public static void main(String[] args) {
        // 对Synchronized Class对象进行加锁    也可以自己new一个对象出来枷锁
        synchronized (Synchronized.class) {

        }
        // 静态同步方法，对Synchronized Class对象进行加锁
        m();
    }

    public static synchronized void m() {
    }
    /**
     * <drh>
     * http://feuyeux.iteye.com/blog/349528
     * 这篇bolg很形象的解释了同步代码块和同步方法
     * </drh>
     * 
     */
}
