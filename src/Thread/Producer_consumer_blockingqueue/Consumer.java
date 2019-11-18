package Thread.Producer_consumer_blockingqueue;

public class Consumer implements Runnable {
    private storage_blockingqueue storage_blockingqueue;

    public Consumer(storage_blockingqueue storage_blockingqueue) {
        this.storage_blockingqueue = storage_blockingqueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                storage_blockingqueue.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
