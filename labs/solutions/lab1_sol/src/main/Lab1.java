package main;

// It is recommended that you solve these problems in the order given,
// from top to bottom of this file.

// For each problem, carefully read the COMMENT at the head of the method,
// and then carefully review the TEST CASES (in the "assert" statements of
// the test method, just below the given method), as these really help
// clarify the details of the problem.

public class Lab1 {

    ////////////////////////////////////////////////////
    /// 1.  isOdd
    ////////////////////////////////////////////////////

    // This method takes an integer and returns true if it is odd,
    // and false otherwise.
    public static boolean isOdd(int x) {
        return x % 2 != 0;
    }

    public static void testIsOdd() {
        System.out.print("Testing isOdd... ");
        assert(isOdd(0) == false);
        assert(isOdd(17) == true);
        assert(isOdd(18) == false);
        assert(isOdd(-17) == true);
        assert(isOdd(-18) == false);
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// 2.  maxOf3
    ////////////////////////////////////////////////////

    // This method takes 3 integers and returns the value of the largest integer.
    public static int maxOf3(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }

    public static void testMaxOf3() {
        System.out.print("Testing maxOf3... ");
        assert(maxOf3(1, 2, 3) == 3);  // 3rd is max
        assert(maxOf3(1, 3, 2) == 3);  // 2nd is max
        assert(maxOf3(3, 1, 2) == 3);  // 1st is max
        assert(maxOf3(1, 2, -3) == 2); // one negative
        assert(maxOf3(-1, -2, -3) == -1); // all negative
        assert(maxOf3(1, 1, 0) == 1);  // duplicate values
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// 3.  medianOf3
    ////////////////////////////////////////////////////

    // This method takes 3 integers and returns the median, or middle, value of
    // the three.  Note:  to solve this problem, you must call the
    // maxOf3 method you wrote above.
    public static int medianOf3(int x, int y, int z) {
        return maxOf3(Math.min(x, y), Math.min(x, z), Math.min(y, z));
    }

    public static void testMedianOf3() {
        System.out.print("Testing medianOf3... ");
        assert(medianOf3(2, 1, 3) == 2); // 1st is median
        assert(medianOf3(1, 2, 3) == 2); // 2nd is median
        assert(medianOf3(1, 3, 2) == 2); // 3rd is median
        assert(medianOf3(1, 2, -3) == 1); // one negative
        assert(medianOf3(-1, -2, -3) == -2); // all negative
        assert(medianOf3(1, 1, 0) == 1); // duplicate values
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// 4.  hundredsDigit
    ////////////////////////////////////////////////////

    // This method takes one integer and returns the value of that number's
    // hundreds digit (or 0 if it does not have a hundreds digit).
    public static int hundredsDigit(int i) {
        return Math.abs((i / 100) % 10);
    }

    public static void testHundredsDigit() {
        System.out.print("Testing hundredsDigit... ");
        assert(hundredsDigit(100) == 1);
        assert(hundredsDigit(123) == 1);
        assert(hundredsDigit(1234) == 2);
        assert(hundredsDigit(-1234) == 2);
        assert(hundredsDigit(0) == 0);
        assert(hundredsDigit(12) == 0);
        assert(hundredsDigit(-12) == 0);
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// 5.  distance
    ////////////////////////////////////////////////////

    // This method takes four doubles, x0, y0, x1, and y1, and returns a double
    // representing the distance from the point (x0,y0) to the point (x1,y1).
    // To do this, it uses the distance formula (the square root of the sum of
    // the squares of the differences in x and y).
    // Hint:  You may wish to use both Math.pow and Math.sqrt here.
    public static double distance(double x0, double y0, double x1, double y1) {
        return Math.sqrt(Math.pow(x0-x1, 2) + Math.pow(y0-y1, 2));
    }

    public static void testDistance() {
        System.out.print("Testing distance... ");
        assert(almostEqual(distance(0,0,0,0), 0));
        assert(almostEqual(distance(0,0,1,0), 1));
        assert(almostEqual(distance(1,0,0,0), 1));
        assert(almostEqual(distance(0,0,1,1), Math.sqrt(2)));
        assert(almostEqual(distance(0,0,-1,1), Math.sqrt(2)));
        assert(almostEqual(distance(4,3,1,7), 5));
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// 6.  isRightTriangle
    ////////////////////////////////////////////////////

    public static double maxOf3Double(double x, double y, double z) {
        return Math.max(Math.max(x, y), z);
    }

    public static double minOf3Double(double x, double y, double z) {
        return Math.min(Math.min(x, y), z);
    }

    public static double medianOf3Double(double x, double y, double z) {
        return maxOf3Double(Math.min(x, y), Math.min(x, z), Math.min(y, z));
    }
    // This method takes six doubles describing three points (x0, y0), (x1, y1),
    // and (x2, y2), and returns true if the triangle connecting those points is
    // a right triangle and false otherwise.  How do you do that? First, find the
    // distances of each side. If we call those distances a, b, and c, where c is
    // the largest side, then the triangle is a right triangle if and only if
    // a^2 + b^2 = c^2 (by the converse of the Pythagorean Theorem).
    // Hint:  a^2 compiles, but does NOT mean "a squared".
    // For that, use a*a or Math.pow.
    // Hint: you should use the "distance" method you wrote, and also a variant
    // of the maxOf3 method you wrote (this time taking doubles instead of ints).
    public static boolean isRightTriangle(double x0, double y0,
                                          double x1, double y1,
                                          double x2, double y2) {
        // some code is provided for you...
        double s1 = distance(x0, y0, x1, y1);
        double s2 = distance(x0, y0, x2, y2);
        double s3 = distance(x1, y1, x2, y2);
        double c = maxOf3Double(s1, s2, s3);
        double a = minOf3Double(s1, s2, s3);
        double b = medianOf3Double(s1, s2, s3);
        // now, verify that a^2 + b^2 almost equals c^2.
        return almostEqual(Math.pow(a, 2) + Math.pow(b, 2), Math.pow(c, 2));
    }

    public static void testIsRightTriangle() {
        System.out.print("Testing isRightTriangle... ");
        assert(isRightTriangle(0,0,3,0,0,4)); // 3,4,5 triangle
        assert(isRightTriangle(0,0,-3,0,0,-4)); // another 3,4,5 triangle
        assert(!isRightTriangle(0,0,1,10,2,0)); // tall isosceles triangle
        // We will omit these tests, which deal with subtle issues
        // when the lengths of sides are smaller than our "almostEquals" tolerance.
        // double epsilon = 0.0001;
        // assert(!isRightTriangle(epsilon/10,0,0,0,-epsilon/10,0)); // all nearly the
        //                                                          // same points!
        // assert(isRightTriangle(0, 0, epsilon, 0, 0, epsilon)); // barely a triangle
        System.out.println("Passed all tests!");
    }

    ////////////////////////////////////////////////////
    /// 7.  dayOfWeek
    ////////////////////////////////////////////////////

    // This method takes a date represented by three integers,
    // the month (1-12), the day (1-31), and the year, and returns an
    // integer representing the day-of-week for that date, where
    // Sunday is 1, Monday is 2, and so on, and Saturday is 7.
    // While there are several ways to do this, you must use
    // this formula (from the most-excellent web site mathforum.org):
    //   N = d + 2m + [3(m+1)/5] + y + [y/4] - [y/100] + [y/400] + 2
    // Then the remainder when you divide N by 7 is the day-of-week,
    // where Saturday is 0 and Friday is 6.  Note that these values for
    // the days are not quite the same as those returned by this method.
    // Here is mathforum's description of the formula:
    //    "d is the number or the day of the month, m is the number
    //     of the month, and y is the year. The brackets around the
    //     divisions mean to drop the remainder and just use the
    //     integer part that you get.
    //     Also, a VERY IMPORTANT RULE is the number to use for the
    //     months for January and February. The numbers of these months
    //     are 13 and 14 of the PREVIOUS YEAR. This means that to find
    //     the day of the week of New Year's Day [of 1998], 1/1/98,
    //     you must use the date 13/1/97."
    // Note: you must make the adjustment to the month and year when
    // appropriate.  So, for example, the date of New Year's Day for
    // 1998 would be obtained in the natural way:  dayOfWeek(1, 1, 1998).
    // You may ignore the cases where the month, day, or year are out of bounds.

    public static int dayOfWeek(int month, int day, int year) {
        int dow = (day + 2*(month+(6*month*(2/month)))
            + (3*(month+(6*month*(2/month))+1)/5)
            + (year-(month*(2/month)/2))
            + ((year-(month*(2/month)/2))/4)
            - ((year-(month*(2/month)/2))/100)
            + ((year-(month*(2/month)/2))/400) + 2) % 7;
        System.out.println(dow);
        return dow + 7*(1/(dow + 1));
    }

    public static void testDayOfWeek() {
        System.out.print("Testing dayOfWeek... ");
        // On 2/5/2006, the Steelers won Super Bowl XL on a Sunday!
        assert(dayOfWeek(2, 5, 2006) == 1);
        // On 6/15/1215, the Magna Carta was signed on a Monday!
        assert(dayOfWeek(6, 15, 1215) == 2);
        // On 3/11/1952, the author Douglas Adams was born on a Tuesday!
        assert(dayOfWeek(3, 11, 1952) == 3);
        // on 4/12/1961, Yuri Gagarin became the first man in space, on a Wednesday!
        assert(dayOfWeek(4, 12, 1961) == 4);
        // On 7/4/1776, the Declaration of Independence was signed on a Thursday!
        assert(dayOfWeek(7, 4, 1776) == 5);
        // on 1/2/1920, Isaac Asimov was born on a Friday!
        assert(dayOfWeek(1, 2, 1920) == 6);
        // on 10/11/1975, Saturday Night Live debuted on a Saturday (of course)!
        assert(dayOfWeek(10, 11, 1975) == 7);
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
        System.out.println("***** Testing easier methods *******");
        testIsOdd();
        testMaxOf3();
        testMedianOf3();

        System.out.println("\n\n***** Testing medium methods *******");
        testHundredsDigit();
        testDistance();

        System.out.println("\n\n***** Testing harder methods *******");
        testIsRightTriangle();
        testDayOfWeek();
    }

    ////////////////////////////////////////////////////
    /// main method
    ////////////////////////////////////////////////////

    public static void main(String[] args) {
        checkAssertsAreEnabled();
        testAll();
    }
}
