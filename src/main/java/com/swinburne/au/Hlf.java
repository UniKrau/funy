package com.swinburne.au;

import org.apache.log4j.Logger;


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhao on 9/3/17.
 * @author lhao
 */
public class Hlf implements Deadline {


    boolean flag ;

    public Hlf(boolean flag) {
        this.flag = flag;
    }

    private final static Logger LOG = Logger.getLogger(Hlf.class);

    @Override
    public void run() {

        long a = System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(15, 250);

        try {
            TimeUnit.SECONDS.sleep(11);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int starttime = ThreadLocalRandom.current().nextInt(12, 100);
        int endtime = ThreadLocalRandom.current().nextInt(201, 1000);

        if (flag) {
            if (endtime - starttime > 750)//1050 850
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " com.swinburne.au.Hlf DeadLine is killed ");
            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " com.swinburne.au.Hlf DeadLine is finished ");
            }
        } else {

            if (endtime - starttime > 450) { // 450 //500

                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal com.swinburne.au.Hlf DeadLine is killed ");

            }

            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal com.swinburne.au.Hlf DeadLine is finished ");

            }
        }
    }

}
