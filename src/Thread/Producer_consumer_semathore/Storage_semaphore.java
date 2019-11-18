package Thread.Producer_consumer_semathore;

import java.util.concurrent.Semaphore;

public class Storage_semaphore {

    // 仓库存储的载体
    //private LinkedList<Object> list = new LinkedList<Object>();
    // 仓库的最大容量
    //private final int max = 10;
    private int sum;
    final Semaphore notFull = new Semaphore(5);
    // 将线程挂起，等待其他来触发
    final Semaphore notEmpty = new Semaphore(0);
    // 互斥锁
    final Semaphore mutex = new Semaphore(1);

    public void produce()
    {
        try {
            notFull.acquire();
            System.out.println(notFull.toString());
            mutex.acquire();
            System.out.println(mutex.toString());
            sum++;
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + sum);
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            System.out.println("执行后："+mutex.toString());
            notEmpty.release();
            System.out.println("执行后："+notEmpty.toString());
        }
    }

    public void consume()
    {
        try {
            notEmpty.acquire();
            mutex.acquire();
            sum--;
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费一个产品，现库存" + sum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notFull.release();
        }
    }
}



