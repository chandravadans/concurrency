package com.cv.learn.concurrency.synchronization;

public class Synchronized {
    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Synchronized s = new Synchronized();
        s.doStuff();

    }

    public void doStuff() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                count++;
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                count++;
        });

        //starting both threads
        t1.start();
        t2.start();

        //join() waits for threads to finish
        t1.join();
        t2.join();

        if (count != 200000) {
            throw new RuntimeException("Failed! Count isn't 200000. Its " + count);
        }
    }
}
