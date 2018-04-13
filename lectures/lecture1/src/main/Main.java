package main;

public class Main {

    public static void main(String[] args) {
        Car myHonda = new Car();

        myHonda.setMake("Honda");
        myHonda.setModel("Civic");

        System.out.println("Make: " + myHonda.getMake()); // Prints "Make: Honda"
        System.out.println("Model: " + myHonda.getModel()); // Prints "Model: Civic"
    }
}
