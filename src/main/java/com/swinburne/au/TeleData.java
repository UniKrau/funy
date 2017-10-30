package com.swinburne.au;
import org.apache.log4j.Logger;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by lhao on 8/27/17.
 */
public class TeleData implements Deadline {

    private final static Logger LOG = Logger.getLogger(TeleData.class);
    private boolean flag;
    private int value;
    private int normal;

    static ExecutorService executors = Executors.newFixedThreadPool(1000);

    public TeleData(boolean flag, int deadline, int normal) {
        this.flag = flag;
        this.value = deadline;
        this.normal = normal;

    }


    public static void main(String[] args) {
        // t_6000_1(1120, 950);
       //  t_6000_2(1120, 950);
        // t_6000_3(1150,960);
       // t_12000(1155, 970);
        //t_12000_2(1155, 970);
       // t_12000_3(1255, 900)
        // t_24000(1155, 970);
        t_24000_2(1155, 970);
       // t_24000_3(1155, 970);

    }


    static void empty(int deadline, int normal)
    {
        executors.execute(new TeleDataEmpty(false,deadline,normal));
        executors.execute(new TeleDataEmpty(true,deadline,normal));
    }
    static void t_6000_1(int deadline, int normal) {

        for (int i = 0; i < 4000; i++) {

            if (i < 2000) {

                executors.execute(new TeleData(true,deadline,normal));
                executors.execute(new TeleData(false,deadline,normal));
                empty(deadline, normal);
            } else if (2000 < i && i < 4000) {

                executors.execute(new TeleData(false,deadline,normal));
                empty(deadline, normal);
            }
        }

        executors.shutdown();
    }

    static void t_6000_2(int deadline, int normal) {
        for (int i = 0; i < 3000; i++) {
            empty(deadline, normal);
            executors.execute(new TeleData(true, deadline,normal));
            executors.execute(new TeleData(false, deadline,normal));
            empty(deadline, normal);
        }

        executors.shutdown();
    }

    static void t_6000_3(int deadline, int normal) {
        for (int i = 0; i < 4500; i++) {

            if (i < 1500) {
                empty(deadline, normal);
                executors.execute(new TeleData(true, deadline,normal));
                executors.execute(new TeleData(false, deadline,normal));

            } else if (1500 < i && i < 4500) {
                empty(deadline, normal);
                executors.execute(new TeleData(true, deadline,normal));
            }
        }
        executors.shutdown();

    }

    static void t_12000(int deadline, int normal) {

        for (int i = 0; i < 8000; i++) {

            if (i < 4000) {
                executors.execute(new TeleData(true, deadline,normal));
                executors.execute(new TeleData(false, deadline,normal));
                empty(deadline, normal);
            } else if (4000 < i && i < 8000) {
                empty(deadline, normal);
                executors.execute(new TeleData(false, deadline,normal));
            }
        }
        executors.shutdown();
    }

    static void t_12000_2(int deadline, int normal) {

        for (int i = 0; i < 6000; i++) {
            empty(deadline, normal);
             executors.execute(new TeleData(true, deadline,normal));
             executors.execute(new TeleData(false, deadline,normal));
        }
        executors.shutdown();
    }

    static void t_12000_3(int deadline, int normal) {

        for (int i = 0; i < 9000; i++) {

            if (i < 3000) {
                empty(deadline, normal);
                executors.execute(new TeleData(true, deadline,normal));
                executors.execute(new TeleData(false, deadline,normal));

            } else if( 3000 < i && i< 9000) {
                empty(deadline, normal);
                executors.execute(new TeleData(true, deadline,normal));
            }
        }
        executors.shutdown();
    }

    static void t_24000(int deadline, int normal) {

        for (int i = 0; i < 16000; i++) {
            if (i < 8000) {
                empty(deadline, normal);
                executors.execute(new TeleData(true, deadline,normal));
                executors.execute(new TeleData(false, deadline,normal));

            } else if ( 8000 < i && i < 16000) {
                empty(deadline, normal);
                executors.execute(new TeleData(false, deadline,normal));
            }
        }
        executors.shutdown();
    }

    static void t_24000_2(int deadline, int normal) {

        for (int i = 0; i < 12000; i++) {
                empty(deadline, normal);
                executors.execute(new TeleData(true,deadline,normal));
                executors.execute(new TeleData(false, deadline,normal));
        }
        executors.shutdown();
    }

    static void t_24000_3(int deadline, int normal) {

        for (int i = 0; i < 18000; i++) {
            if (i < 6000) {
                empty(deadline, normal);
                executors.execute(new TeleData(true, deadline,normal));
                executors.execute(new TeleData(false, deadline,normal));
            } else if (6000 < i && i < 18000){
                empty(deadline, normal);
                executors.execute(new TeleData(true, deadline,normal));
            }
        }
        executors.shutdown();
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
                LOG.info( a
                        +"," + starttime +
                        ","  + endtime +
                        " TeleData deadline is killed ");
            else {
                LOG.info( a +
                        " , " + starttime +
                        " , " + endtime +
                        " TeleData deadline is finished ");
            }
        } else {
            if (endtime - starttime > normal) {//1000 800

                LOG.info( a +
                        "," + starttime +
                        "," + endtime +
                        " Normal TeleData is killed ");

            } else {
                LOG.info( a +
                        " , " + starttime +
                        " , " + endtime +
                        " Normal TeleData is finished ");
            }
        }
    }
}
