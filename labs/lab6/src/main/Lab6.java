package main;

import java.util.*;

public class Lab6 {

    ////////////////////////////////////////////////////
    /// count
    ////////////////////////////////////////////////////

    // This method takes an int array "a" and an int "x",
    // and returns the number of times the value "x"
    // occurs in the array "a".  The method returns 0
    // if "x" does not occur, or if "a" is null.
    public static int count(int[] a, int x) {
        return 42;
    }

    public static void testCount() {
        System.out.print("Testing count().... ");
        int[] a = new int[]{1, 2, 3, 2, 3, 4};
        assert(count(a,1) == 1);
        assert(count(a,2) == 2);
        assert(count(a,3) == 2);
        assert(count(a,4) == 1);
        assert(count(a,5) == 0);
        a = new int[] { }; // empty array
        assert(count(a,22) == 0);
        assert(count(null, 22) == 0);
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// hasDuplicates
    ////////////////////////////////////////////////////

    // This method takes an int array "a" and returns true
    // if that array contains any duplicates -- that is,
    // if any numbers occur more than once in the array --
    // and false otherwise.  The method returns false
    // if "a" is null.
    // Note that you do not have to be especially efficient
    // in your solution here.  For example, it is acceptable
    // to solve this using the "count" method you just wrote,
    // even though that is not the most efficient approach.
    public static boolean hasDuplicates(int[] a) {
        return false;
    }

    public static void testHasDuplicates() {
        System.out.print("Testing hasDuplicates().... ");
        int[] a = new int[]{1, 2, 3, 2, 3, 4};
        assert(hasDuplicates(a) == true);
        a = new int[] { 1, 2, 3 };
        assert(hasDuplicates(a) == false);
        a = new int[] { }; // empty array
        assert(hasDuplicates(a) == false);
        assert(hasDuplicates(null) == false);
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// removeOdds
    ////////////////////////////////////////////////////

    // This method takes an int array "a" and returns a new
    // int array that is the same as "a" but with all the odd
    // values removed, and all the even values occurring in the
    // same order.  If "a" is null, the method returns null.
    // Hint: you may want to use a helper method named "countOdds".
    public static int[] removeOdds(int[] a) {
        return null;
    }

    public static void testRemoveOdds() {
        System.out.print("Testing removeOdds().... ");
        int[] a = new int[]{1, 2, 3, 2, 3, 4};
        int[] b = new int[]{   2,    2,    4};
        assert(Arrays.equals(removeOdds(a), b));
        a = new int[] { 2, 4, 6 };
        b = new int[] { 2, 4, 6 };
        assert(Arrays.equals(removeOdds(a), b));
        a = new int[] { 1, 3, 5 };
        b = new int[] { };
        assert(Arrays.equals(removeOdds(a), b));
        a = new int[] { };
        b = new int[] { };
        assert(Arrays.equals(removeOdds(a), b));
        a = null;
        b = null;
        assert(Arrays.equals(removeOdds(a), b));
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// reverse
    ////////////////////////////////////////////////////

    // This method takes an int array "a" and returns a new
    // int array that is the same as "a" but with all the values
    // in reverse order.  Just to be different, in this method,
    // if "a" is null, the method returns an empty array (an array
    // of size 0) rather than a null array.
    public static int[] reverse(int[] a) {
        return null;
    }

    public static void testReverse() {
        System.out.print("Testing reverse().... ");
        int[] a = new int[]{1, 2, 3, 2, 3, 4};
        int[] b = new int[]{4, 3, 2, 3, 2, 1};
        assert(Arrays.equals(reverse(a), b));
        a = new int[] { 2, 4, 6 };
        b = new int[] { 6, 4, 2 };
        assert(Arrays.equals(reverse(a), b));
        a = new int[] { };
        b = new int[] { };
        assert(Arrays.equals(reverse(a), b));
        a = null;
        b = new int[] { };
        assert(Arrays.equals(reverse(a), b));
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// sumOfDiceOdds
    ////////////////////////////////////////////////////

    // This method basically confirms the data in this table:
    // http://wizardofodds.com/gambling/dice2.html
    // The table gives the odds of a given sum when rolling various
    // numbers of 6-sided dice.

    // Specifically, this method takes two parameters -- the number of
    // 6-sided dice and the desired sum -- and it returns as a double value the
    // probability of rolling that sum with that many dice.  The method
    // does this using Monte Carlo methods, using 1 million trials where
    // each trial consists of rolling the given number of 6-sided dice one time
    // and succeeding if they produce the given sum.

    // Note: Our test method's version of almostEqual (to compare your results
    // against the expected results) will use a "large" epsilon of 0.001 since
    // Monte Carlo methods are only approximate, and with only one million trials,
    // we will not get very precise results.

    // Also note:  given the nature of Monte Carlo methods, there is some small
    // (perhaps very small) chance that your code would "work" and yet
    // occasionally fail a test.  So, if your code "almost always" passes the
    // tests, then consider it correct!

    public static double sumOfDiceOdds(int dice, int targetSum) {
        return 42;
    }

    // Helper method for testSumOfDiceOdds()
    public static boolean almostEqual(double d1, double d2) {
        // We will use a "large" epsilon since Monte Carlo methods
        // are only approximate, and with only one million trials,
        // we will not get very precise results.
        double epsilon = 0.001;
        return Math.abs(d2 - d1) < epsilon;
    }

    public static void testSumOfDiceOdds() {
        System.out.print("Testing sumOfDiceOdds().... ");
        // use data from
        // http://wizardofodds.com/gambling/dice2.html
        assert(almostEqual(sumOfDiceOdds( 1, 6), 0.166666666666667));
        assert(almostEqual(sumOfDiceOdds( 2, 8), 0.138888888888889));
        assert(almostEqual(sumOfDiceOdds( 3,15), 0.046296296296296 ));
        assert(almostEqual(sumOfDiceOdds( 5,22), 0.054012345679012 ));
        assert(almostEqual(sumOfDiceOdds(10,42), 0.032623693616742 ));
        assert(almostEqual(sumOfDiceOdds(10,61), 0 ));
        assert(almostEqual(sumOfDiceOdds(10, 9), 0 ));
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// additional test methods
    ////////////////////////////////////////////////////

    public static void checkAssertsAreEnabled() {
        boolean assertsEnabled = false;
        try { assert(false); }
        catch (Throwable t) { assertsEnabled = true; }
        if (!assertsEnabled)
            throw new RuntimeException("assert statements not enabled!");
    }

    public static void testAll() {
        checkAssertsAreEnabled();
        testCount();
        testHasDuplicates();
        testRemoveOdds();
        testReverse();
        testSumOfDiceOdds();
    }

    ////////////////////////////////////////////////////
    /// main method
    ////////////////////////////////////////////////////

    public static void main(String[] args) {
        testAll();
    }
}