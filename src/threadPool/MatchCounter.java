package threadPool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MatchCounter implements Callable<Integer> {
    //@Override
    private int count;
    private File directory;
    private String keyword;
    private ExecutorService pool;
    public MatchCounter(File directory,String keyword,ExecutorService pool){
        this.directory=directory;
        this.keyword=keyword;
        this.pool=pool;
    }

    public Integer call() throws Exception {
        count=0;
        try{
            File[] files=directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            for(File file:files)
                if(file.isDirectory()){
                    MatchCounter counter=new MatchCounter(file,keyword,pool);
                    Future<Integer> result=pool.submit(counter);
                    results.add(result);
                }else{
                    if(search(file))count++;
                }
            for(Future<Integer> result:results)
                try{
                    count+=result.get();
                }catch( ExecutionException e ){
                    e.printStackTrace();
                }
        }catch ( InterruptedException e ){ }
        return count;
    }

    public boolean search(File file) {
        try{
            try(Scanner in=new Scanner(file,"UTF-8")){
                boolean found=false;
                while(!found && in.hasNextLine()){
                    String line=in.nextLine();
                    if (line.contains(keyword)) found=true;
                }
                return found;
            }
        } catch ( IOException e ) {
            return false;
        }
    }
}
