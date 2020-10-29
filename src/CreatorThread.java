import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class CreatorThread implements Runnable{

    protected BlockingQueue<String> blockingQueue = null;

    public CreatorThread(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while(true){
            String buffer = null;
            try {
                buffer = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Check whether end of file has been reached
            if(buffer.equals("EOF")){
                break;
            }

            String fileSeparator = System.getProperty("file.separator");

            //absolute file name with path
            String absoluteFilePath = fileSeparator+"Users"+fileSeparator+"christine"+fileSeparator+buffer;
            File file = new File(absoluteFilePath);
            try {
                if(file.createNewFile()){
                    System.out.println(absoluteFilePath+" File Created");
                }else System.out.println("File "+absoluteFilePath+" already exists");
            } catch (IOException e) {
                e.printStackTrace();
            }

            //file name only
            file = new File(buffer);
            try {
                if(file.createNewFile()){
                    System.out.println(buffer + " File Created in Project root directory");
                }else System.out.println("File " + buffer + " already exists in the project root directory");
            } catch (IOException e) {
                e.printStackTrace();
            }

            //relative path
            String relativePath = "tmp"+fileSeparator+"file.txt";
            file = new File(relativePath);
            try {
                if(file.createNewFile()){
                    System.out.println(relativePath+" File Created in Project root directory");
                }else System.out.println("File "+relativePath+" already exists in the project root directory");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}

