package main;

public class Car {
    private String make;
    private String model;
    private static String honk = "HOOONNNKKKKK!!!";

    public Car() {

    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public void setMake(String newMake) {
        this.make = newMake;
    }

    public void setModel(String newModel) {
        this.model = newModel;
    }

    public static void honk() {
        System.out.println(honk);
    }
}
