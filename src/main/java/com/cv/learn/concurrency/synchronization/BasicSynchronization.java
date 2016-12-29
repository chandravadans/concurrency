package com.cv.learn.concurrency.synchronization;

import java.util.Scanner;

class Processor extends Thread {
    private boolean running = true;
    @Override
    public void run() {
        while (running) {
            System.out.println("Processor running");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

public class BasicSynchronization {
    public static void main(String[] args) throws InterruptedException {
        Processor processor = new Processor();
        processor.start();

        System.out.println("Paused main thread. Press return to resume and stop running thread");
        Scanner in = new Scanner(System.in);
        in.nextLine();

        System.out.println("Stopping thread");
        processor.setRunning(false);
    }
}
