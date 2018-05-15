package main.abstractClassExample;

public abstract class Animal {
    int numLegs = 4;
    State state = State.STILL;
    enum State{
        STILL,
        WALKING,
        RUNNING
    }

    public void run() {
        this.state = State.RUNNING;
    }

    public void walk() {
        this.state = State.WALKING;
    }

    public void stopMoving() {
        this.state = State.STILL;
    }

    public abstract void makeSound();


}
