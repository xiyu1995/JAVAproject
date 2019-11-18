package Thread.Producer_consumer_blockingqueue;

import java.util.concurrent.Callable;

public class producer_consumer {
    public static void main(String[] args){
        storage_blockingqueue storage_blockingqueue=new storage_blockingqueue();
        Producer p1=new Producer(storage_blockingqueue);
        Producer p2=new Producer(storage_blockingqueue);
        Consumer c1=new Consumer(storage_blockingqueue);
        new Thread(p1,"生产者1").start();
        new Thread(c1,"消费者1").start();
        new Thread(p2,"生产者2").start();

    }
}
