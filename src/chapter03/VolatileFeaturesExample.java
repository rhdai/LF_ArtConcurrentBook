package chapter03;

class VolatileFeaturesExample {
    volatile long vl = 0L; //ʹ��volatile����64λ��long�ͱ���

    public void set(long l) {
        vl = l; //����volatile������д
    }

    public void getAndIncrement() {
        vl++; //���ϣ������volatile�����Ķ�/д
    }

    public long get() {
    	System.out.println(vl);
        return vl; //����volatile�����Ķ�
    }
    
    public static void main(String[] args) {
    	final VolatileFeaturesExample VFE = new VolatileFeaturesExample();
    	Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				VFE.set(4);
			}
		});
    	Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				VFE.get();
			}
		});
    	thread2.start();
    	thread1.start();
	}
}
