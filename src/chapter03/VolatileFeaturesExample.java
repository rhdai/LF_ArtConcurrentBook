package chapter03;

class VolatileFeaturesExample {
    volatile long vl = 0L; //使用volatile声明64位的long型变量

    public void set(long l) {
        vl = l; //单个volatile变量的写
    }

    public void getAndIncrement() {
        vl++; //复合（多个）volatile变量的读/写
    }

    public long get() {
    	System.out.println(vl);
        return vl; //单个volatile变量的读
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
