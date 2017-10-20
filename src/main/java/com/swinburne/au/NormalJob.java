package com.swinburne.au;

import org.apache.log4j.Logger;


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhao on 7/24/17.
 */
class NormalJob implements Deadline {

    private final Logger LOG = Logger.getLogger(NormalJob.class);

    private boolean flag;

    public NormalJob(boolean flag) {
        this.flag = flag;
    }



    @Override
    public void run() {

            long a = System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(0, 150);

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int starttime = ThreadLocalRandom.current().nextInt(12, 100);
            int endtime = ThreadLocalRandom.current().nextInt(111, 1000);
            if (endtime - starttime > 400)
                LOG.info("arrival time " + a +
                        " start offset " + starttime +
                        " end offset " + endtime +
                        " normal is killed ");
            else
                LOG.info("arrival time " + a +
                        " start offset " + ThreadLocalRandom.current().nextInt(12, 100) +
                        " end offset " + ThreadLocalRandom.current().nextInt(1000, 9000) +
                        " normal is finished " );
    }


}
