package main;

// Do not modify the Hw8CokeMachine main class.  Make this code work
// by adding the appropriate classes with the appropriate methods as
// described by the test methods called by the main method.

// Note that you do not have to add any code to the test cases, though
// you do have to solve them with general-purpose solutions (and not just
// hard-code the example test cases!).

// Hint: to solve this incrementally, you may wish to comment out
// parts of the test code so the parts you have implemented will compile
// and can be tested as you go.

public class Lab8CokeMachine {
    public static void main(String[] args) throws Exception {
        testCokeMachineClass();
    }

    //////////////////////////////////
    // testCokeMachineClass
    //////////////////////////////////

    private static void testCokeMachineClass() {
        System.out.print("Running CokeMachine class tests...  ");
        // default constructor
        CokeMachine cm1 = new CokeMachine();
        assert(cm1.getBottleCount() == 100); // default starts with 100 bottles of coke
        assert(cm1.isEmpty() == false);
        assert(cm1.getBottleCost() == 125);  // $1.25 (125 cents) is the default cost for a coke
        assert(cm1.getPaidValue() == 0);     // default starts with no coins inserted

        // toString method
        assert(cm1.toString().equals("cokeMachine<bottles=100,cost=$1.25,paidValue=$0.00>"));

        // insert a dollar
        int change;
        change = cm1.insert(100);  // we paid $1.00, it costs $1.25, so change == -1
        // to indicate that not only is there on change, but
        // we still owe money
        assert(change == -1);
        assert(cm1.stillOwe() == 25);
        assert(cm1.toString().equals("cokeMachine<bottles=100,cost=$1.25,paidValue=$1.00>"));

        // insert a dime more
        change = cm1.insert(10);
        assert(change == -1);
        assert(cm1.stillOwe() == 15);
        assert(cm1.toString().equals("cokeMachine<bottles=100,cost=$1.25,paidValue=$1.10>"));

        // and insert a quarter more.  Here, we finally pay enough, so we get a bottle
        // and some change!
        change = cm1.insert(25);
        assert(change == 10);
        assert(cm1.stillOwe() == 125);  // this is for the NEXT bottle
        assert(cm1.toString().equals("cokeMachine<bottles=99,cost=$1.25,paidValue=$0.00>"));
        assert(cm1.getBottleCount() == 99);

        // second instance, with a different constructor
        CokeMachine cm2 = new CokeMachine(2,50); // 2 bottles, $0.50 each (and no initial paid value)
        assert(cm2.toString().equals("cokeMachine<bottles=2,cost=$0.50,paidValue=$0.00>"));

        // buy a couple bottles
        change = cm2.insert(25);
        assert(change == -1);
        assert(cm2.stillOwe() == 25);
        change = cm2.insert(25);
        assert(change == 0); // bought with exact change
        assert(cm2.isEmpty() == false);
        assert(cm2.getBottleCount() == 1);
        change = cm2.insert(100); // overpaid by $0.50
        assert(change == 50);
        assert(cm2.isEmpty() == true);
        assert(cm2.getBottleCount() == 0);
        assert(cm2.toString().equals("cokeMachine<bottles=0,cost=$0.50,paidValue=$0.00>"));

        // cannot buy anything more -- the machine is empty.
        // this is signified by returning -999 as the change
        change = cm2.insert(50);
        assert(change == -999);
        assert(cm2.isEmpty() == true);
        assert(cm2.getBottleCount() == 0);
        assert(cm2.toString().equals("cokeMachine<bottles=0,cost=$0.50,paidValue=$0.00>"));

        // addBottles method
        cm2.addBottles(50);
        assert(cm2.isEmpty() == false);
        assert(cm2.getBottleCount() == 50);
        change = cm2.insert(50);
        assert(change == 0);
        assert(cm2.toString().equals("cokeMachine<bottles=49,cost=$0.50,paidValue=$0.00>"));

        // independence of two instances
        assert(cm1.getBottleCount() == 99);
        assert(cm2.getBottleCount() == 49);
        System.out.println("Passed all tests!!!");
    }
}

//////////////////////////////////
// CokeMachine class
//////////////////////////////////

class CokeMachine {
    // ADD CODE HERE!!!
}
