package main;

// Lab2.java
// <Name>, <andrew id>, <section>

// It is recommended that you solve these problems in the order given,
// from top to bottom of this file.

// For each problem, carefully read the COMMENT at the head of the method,
// and then carefully review the TEST CASES (in the "assert" statements of
// the test method, just below the given method), as these really help
// clarify the details of the problem.

class Lab2 {

    ////////////////////////////////////////////////////
    /// 1.  nearestBusStop
    ////////////////////////////////////////////////////

    // This method takes a street number (which you may assume is positive),
    // and returns the street number of the nearest bus stop, where buses
    // stop on streets that are multiples of 8 (8th, 16th, 24th, etc).
    // So it behaves as such:
    //   nearestBusStop(11) returns 8
    //   nearestBusStop(13) returns 16
    // But what about 12th street?  It is equally far from 8th and 16th
    // streets, but riders generally head towards town (0th street), and
    // so they prefer the lower bus stop.  Hence:
    //   nearestBusStop(12) returns 8
    // You can assume there is a bus stop on 0th street, and again you
    // can ignore the case where the street is negative).

    // Remember: do not use conditionals, loops, arrays, etc.
    // This can be done (in one line of code!) using only what we
    // have covered Week #1's notes (in fact, using just addition,
    // division and multiplication of integers).

    public static int nearestBusStop(int street) {
        return ((street + 3)/8) * 8;
    }

    public static void testNearestBusStop() {
        System.out.print("Testing nearestBusStop... ");
        assert(nearestBusStop(0) == 0);
        assert(nearestBusStop(4) == 0);
        assert(nearestBusStop(5) == 8);
        assert(nearestBusStop(8) == 8);
        assert(nearestBusStop(11) == 8);
        assert(nearestBusStop(12) == 8);
        assert(nearestBusStop(13) == 16);
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// 2.  xIntercept
    ////////////////////////////////////////////////////

    // This method takes 2 doubles representing the line y=mx+b,
    // and returns the value of the x-intercept.  You are assured
    // that the line has an x-intercept.

    public static double xIntercept(double m, double b) {
        return -b / m; // replace this with your answer!
    }

    public static void testXIntercept() {
        System.out.print("Testing xIntercept... ");
        assert(almostEqual(xIntercept(3,0), 0)); // y=3x, x-int at x=0
        assert(almostEqual(xIntercept(2,-4), 2)); // y=2x-4, x-int at x=2
        assert(almostEqual(xIntercept(3,-4), 1.3333333)); // y=3x-4, x-int at x=4/3=1.333...
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// 3.  xInterceptOfParabola
    ////////////////////////////////////////////////////

    // This method takes 3 doubles representing the parabola y=ax^2+bx+c,
    // and returns the value of the SMALLER x-intercept (using the quadratic
    // formula).  You are assured the line has at least one x-intercept.

    public static double xInterceptOfParabola(double a, double b, double c) {
        return Math.min((-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a), (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a));
    }

    public static void testXInterceptOfParabola() {
        System.out.print("Testing xInterceptOfParabola... ");
        assert(almostEqual(xInterceptOfParabola(1,0,0), 0));  // y = x^2 has a zero at x=0
        assert(almostEqual(xInterceptOfParabola(1,0,-4), -2)); // y = x^2-4 has a zero at x=-2
        assert(almostEqual(xInterceptOfParabola(4,0,-4), -1)); // y = 4^2-4 has a zero at x=-1
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// 4.  isPerfectSquare
    ////////////////////////////////////////////////////

    // This method takes an integer n and returns true if n is a perfect square,
    // and false otherwise.
    public static boolean isPerfectSquare(int n) {
        return Math.pow(Math.sqrt(n), 2) == n;
    }

    public static void testIsPerfectSquare() {
        System.out.print("Testing isPerfectSquare... ");
        // on this and all problems where you write your own tests,
        // you should be thorough in testing all reasonable boundary cases.
        // Discuss what this means with your CA!
        assert(!isPerfectSquare(-1));
        assert(isPerfectSquare(0));
        assert(isPerfectSquare(1)); // <-- delete this line when you write your own tests!
        assert(!isPerfectSquare(2));
        assert(isPerfectSquare(4));
        assert(!isPerfectSquare(5));
        System.out.println("Passed all tests!");
    }


    ////////////////////////////////////////////////////
    /// 5.  toUpperCase
    ////////////////////////////////////////////////////

    // This method takes a char and, if that char is in lowercase,
    // converts it to uppercase.  However, if that char is not a lowercase
    // letter, then this method returns the original char.
    // NOTE #1: You may not use Strings in any way to solve this problem.
    // NOTE #2: You also may not use conditionals (which makes this harder,
    //          and a bit convoluted, to be sure!)
    // NOTE #3: You also may not use magic numbers like 65 or 97 here.
    // BIG USEFUL HINT:  For this method, you MAY use Math.signum.  Read
    // about it in the online API for Math (follow the link from the left
    // side of the course web site to the Java 1.5 API, then scroll through
    // the list of classes on the bottom left until you find Math, click on
    // it, then scroll down until you find the signum method.
    // How will this help?  Well, my solution used the following line:
    //   double atLeastSmallA = Math.signum(c+1-'a');
    // This must equal 1 for lowercase values (but it also will equal 1
    // for some non-lowercase values, so I used a second, similar test
    // involving 'z' rather than 'a'), then combined them arithmetically...

    public static char toUpperCase(char c) {
        return (char) (c + (Math.signum(c+1-'a') + Math.signum('z'-(c-1)))/2 * (-32));
    }

    public static void testToUpperCase() {
        System.out.print("Testing toUpperCase... ");
        assert(toUpperCase('a') == 'A');
        assert(toUpperCase('z') == 'Z');
        assert(toUpperCase('A') == 'A');
        assert(toUpperCase('Z') == 'Z');
        assert(toUpperCase('0') == '0'); // '0' has Unicode value 48
        assert(toUpperCase('~') == '~'); // '~' has Unicode value 126
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// almostEqual
    ///
    /// This method is used by test methods, so we supply
    /// it for you.  You must understand why it is needed
    /// (instead of "==" for doubles), and how it works.
    ////////////////////////////////////////////////////

    public static boolean almostEqual(double d1, double d2) {
        double epsilon = 0.0001; // change as needed for more/less precision
        return Math.abs(d1 - d2) < epsilon;
    }

    ////////////////////////////////////////////////////
    /// YOU ARE NOT RESPONSIBLE
    /// FOR ANY CODE BELOW THIS POINT
    ////////////////////////////////////////////////////

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
        testNearestBusStop();
        testXIntercept();
        testXInterceptOfParabola();
        testIsPerfectSquare();
        testToUpperCase();
    }

    ////////////////////////////////////////////////////
    /// main method
    ////////////////////////////////////////////////////

    public static void main(String[] args) {
        checkAssertsAreEnabled();
        testAll();
    }
}