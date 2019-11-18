package Thread.Producer_consumer_blockingqueue;

public class Producer implements Runnable {
    private storage_blockingqueue storage_blockingqueue;
    public Producer(storage_blockingqueue storage_blockingqueue){
        this.storage_blockingqueue=storage_blockingqueue;
    }
   // public void run

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                storage_blockingqueue.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
