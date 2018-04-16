package main;

public class Main {

    public static boolean isOdd(int x) {
        if (x % 2 == 0){
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {
        String stringA = new String("Isenbike");
        String stringB = new String("Isenbike");
        System.out.println(stringA == stringB); //Prints false
        System.out.println(stringA.equals(stringB)); //Prints true;

//        int[] numberArray = new int[5];
//        numberArray[2] = 4;
//        System.out.println(numberArray[2]);
//        System.out.println(numberArray[1]);
//        System.out.println(numberArray[6]);
//        System.out.println(numberArray[-1]);
//
//        System.out.println(isOdd(0));
//        System.out.println(isOdd(1));
//        System.out.println(isOdd(2));
    }
}
