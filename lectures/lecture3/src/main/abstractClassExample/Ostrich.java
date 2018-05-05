package main.abstractClassExample;

public class Ostrich extends Animal {
    int numLegs = 2;

    @Override
    public void makeSound() {
        System.out.println("CACAWW!!");
    }
}
