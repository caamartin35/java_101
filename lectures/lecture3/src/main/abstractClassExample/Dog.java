package main.abstractClassExample;

public class Dog extends Animal {
    public void bark() {
        makeSound();
    }
    @Override
    public void makeSound() {
        System.out.println("WOOF!!");
    }
}
