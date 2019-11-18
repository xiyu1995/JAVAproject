package Thread.Producer_consumer_blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class storage_blockingqueue {
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<>(10);

    public void produce() {
            try{
                list.put(new Object());
                System.out.println("【生产者" + Thread.currentThread().getName()
                        + "】生产一个产品，现库存" + list.size());
            } catch (InterruptedException e){
                e.printStackTrace();
            }


    }

    public void consume() {
        //while (true){
            try{
                list.take();
                System.out.println("【消费者" + Thread.currentThread().getName()
                        + "】消费了一个产品，现库存" + list.size());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
       // }

    }
}
