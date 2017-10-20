package com.swinburne.au;
import org.apache.log4j.Logger;


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhao on 9/3/17.
 */
public class NPIR implements Deadline {

    private final static Logger LOG = Logger.getLogger(NPIR.class);

    boolean flag ;

    public NPIR(boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run() {

        long a = System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(20, 250);

        try {
            TimeUnit.SECONDS.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int starttime = ThreadLocalRandom.current().nextInt(12, 100);
        int endtime = ThreadLocalRandom.current().nextInt(201, 1000);

        if (flag) {
            if (endtime - starttime > 650)//1050 650
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " com.swinburne.au.NPIR DeadLine is killed ");
            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " com.swinburne.au.NPIR DeadLine is finished ");
            }
        } else {

            if (endtime - starttime > 450) { // 450 //500

                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal com.swinburne.au.NPIR DeadLine is killed ");

            }

            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal com.swinburne.au.NPIR DeadLine is finished ");

            }
        }
    }

}
