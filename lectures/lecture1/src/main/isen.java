package main;

public class isen {
    public static boolean isOdd ( int x) {
        if ((x % 2) == 1) {
            return true;
        } else {
            return false;
        }
    }
    public static void main (String[] args){
        System.out.println(isOdd(5));

    }
}
