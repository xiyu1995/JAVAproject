package Thread.Producer_consumer_wait_notify;

public class Consumer implements Runnable {
    // 每次消费的产品数量
    //private int num;

    // 所在放置的仓库
    private Storage storage;
    //private storage_await storage_await;
    //private Storage_semaphore storage_semaphore;
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);  // 睡眠1秒，防止该该线程多次获取到锁
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "：消费线程被打断sleep");
                return;
            }
            storage.consume();
        }
    }
    // 构造函数，设置仓库
    public Consumer(Storage storage) {
          this.storage = storage;
    }
//    public Consumer(storage_await storage_await) {
//          this.storage_await = storage_await;
//    }

//    public Consumer (Storage_semaphore storage_semaphore) {
//        this.storage_semaphore=storage_semaphore;
//    }


    // 线程run函数
    //public void run() {
    //   consume(num);
    //}

    // 调用仓库Storage的生产函数
    //public void consume(int num) {
    //    storage.consume(num);
    //}

    // get/set方法
    //public int getNum() {
    //    return num;
    //}

    //public void setNum(int num) {
    //   this.num = num;
    // }


}
