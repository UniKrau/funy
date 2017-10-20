package com.swinburne.au;



import org.apache.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhao on 7/4/17.
 */
public class TeraSortDeadline implements Deadline {

    private final static Logger LOG = Logger.getLogger(TeraSortDeadline.class);

    private boolean flag;

    public TeraSortDeadline(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        long a = System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(10, 250);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int starttime = ThreadLocalRandom.current().nextInt(12, 100);
        int endtime = ThreadLocalRandom.current().nextInt(201, 1000);

        if (flag) {
            if (endtime - starttime > 750)//850
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " TeraSortDeadline is killed ");
            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " TeraSortDeadline is finished ");
            }
        } else {

            if (endtime - starttime > 300) {

                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal TeleData is killed ");

            }

            else {
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " Normal TeleData is finished ");

            }
        }
    }


}