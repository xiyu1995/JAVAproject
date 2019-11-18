package Thread.Producer_consumer_wait_notify;

public class producer_consumer {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        //Producer p3 = new Producer(storage_semaphore);
        Consumer c1 = new Consumer(storage);
        Consumer c2 = new Consumer(storage);
//        Producer p1 = new Producer(storage_await);
//        Producer p2 = new Producer(storage_await);
//        Producer p3 = new Producer(storage_await);
//        Consumer c1 = new Consumer(storage_await);
//        Consumer c2 = new Consumer(storage_await);
        //Consumer c3 = new Consumer(storage_await);
//        Producer p1 = new Producer(storage);
//        Producer p2 = new Producer(storage);
//        Producer p3 = new Producer(storage);
//        Consumer c1 = new Consumer(storage);
//        Consumer c2 = new Consumer(storage);
        //Consumer c3 = new Consumer(storage);
        // Consumer c4 = new Consumer(storage);

        new Thread(p1,"生产线程1").start();
        new Thread(p2,"生产线程2").start();
        //new Thread(p3,"生产线程3").start();
        new Thread(c1,"消费线程1").start();
        new Thread(c2,"消费线程2").start();
        //new Thread(c3,"消费线程3").start();
        //new Thread(c4,"消费线程4").start();
    }
}
