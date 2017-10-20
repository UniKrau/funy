package com.swinburne.au;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhao on 7/4/17.
 */
public class PiDeadline implements Deadline {

    private final static Logger LOG = Logger.getLogger(PiDeadline.class);

    private boolean flag;
    private int deadline;
    private int normal;

    public PiDeadline(boolean flag, int deadline, int normal) {
        this.flag = flag;
        this.deadline = deadline;
        this.normal = normal;
    }


    @Override
    public void run() {

            long a = System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(10, 150);

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int starttime = ThreadLocalRandom.current().nextInt(12, 500);
            int endtime = ThreadLocalRandom.current().nextInt(111, 900);

            if (flag){
                if (endtime - starttime > deadline )//850 // 550

                    LOG.info("arrival time " + a +
                            " start offset " + starttime +
                            " end offset " + endtime +
                            " PiDeadline is killed ");
                else {
                    LOG.info("arrival time " + a +
                            " start offset " + starttime +
                            " end offset " + endtime +
                            " PiDeadline is finished ");
                }
            }

            else{
               if( endtime - starttime > normal ){//350 400
                   LOG.info("arrival time " + a +
                           " start offset " + ThreadLocalRandom.current().nextInt(12, 100) +
                           " end offset " + ThreadLocalRandom.current().nextInt(300, 5000) +
                           " Normal Pi is killed " );
               }
               else {
                   LOG.info("arrival time " + a +
                           " start offset " + ThreadLocalRandom.current().nextInt(12, 100) +
                           " end offset " + ThreadLocalRandom.current().nextInt(300, 5000) +
                           " Normal Pi is finished " );
                }
            }
    }
}