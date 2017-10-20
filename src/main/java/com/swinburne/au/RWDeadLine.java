package com.swinburne.au;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhao on 8/29/17.
 */
public class RWDeadLine implements Deadline {

    private final static Logger LOG = Logger.getLogger(RWDeadLine.class);

    private boolean flag;
    private int deadline;
    private int normal;

    public RWDeadLine(boolean flag, int deadline, int normal) {
        this.flag = flag;
        this.deadline = deadline;
        this.normal = normal;
    }

    @Override
    public void run() {

        long a = System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(9, 250);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int starttime = ThreadLocalRandom.current().nextInt(12, 100);
        int endtime = ThreadLocalRandom.current().nextInt(201, 1000);

        if (flag) {
            if (endtime - starttime > deadline )//850 650
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " RW DeadLine is killed ");
            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " RW DeadLine is finished ");
            }
        } else {

            if (endtime - starttime > normal ) { // 450 //300

                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal RW DeadLine is killed ");

            }

            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal RW DeadLine is finished ");

            }
        }
    }

}