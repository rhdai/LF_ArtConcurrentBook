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
            //s……
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
    	 * 结果多数情况下能打印出1。但是也有不输出的情况。
    	 * 		按照书中的假设，确实不能保证在执行reader()的时候thread1对共享变量的写入可见。
    	 * 			1.不确定是编译器和处理器对上面的2个方法重排序了,个人暂时还没办法证明？ 
    	 * 			2.也可以能是线程见切换reader方法执行了？
    	 * 		书中解释的是重排序了。
    	 * 
    	 * as-if-serial：编译器和处理器为了提高并行度，不管怎么重排序，得保证单线程的执行结果不变。上面的例子就说明保证不了多线程环境的执行结果都一致。
    	 * 
    	 * 个人吐槽：多线程很重要。要不然出错了都找很难找到错。
    	 * </drh>
    	 */
		
	}
}
