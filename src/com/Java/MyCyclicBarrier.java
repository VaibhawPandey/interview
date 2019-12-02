package com.Java;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public  class MyCyclicBarrier implements Runnable {

    static CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
    public static void main(String[] args) {

        MyCyclicBarrier myCyclicBarrier = new MyCyclicBarrier();
        Thread thread=new Thread(myCyclicBarrier);
        thread.start();

    }
    @Override
    public void run() {

        Computation computation=new Computation();
        Computation1 computation1=new Computation1();

        Thread thread=new Thread(computation);
        Thread thread1=new Thread(computation1);

        thread.start();thread1.start();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(computation.product + computation1.sum);
        System.out.println();


    }

    static class Computation implements Runnable{

        public static int product=1;
        @Override
        public void run() {
            product = 2*20;
            try {
                MyCyclicBarrier.cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class Computation1 implements Runnable{

        public static int sum=0;
        @Override
        public void run() {
             sum = 4+5;
            try {
                MyCyclicBarrier.cyclicBarrier.await(100,TimeUnit.MILLISECONDS);
                System.out.println("WaitingThread:-" +cyclicBarrier.getNumberWaiting());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}
