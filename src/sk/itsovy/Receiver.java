package sk.itsovy;
import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable{

    private Data load;

    public Receiver(Data load){ this.load = load; }

    @Override
    public void run()
    {
        for(String receivedMessage = load.receive();
            !"End".equals(receivedMessage);
            receivedMessage = load.receive())
        {
            System.out.print(receivedMessage + " ");

            try
            {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}