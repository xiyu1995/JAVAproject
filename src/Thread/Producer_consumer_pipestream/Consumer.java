package Thread.Producer_consumer_pipestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Consumer extends Thread implements Runnable {
    private PipedInputStream pipedInputStream;

    public Consumer(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

    @Override
    public void run() {
        int len = -1;
        byte[] buffer = new byte[1024];
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                int count=pipedInputStream.available();
                if (count>0) {
                    System.out.println("rest product count: " + count);
                    System.out.println("get product: " + pipedInputStream.read());
                }
                //pipedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public PipedInputStream getPipedInputStram() {
        return pipedInputStream;
    }
}