package chapter04;

/**
 * 6-10
 */
public class Synchronized {
    public static void main(String[] args) {
        // ��Synchronized Class������м���    Ҳ�����Լ�newһ�������������
        synchronized (Synchronized.class) {

        }
        // ��̬ͬ����������Synchronized Class������м���
        m();
    }

    public static synchronized void m() {
    }
    /**
     * <drh>
     * http://feuyeux.iteye.com/blog/349528
     * ��ƪbolg������Ľ�����ͬ��������ͬ������
     * </drh>
     * 
     */
}
