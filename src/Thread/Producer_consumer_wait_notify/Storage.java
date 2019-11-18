package Thread.Producer_consumer_wait_notify;

public class Storage {
    private final int max = 10;
    private int sum;
    //private ArrayList<Object> list = new ArrayList<Object>();

    public synchronized void  produce() {
        while (sum == max) {
            try {
                System.out.println(Thread.currentThread().getName()+"库存量：" + sum+ "/t库存已满不能生产");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sum++;
        System.out.println(Thread.currentThread().getName()+"【已经生产产品数】:" + sum+ "/t");
        notifyAll();
    };

    public synchronized void consume() {
        while (sum==0) {
            try {
                System.out.println(Thread.currentThread().getName()+"【库存量】:" + sum+ "/t库存不足暂时不能执行消费任务!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sum--;
        System.out.println(Thread.currentThread().getName()+"【剩余产品数】:" + sum + "/t");
        notifyAll();
    };
}


