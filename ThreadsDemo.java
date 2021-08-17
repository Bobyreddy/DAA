/*
Write a Java program that implements a multi-thread application that has three threads.First thread generates a random integer for every 1 second; 
second thread computes the square of the number and prints; third thread will print the value of cube of the number.
*/

import java.util.Random;

class Synch {
    int RandomInteger;
    boolean valueset1 = false, valueset2 = false;

    synchronized void generate() {
        while (valueset1 || valueset2) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        Random rand = new Random();
        RandomInteger = rand.nextInt(10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
        }
        valueset1 = true;
        valueset2 = true;
        System.out.println(Thread.currentThread().getName() + ": The random no: generated is: " + RandomInteger);
        notifyAll();
    }

    synchronized void square() {
        while (!valueset1) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        }
        System.out.println(Thread.currentThread().getName() + " Square is " + RandomInteger * RandomInteger);
        valueset1 = false;
        notify();
    }

    synchronized void cube() {
        while (!valueset2) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        }
        System.out.println(
                Thread.currentThread().getName() + " : Cube is " + RandomInteger * RandomInteger * RandomInteger);
        valueset2 = false;
        notify();
    }
}

class Thread1 extends Thread {
    Synch target;

    Thread1(Synch target) {
        this.target = target;
        start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            target.generate();
        }
    }
}

class Thread2 extends Thread {
    Synch target;

    Thread2(Synch target) {
        this.target = target;
        start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            target.square();
        }
    }
}

class Thread3 extends Thread {
    Synch target;

    Thread3(Synch target) {
        this.target = target;
        start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            target.cube();
        }
    }
}

public class ThreadsDemo {
    public static void main(String[] args) {
        Synch obj1 = new Synch();
        new Thread1(obj1);
        new Thread2(obj1);
        new Thread3(obj1);
    }
}
