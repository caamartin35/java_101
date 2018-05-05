package main.interfaceExample;

public class Motorcycle implements Vehicle {

    private int speed;
    private int gear;

    // to change gear
    @Override
    public void changeGear(int newGear){
        gear = newGear;
    }

    // to increase speed (motorcycles increase speed faster than bicycles)
    @Override
    public void speedUp(int increment) {
        speed = speed + 2*increment;
    }

    // to decrease speed
    @Override
    public void applyBrakes(int decrement){
        speed = speed - decrement;
    }

    @Override
    public void honk() {
        System.out.println("HOONNNKK!");
    }

    public void printStates() {
        System.out.println("speed: " + speed
                + " gear: " + gear);
    }
}
