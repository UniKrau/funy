package com.swinburne.au;


import org.apache.log4j.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lhao on 7/29/17.
 */
public class TestJobs {

    private final static Logger LOG = Logger.getLogger(TestJobs.class);

    ExecutorService executors = Executors.newFixedThreadPool(1000);

    public static void main(String[] args) {

        int deadline = 950;
        int normal = 450;
        //new TestJobs().MixedType(deadline, normal);
        new TestJobs().MixedType_1(deadline, normal);

    }


    void MCase_1(){

        for (int i = 0; i < 5700 ; i++) {

            if( 0<i && i < 1000)
            {

               jobs();

            }
            if( 1000 < i && i< 1700){

                executors.submit(new NPIR(true));
                executors.submit(new NPIR(false));
                executors.submit(new Hdmi(false));
                executors.submit(new Hlf(false));
            }

            if( 1700 < i && i< 2000){

                executors.submit(new NPIR(true));
                executors.submit(new NPIR(false));
                executors.submit(new Hlf(false));


            }

            if( 2000 < i && i< 2600){

                executors.submit(new NPIR(false));
                executors.submit(new Hlf(false));

            }
            if( i > 2600 && i < 3700){
                executors.submit(new NPIR(false));

            }

        }

        executors.shutdown();

    }

    void MCase_2(){

        for (int i = 0; i < 3100; i++) {

            if ( i<500){

                jobs();
            }
            if ( 500 < i && i < 1700){
                executors.submit(new NPIR(true));
                executors.submit(new NPIR(false));

                executors.submit(new Hlf(false));

                executors.submit(new Hdmi(false));
            }

            if ( 1700 < i && i < 2200 ){

                executors.submit(new NPIR(true));

                executors.submit(new Hlf(false));
                executors.submit(new Hdmi(false));


            }
            if(2200 < i && i < 2700 ){
                executors.submit(new NPIR(true));
                executors.submit(new Hlf(false));
            }

            if( 2700 < i && i< 3000){
                executors.submit(new NPIR(true));
                executors.submit(new Hlf(false));

            }
            if( 3000 < i && i< 3100){

                executors.submit(new Hlf(false));

            }
        }

        executors.shutdown();
    }


    void MCase_3(){

        for (int i = 0; i < 4000 ; i++) {

            if( i< 1000){
                jobs();
            }

            if( 1000 <i && i < 1600){

                executors.submit(new NPIR(false));

                executors.submit(new Hlf(true));
                executors.submit(new Hlf(false));

                executors.submit(new Hdmi(false));
            }

            if ( 1600 < i && i < 1700){
                executors.submit(new NPIR(false));

                executors.submit(new Hlf(true));

                executors.submit(new Hdmi(false));
            }

            if(1700 < i && i < 2000){
                executors.submit(new NPIR(false));

                executors.submit(new Hlf(true));

            }
            if(2000 < i && i < 4700){
                executors.submit(new NPIR(false));

            }
        }
        executors.shutdown();

    }


    void MCase_4(){
        for (int i = 0; i < 3600 ; i++) {

            if( i < 1000)
            {
                jobs();
            }

            if ( 1000 < i && i< 1600)
            {
                executors.submit(new NPIR(true));
                executors.submit(new NPIR(false));

                executors.submit(new Hlf(true));
                executors.submit(new Hlf(false));

                executors.submit(new Hdmi(false));
            }

            if( 1600 < i && i < 1700){

                executors.submit(new NPIR(true));
                executors.submit(new NPIR(false));

                executors.submit(new Hlf(true));
                executors.submit(new Hdmi(false));

            }
            if ( 1700 < i && i < 2000){

                executors.submit(new NPIR(true));
                executors.submit(new NPIR(false));

                executors.submit(new Hlf(true));
            }
            if( 2000 < i && i < 2700){
                executors.submit(new NPIR(true));
                executors.submit(new NPIR(false));
            }
            if( 2700 < i && i < 3000){
                executors.submit(new NPIR(true));
            }
        }
        executors.shutdown();
    }

    void MCase_5(){

        for (int i = 0; i < 4700 ; i++) {

            if( i < 1000 ){
                executors.submit(new NPIR(true));
                executors.submit(new NPIR(false));

                executors.submit(new Hlf(true));

                executors.submit(new Hdmi(true));
                executors.submit(new Hdmi(false));
            }
            if( 1000 < i && i < 1300)
            {
                executors.submit(new NPIR(false));

                executors.submit(new Hlf(true));

                executors.submit(new Hdmi(true));
                executors.submit(new Hdmi(false));

            }
            if( 1300 < i && i < 1400){

                executors.submit(new NPIR(false));

                executors.submit(new Hlf(true));

                executors.submit(new Hdmi(true));
            }
            if( 1400 < i && i < 3600){

                executors.submit(new NPIR(false));

                executors.submit(new Hlf(true));

            }
            if( 3600< i &&i< 4700)
            {
                executors.submit(new NPIR(false));

            }

        }
        executors.shutdown();
    }

    void MCase_6(){

        for (int i = 0; i < 4000 ; i++) {

            if( i < 1000){

                jobs();
            }
            if ( 1000 < i && i < 1700){
                executors.submit(new NPIR(true));
                executors.submit(new NPIR(false));


                executors.submit(new Hlf(false));

                executors.submit(new Hdmi(false));

            }
            if ( 1700 < i && i < 2600){
                executors.submit(new NPIR(true));
                executors.submit(new Hlf(false));

            }

            if ( 2600 < i &&  i < 4000){
                executors.submit(new NPIR(true));

            }
        }
        executors.shutdown();

    }

    void jobs(){

        executors.submit(new NPIR(true));
        executors.submit(new NPIR(false));

        executors.submit(new Hlf(true));
        executors.submit(new Hlf(false));

        executors.submit(new Hdmi(true));
        executors.submit(new Hdmi(false));

    }

    void MixTJobs(int deadline , int normal){

        executors.execute(new PiDeadline(true, deadline , normal));
        executors.execute(new MacllDeadline(true, deadline , normal));
        executors.execute(new RWDeadLine(true, deadline , normal));

        executors.execute(new PiDeadline(false, deadline , normal));
        executors.execute(new MacllDeadline(false, deadline , normal));
        executors.execute(new RWDeadLine(false, deadline , normal));

    }

    void MixTFalse(int deadline, int normal){

        executors.execute(new PiDeadline(false, deadline , normal));
        executors.execute(new MacllDeadline(false, deadline , normal));
        executors.execute(new RWDeadLine(false, deadline , normal));

    }
    void MixedType(int deadline, int normal){

        for (int i = 0; i < 2667; i++) {

            if(i < 1333){

                MixTJobs(deadline , normal);

            }else if( i > 1333){

                MixTFalse(deadline , normal);
            }
        }

        executors.shutdown();
    }

    void MixedType_1(int deadline, int normal){

        for (int i = 0; i < 3500; i++) {

            if( i < 500){
                MixTJobs(deadline,normal);
            }
            if(500 < i && i < 1000){
                executors.execute(new PiDeadline(true, deadline , normal));
                executors.execute(new MacllDeadline(true, deadline , normal));
                MixTFalse(deadline,normal);
            }
            if( 1000 < i && i < 1500){
                executors.execute(new PiDeadline(false, deadline , normal));
                executors.execute(new MacllDeadline(true, deadline , normal));
                executors.execute(new MacllDeadline(false, deadline , normal));
                executors.execute(new RWDeadLine(false, deadline , normal));

            }
            if( 1500 < i && i < 2000){

                executors.execute(new PiDeadline(false, deadline , normal));
                executors.execute(new MacllDeadline(true, deadline , normal));
                executors.execute(new RWDeadLine(false, deadline , normal));

            }
            if( 2000 < i && i < 2500){
                executors.execute(new PiDeadline(false, deadline , normal));
                executors.execute(new MacllDeadline(true, deadline , normal));
                executors.execute(new RWDeadLine(false, deadline , normal));

            }
            if( 2500 < i && i < 3000){
                executors.execute(new PiDeadline(false, deadline , normal));
                executors.execute(new RWDeadLine(false, deadline , normal));

            }
            if( 3000 < i && i < 3500){
                executors.execute(new RWDeadLine(false, deadline , normal));

            }
        }
        executors.shutdown();
    }

    void MixedType_2(int deadline, int normal){

        for (int i = 0; i < 4000; i++) {

            if( i < 2000){

                executors.execute(new PiDeadline(true, deadline , normal));
                executors.execute(new MacllDeadline(false, deadline , normal));
                executors.execute(new RWDeadLine(true, deadline , normal));
            }
            if( 2000 <i && i < 4000){
                MixTFalse(deadline,normal);

            }
        }
        executors.shutdown();
    }

    void MixedType_3(int deadline, int normal){

        for (int i = 0; i < 2000; i++) {

            MixTJobs(deadline,normal);
        }
        executors.shutdown();
    }

    void MixedType_4(int deadline, int normal)
    {

        for (int i = 0; i < 2000; i++) {

            executors.execute(new PiDeadline(false, deadline , normal));
            executors.execute(new PiDeadline(false, deadline , normal));

            executors.execute(new MacllDeadline(true, deadline , normal));
            executors.execute(new MacllDeadline(true, deadline , normal));

            executors.execute(new RWDeadLine(true, deadline , normal));
            executors.execute(new RWDeadLine(false, deadline , normal));

        }

        executors.shutdown();
    }

    void MixedType_5(int deadline, int normal){

        for (int i = 0; i < 3000 ; i++) {

            if( i < 1000){
                MixTJobs(deadline, normal);
            }
            else if( 1000 < i && i < 1500){

                executors.execute(new MacllDeadline(true, deadline , normal));
                executors.execute(new RWDeadLine(true, deadline , normal));

                executors.execute(new PiDeadline(false, deadline , normal));
                executors.execute(new MacllDeadline(false, deadline , normal));
                executors.execute(new RWDeadLine(false, deadline , normal));
            }
            else if( 1500 < i && i < 2500){
                executors.execute(new PiDeadline(false, deadline , normal));
                executors.execute(new MacllDeadline(true, deadline , normal));
                executors.execute(new RWDeadLine(true, deadline , normal));

            }
            else if( 2500 < i && i < 3000){
                executors.execute(new PiDeadline(false, deadline , normal));

            }
        }

        executors.shutdown();
    }
}
