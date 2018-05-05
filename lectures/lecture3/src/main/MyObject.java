package main;

public class MyObject {
    private int myValue;

    public MyObject(int value) {
        this.myValue = value;
    }

    public void setValue(int value) {
        this.myValue = value;
    }

    public int getValue() {
        return this.myValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyObject) {
            return this.myValue == ((MyObject) obj).getValue();
        }
        return false;
    }
}
