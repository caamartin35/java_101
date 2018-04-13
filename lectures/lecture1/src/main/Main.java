package main;

public class Main {

    public static void main(String[] args) {
        Car myHonda = new Car();
        Car myNissan = new Car();

        myHonda.setMake("Honda");
        myHonda.setModel("Civic");

        myNissan.setMake("Nissan");
        myNissan.setModel("Rogue");

        System.out.println("Make: " + myHonda.getMake()); // Prints "Make: Honda"
        System.out.println("Model: " + myHonda.getModel()); // Prints "Model: Civic"

        System.out.println("Make: " + myNissan.getMake()); // Prints "Make: Nissan"
        System.out.println("Model: " + myNissan.getModel()); // Prints "Model: Rogue"

        Car.honk(); // Honk the car!
        myHonda.honk(); // Why can we do this??

    }
}
