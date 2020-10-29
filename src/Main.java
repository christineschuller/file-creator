import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {



        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);

        ReaderThread reader = new ReaderThread(queue);
        CreatorThread writer = new CreatorThread(queue);

        new Thread(reader).start();
        new Thread(writer).start();


}
}