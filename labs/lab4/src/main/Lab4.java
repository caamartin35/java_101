package main;

// Lab4.java
// <Name, Andrew ID, Section>

// Note:  You may not use Java concepts we have not yet covered,
// including arrays, or methods from any classes in java.util.* to
// solve these problems.  Also, you may only use the charAt and length
// methods from the String class. While these other methods or techniques
// may be helpful, every problem here is solvable without them.

public class Lab4 {

    ////////////////////////////////////////////////////
    /// factorial
    ////////////////////////////////////////////////////

    // This method takes an int x and returns the value
    // of x!, that is, x factorial, which is the product
    // of x * (x-1) * ... * 2 * 1.  Note that 0! equal 1.
    // The method returns -1 for any negative parameter.
    public static int factorial(int x) {
        return 42;
    }

    public static void testFactorial() {
        System.out.print("Testing factorial... ");
        assert(factorial(0) == 1);
        assert(factorial(1) == 1);
        assert(factorial(2) == 2);
        assert(factorial(3) == 6);
        assert(factorial(4) == 24);
        assert(factorial(5) == 120);
        assert(factorial(6) == 720);
        assert(factorial(-1) == -1);
        assert(factorial(-3) == -1);
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// gcd
    ////////////////////////////////////////////////////

    // This method takes two ints, x and y, and returns their
    // greatest common divisor, or gcd, using Euclid's method.
    // Returns -1 if x or y is non-positive.
    // According to Euclid, the gcd(x,y) == gcd(y,r), where
    // r is the remainder when x is divided by y.  This process
    // is continued until y equal 0, at which point x is the gcd.
    // Let's see it in action, finding the gcd of 100 and 80:
    //  gcd(100, 80) = gcd(80,20)  20 is the remainder of 100 / 80
    //               = gcd(20, 0)  0 is the remainder of 80 / 20
    // So the gcd of 100 and 80 is 20, which is correct.
    public static int gcd(int x, int y) {
        return 42;
    }

    public static void testGcd() {
        System.out.print("Testing gcd... ");
        assert(gcd(5,4) == 1);
        assert(gcd(100,80) == 20);
        assert(gcd(100,150) == 50);
        assert(gcd(1,33) == 1);
        assert(gcd(0, 204) == -1);
        assert(gcd(204, 0) == -1);
        assert(gcd(2*2*2*3*3*5*11*11,2*2*3*3*3*11*17) == (2*2*3*3*11));
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// lcm
    ////////////////////////////////////////////////////

    // This method takes two ints, x and y, and returns their
    // least common multiple, or lcm, or -1 if x or y is non-positive.
    // This does not require a loop, actually, because the product
    // of the lcm(x,y) and the gcd(x,y) equal the product x*y,
    // so we can use the gcd method to find the lcm.
    public static int lcm(int x, int y) {
        return 42;
    }

    public static void testLcm() {
        System.out.print("Testing lcm... ");
        assert(lcm(5,4) == 20);
        assert(lcm(100,80) == 400);
        assert(lcm(100,150) == 300);
        assert(lcm(1,33) == 33);
        assert(lcm(0, 204) == -1);
        assert(lcm(204, 0) == -1);
        assert(lcm(2*2*2*3*3*5*11*11,2*2*3*3*3*11*17) == (2*2*2*3*3*3*5*11*11*17));
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// indexOf
    ////////////////////////////////////////////////////

    // This method takes a String s and a char c, and returns
    // the first index in s where c occurs.  If c does not occur
    // in s (or if s is null), the method returns -1.
    public static int indexOf(String s, char c) {
        return 42;
    }

    public static void testIndexOf() {
        System.out.print("Testing indexOf... ");
        assert(indexOf("",'a') == -1);
        assert(indexOf("a",'a') == 0);
        assert(indexOf("abcd",'c') == 2);
        assert(indexOf("abcd",'d') == 3);
        assert(indexOf("a 1#1 a",'#') == 3);
        assert(indexOf("a 1#1 a",'1') == 2);
        assert(indexOf(null,'a') == -1);
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// lastIndexOf
    ////////////////////////////////////////////////////

    // This method takes a String s and a char c, and returns
    // the LAST index in s where c occurs.  If c does not occur
    // in s (or if s is null), the method returns -1.
    public static int lastIndexOf(String s, char c) {
        return 42;
    }

    public static void testLastIndexOf() {
        System.out.print("Testing lastIndexOf... ");
        assert(lastIndexOf("",'a') == -1);
        assert(lastIndexOf("a",'a') == 0);
        assert(lastIndexOf("abcd",'c') == 2);
        assert(lastIndexOf("abcd",'d') == 3);
        assert(lastIndexOf("a 1#1 a",'#') == 3);
        assert(lastIndexOf("a 1#1 a",'1') == 4);
        assert(lastIndexOf("a 1#1 a",'a') == 6);
        assert(lastIndexOf(null,'a') == -1);
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// isSubstring
    ////////////////////////////////////////////////////

    // This method takes two strings, s1 and s2, and returns
    // true if s2 is a substring of s1 -- that is, if all the
    // characters in s2 occur in succession somewhere within
    // s1 -- and false otherwise.
    // If either string is null, the method returns false.
    // Note: instead of using nested "for" loops, you might consider
    // placing the inner "for" loop inside a helper method.
    public static boolean isSubstring(String s1, String s2) {
        return false;
    }

    public static void testIsSubstring() {
        System.out.print("Testing isSubstring... ");
        assert(isSubstring("abc", "a") == true);
        assert(isSubstring("abc", "abc") == true);
        assert(isSubstring("abc", "abcd") == false);
        assert(isSubstring("ababcab", "abc") == true);
        assert(isSubstring("abc", "abcabc") == false);
        assert(isSubstring("abc", "") == true);
        assert(isSubstring("abc", null) == false);
        assert(isSubstring(null, null) == false);
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// nthHappyNumber
    ////////////////////////////////////////////////////

    // This method takes an int n and returns the nth happy number,
    // or -1 if n is not positive.  To learn about happy numbers,
    // check out the wikipedia page:
    // http://en.wikipedia.org/wiki/Happy_number
    // From this, we see that if n==1, the method should return 1, and if n==2,
    // the method should return 7.  And so on...
    // Hint:  you will want to use at least one well-chosen helper
    // method here!
    public static int nthHappyNumber(int n) {
        return 42;
    }

    public static void testNthHappyNumber() {
        System.out.print("Testing nthHappyNumber... ");
        assert(false); // You must replace this with your tests!
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
        testFactorial();
        testGcd();
        testLcm();
        testIndexOf();
        testLastIndexOf();
        testIsSubstring();
        testNthHappyNumber();
    }

    ////////////////////////////////////////////////////
    /// main method
    ////////////////////////////////////////////////////

    public static void main(String[] args) {
        checkAssertsAreEnabled();
        testAll();
    }
}