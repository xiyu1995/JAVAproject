package threadPool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args)throws Exception{
        try (Scanner in=new Scanner(System.in))
        {
            System.out.print("Enter base dorectory (e.g. /usr/local/jdk5.0/src):");
            String directory=in.nextLine();
            System.out.print("enter keyword(e.g. volatile):");
            String keyword=in.nextLine();
            ExecutorService pool= Executors.newCachedThreadPool();
            MatchCounter counter=new MatchCounter(new File(directory),keyword,pool);
            Future<Integer> result=pool.submit(counter);
            try{
                System.out.println(result.get()+" matching files");
            }catch ( ExecutionException e ){
                e.printStackTrace();
            }catch ( InterruptedException e ){}
            pool.shutdown();
            int largestPoolSize =((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largest pool size="+largestPoolSize);
        }
    }

}
