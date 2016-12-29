package com.cv.learn.concurrency.starting;

/**
 * Created by cv on 12/29/16.
 */

class ExtendingThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(this.getName() + " printing " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ImplementingRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(" printing " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class StartingThreads {
    public static void main(String[] args) {

        // Method 1. Extending Thread class
        /*System.out.println("************* Extending Thread ***************");
        ExtendingThread extendingThread = new ExtendingThread();
        //Don't call run, else it'll run on the calling thread
        extendingThread.start();

        ExtendingThread extendingThread1 = new ExtendingThread();
        extendingThread1.start();*/

        //Method 2. Implementing Runnable
        //Implementing Runnable interface
        /*System.out.println("****************** Implementing Runnable **********");
        Thread t1 = new Thread(new ImplementingRunnable());
        Thread t2 = new Thread(new ImplementingRunnable());
        t1.start();
        t2.start();*/

        //Method 3. In place, using lambdas. Similar to method 2, since Runnable is a functional interface
        System.out.println("******* Java 8, lambdas *******************");
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Printing " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();

    }
}
