package com.swinburne.au;

/**
 * Created by lhao on 7/4/17.
 */
public class Resource {

    private static volatile int Total = 1000;

    private int cores;

    public Resource(int cores) {
        this.cores = cores;
        Total = Total - cores;
    }

    public int getCores() {
        return cores;
    }

    private void setCores(int cores){
        Total = Total + cores;
    }

    public void releaseCores(int cores){

        setCores(cores);
    }

    public int Remain(){

        return Total;
    }


}
