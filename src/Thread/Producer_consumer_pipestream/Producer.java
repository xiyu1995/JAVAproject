package Thread.Producer_consumer_pipestream;

import sun.jvm.hotspot.runtime.Threads;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Producer extends Thread {
    private PipedOutputStream pipedOutputStream;

    public Producer(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    public PipedOutputStream getPipedOutputStream() {
        return pipedOutputStream;
    }

    //@Override
    public void run() {
        while (true) {
            try {
                for (int i = 0; i < 5; i++) {
                    pipedOutputStream.write(i);
                    //System.out.println();
                    //System.out.println();
                    System.out.println(pipedOutputStream.hashCode());
                }
                //pipedOutputStream.close();
                //}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public void start() {
//        run();
//    }
}
