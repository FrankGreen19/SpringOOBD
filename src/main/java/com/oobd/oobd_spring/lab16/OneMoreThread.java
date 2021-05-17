package com.oobd.oobd_spring.lab16;

public class OneMoreThread extends Thread {

    Runnable target;

    public OneMoreThread(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
        System.out.println("Thread: " + this.getName());
    }

}
