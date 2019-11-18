package Thread.Producer_consumer_semathore;

public class Producer implements Runnable {
    // 每次生产的产品数量
    //private int num;

    // 所在放置的仓库
    //private Storage storage;
    //private storage_await storage;
    private Storage_semaphore storage_semaphore;
    // 构造函数，设置仓库
//    public Producer(Storage storage) {
//        this.storage = storage;
//    }
//    public Producer(storage_await storage_wait){
//        this.storage=storage_wait;
//    }
    public Producer(Storage_semaphore storage_semaphore){
        this.storage_semaphore=storage_semaphore;
    }

    // 线程run函数
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);  // 睡眠1秒，防止该该线程多次获取到锁
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "：消费线程被打断sleep");
                return;
            }
            storage_semaphore.produce();
        }
    }

    // 调用仓库Storage的生产函数
    //public void produce(int num) {
    //   storage.produce(num);
    //}

    // get/set方法
    // public int getNum() {
    //return num;
    //}

    //public void setNum(int num) {
    //    this.num = num;
    // }

    //public Storage getStorage() {
    // return storage;
    //}

    //public void setStorage(Storage storage) {
    //   this.storage = storage;
    // }
}
