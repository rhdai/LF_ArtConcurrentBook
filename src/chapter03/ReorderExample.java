package chapter03;

class ReorderExample {
    int     a    = 0;
    boolean flag = false;

    public void writer() {
        a = 1; //1
        flag = true; //2
    }

    public void reader() {
        if (flag) { //3
            int i = a * a; //4
            //s����
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
    	final ReorderExample reorderExample = new ReorderExample();
    	Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				reorderExample.writer();
			}
		});
    	Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				reorderExample.reader();
			}
		});
    	thread1.start();
    	thread2.start();
    	/**
    	 * <drh>
    	 * �������������ܴ�ӡ��1������Ҳ�в�����������
    	 * 		�������еļ��裬ȷʵ���ܱ�֤��ִ��reader()��ʱ��thread1�Թ��������д��ɼ���
    	 * 			1.��ȷ���Ǳ������ʹ������������2��������������,������ʱ��û�취֤���� 
    	 * 			2.Ҳ���������̼߳��л�reader����ִ���ˣ�
    	 * 		���н��͵����������ˡ�
    	 * 
    	 * as-if-serial���������ʹ�����Ϊ����߲��жȣ�������ô�����򣬵ñ�֤���̵߳�ִ�н�����䡣��������Ӿ�˵����֤���˶��̻߳�����ִ�н����һ�¡�
    	 * 
    	 * �����²ۣ����̺߳���Ҫ��Ҫ��Ȼ�����˶��Һ����ҵ���
    	 * </drh>
    	 */
		
	}
}
