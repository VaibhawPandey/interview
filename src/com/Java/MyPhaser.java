package com.Java;

import java.util.concurrent.Phaser;

public class MyPhaser {

    public static void main(String[] args) {
        Phaser phaser=new Phaser();
        int currentThread=-1;

        new MyThread(phaser,"A");
        new MyThread(phaser,"B");
        new MyThread(phaser,"C");

        phaser.arriveAndAwaitAdvance();

        currentThread=phaser.getPhase();
        System.out.println("CT:- " +currentThread +" completed.");
        phaser.arriveAndAwaitAdvance();

        currentThread=phaser.getPhase();
        System.out.println("CT:- " +currentThread +" completed.");
        phaser.arriveAndAwaitAdvance();

        currentThread=phaser.getPhase();
        System.out.println("CT:- " +currentThread +" completed.");
        phaser.arriveAndAwaitAdvance();
    }

    static class MyThread implements Runnable{

        Phaser phaser;
        String name;
        MyThread(Phaser phaser,String name){
            this.phaser=phaser;
            this.name = name;

            this.phaser.register();
            new Thread(this).start();
        }

        @Override
        public void run() {

            System.out.println("Thread " +name +" started.P1 started.");
            phaser.arriveAndAwaitAdvance();

            System.out.println("Thread " +name +" started.P2 started.");
            phaser.arriveAndAwaitAdvance();

            System.out.println("Thread " +name +" started.P3 started.");
            phaser.arriveAndDeregister();


        }
    }
}
