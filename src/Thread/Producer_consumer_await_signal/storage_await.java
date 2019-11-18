package Thread.Producer_consumer_await_signal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

public class storage_await {

    //private static StampedLock.ReadLockView lock;
    // 仓库最大存储量
    private final int MAX_SIZE = 10;
    private int sum;
    // 仓库存储的载体
    //private LinkedList<Object> list = new LinkedList<Object>();
    // 锁
    private final Lock lock = new ReentrantLock();
    // 仓库满的条件变量
    private final Condition full = lock.newCondition();
    // 仓库空的条件变量
    private final Condition empty = lock.newCondition();

    public  void produce()
    {
        // 获得锁
        lock.lock();
        while (sum >= MAX_SIZE) {
            try {
                System.out.println("【生产者" + Thread.currentThread().getName()
                        + "】仓库已满");
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sum++;
        System.out.println("【生产者" + Thread.currentThread().getName()
                + "】生产一个产品，现库存" + sum);
        empty.signalAll();
        lock.unlock();
    }

    public void consume()
    {
        // 获得锁
        lock.lock();
        while (sum == 0) {
            try {
                System.out.println("【消费者" + Thread.currentThread().getName()
                        + "】仓库为空");
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sum--;
        System.out.println("【消费者" + Thread.currentThread().getName()
                + "】消费一个产品，现库存" + sum);

        full.signalAll();
        lock.unlock();
    }
}


