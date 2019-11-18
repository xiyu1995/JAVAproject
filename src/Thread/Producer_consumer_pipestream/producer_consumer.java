package Thread.Producer_consumer_pipestream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
//import Thread.Producer_consumer_await_signal.Consumer;

//import java.util.function.Consumer;

public class producer_consumer {
    public static void main(String[] args){
        PipedOutputStream pos=new PipedOutputStream();
        PipedInputStream pis=new PipedInputStream();
        //Producer p1=new Producer();
        //Consumer c1=new Consumer();
        try{
            pos.connect(pis);
            //p1.getPipedOutputStream().connect(c1.getPipedInputStram());
        }catch (IOException e){
            e.printStackTrace();
        }
        new Producer(pos).start();
        new Consumer(pis).start();

    }
}
