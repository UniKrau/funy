package com.swinburne.au;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhao on 8/27/17.
 */
public class TeleDataEmpty implements Deadline {

    private final static Logger LOG = Logger.getLogger(TeleDataEmpty.class);
    private boolean flag;
    private int value;
    private int normal;

    static ExecutorService executors = Executors.newFixedThreadPool(1000);

    public TeleDataEmpty(boolean flag, int deadline, int normal) {
        this.flag = flag;
        this.value = deadline;
        this.normal = normal;

    }


    @Override
    public void run() {

        long a = System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(80, 150);

        try {
            TimeUnit.SECONDS.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int starttime = ThreadLocalRandom.current().nextInt(102, 500);
        int endtime = ThreadLocalRandom.current().nextInt(501, 2000);

        if (flag) {
            if (endtime - starttime > value)//1300 950
                ;

        } else {
            if (endtime - starttime > normal) {//1000 800

               ;

            }
        }
    }
}
