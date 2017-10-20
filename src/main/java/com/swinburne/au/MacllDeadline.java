package com.swinburne.au;

import org.apache.log4j.Logger;


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhao on 7/4/17.
 */
public class MacllDeadline implements Deadline {

    private final static Logger LOG = Logger.getLogger(MacllDeadline.class);

    private boolean flag;
    private  int deadline;
    private int normal;
    public MacllDeadline(boolean flag, int deadline, int normal) {

        this.flag = flag;
        this.deadline = deadline;
        this.normal = normal;
    }


    @Override
    public void run() {

            long a = System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(20, 150);

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int starttime = ThreadLocalRandom.current().nextInt(12, 100);
            int endtime = ThreadLocalRandom.current().nextInt(111, 1000);
        if (flag) {
            if (endtime - starttime > deadline )//850 550
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " MacllDeadline is killed ");
            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " MacllDeadline is finished ");
            }
        } else {

            if (endtime - starttime > normal ) {//300 550

                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal Macll is killed ");

            }

            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal Macll is finished ");
            }

        }
    }


}