package com.swinburne.au;

import org.apache.log4j.Logger;


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author lhao
 */
public class Hdmi implements Deadline {


    boolean flag ;

    public Hdmi(boolean flag) {
        this.flag = flag;
    }

    private final static Logger LOG = Logger.getLogger(Hdmi.class);

    @Override
    public void run() {

        long a = System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(25, 250);

        try {
            TimeUnit.SECONDS.sleep(9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int starttime = ThreadLocalRandom.current().nextInt(12, 100);
        int endtime = ThreadLocalRandom.current().nextInt(201, 1000);

        if (flag) {

            //1050 1150
            int v = 750 ;
            if(endtime - starttime > v)
            {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " com.swinburne.au.Hdmi DeadLine is killed ");
            }
            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " com.swinburne.au.Hdmi DeadLine is finished ");
            }
        } else {

            if (endtime - starttime > 450) { // 450 //650

                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal com.swinburne.au.Hdmi DeadLine is killed ");

            }

            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal com.swinburne.au.Hdmi DeadLine is finished ");
            }
        }
    }
}
