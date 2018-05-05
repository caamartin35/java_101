package main.abstractClassExample;

public abstract class Animal {
    int numLegs = 4;

    boolean isRunning = false;

    public void run() {
        isRunning = true;
    }

    public void walk() {
        isRunning = false;
    }

    public abstract void makeSound();


}
