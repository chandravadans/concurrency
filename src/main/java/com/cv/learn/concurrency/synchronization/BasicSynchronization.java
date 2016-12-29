package com.cv.learn.concurrency.synchronization;

class Processor extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Processor running");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class BasicSynchronization {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();
    }
}
