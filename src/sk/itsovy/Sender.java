package sk.itsovy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable{

    private Data data;

    public Sender(Data data){ this.data = data; }

    @Override
    public void run()
    {
        String packet[] = generateNumbers();

        for (int i = 0; i<10; i++)
        {
            data.send(packet[i]);

            try
            {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    public String[] generateNumbers(){
        String[] nums = {"1","2","3","4","5","6","7","8","9","10"};
        List<String> numberList = Arrays.asList(nums);
        Collections.shuffle(numberList);

        String[] num = numberList.toArray(new String[numberList.size()]);
        return num;
    }
}