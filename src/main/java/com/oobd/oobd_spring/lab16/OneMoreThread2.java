package com.oobd.oobd_spring.lab16;

public class OneMoreThread2 extends Thread{

    Runnable target;

    public OneMoreThread2(Runnable target) {
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
