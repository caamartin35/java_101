package main;

// How to do this lab assignment:
// First, run the demo version (simpleCalcDemo.jar), which shows how
// this program should work once it is completed.
// Second, find each @TODO in the code, starting with the one
// right below here -- these explain each step in the assignment.

// @TODO #1: study the code below.  Even though it has some
// bugs intentionally introduced (and left for you to debug),
// enough has been left in place for you to understand how the
// program works.  Be sure you do!
// Hint #1: Read the comments very carefully!!!
// Hint #2:  start from the "top" -- meaning, the main method (which
// is uninteresting in this case), the top-level paint method,
// and the top-level event handlers (timerFired, keyPressed,
// mousePressed), if present.
// A sample quiz question, for example, may be:
// Explain this line of getCurrentValue():
//     String valueString = (useLhs ? lhs : rhs);
// Hint: lhs == "left-hand side"
// Or:  what does the oops() method do?
// Or:  when a digit is entered, how exactly does the program know
// whether to add the digit to the lhs or the rhs?
// Or:  what does String.contains() do?
// Or:  where is drawCenterString defined (in the Java API?  Somewhere else?)?
// Or:  You get the idea...

// HINT: Your bug fixes will include calling the "oops" method (defined
// below) when certain errors are encountered.  In order to pass the autograder,
// you must provide the EXACT error message that is expected.  To help you,
// here are all the calls to oops() in the demo program:
//       oops("No negative exponents!");
//       oops("Division by zero!");
//       oops("Mod by zero!");
//       oops("Unknown operator: " + op.charAt(0));
//       oops("Nothing to negate!");
//       oops("Enter a number before the operator!");
//       oops("Only enter one operator!");
//       oops("Enter a binary expression first!");
//       oops("Unknown key: " + key);

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator extends JComponentWithEvents {

    // These 5 instance variables hold different parts of
    // the display string.  "lhs" is the left-hand side of the
    // expression.  "op" is the operator.  "rhs" is the right-hand side.
    // "result" is, of course, the result.  And the "errorMsg", if
    // non-null, contains the message displayed after some error
    // (see the list of calls to oops(), above, for the possible errors).
    // For example, here is how these variables' values change
    // as the user enters "1+23+=":
    //
    //   key  lhs   op    rhs    result  errorMsg
    //   '1'  "1"   null  null   null    null
    //   '+'  "1"   "+"   null   null    null
    //   '2'  "1"   "+"   "2"    null    null
    //   '3'  "1"   "+"   "23"   null    null
    //   '+'  "1"   "+"   "23"   null    "Only enter one operator!"
    //   '='  "1"   "+"   "23"   "24"    null
    private String lhs=null, op=null, rhs=null, result=null;
    private String errorMsg = null;

    public int pow(int base, int expt) {
        if (expt < 0) {
             oops("No negative components!");
             return 0;
        }
        else {
            // @TODO #2: This has a bug!  It does not properly handle negative exponents!
            // Hint: be sure to check the reference implementation supplied to you
            // to see how this method should work, particularly for negative exponents.
            return (int) Math.pow(base, expt);
        }
    }

    public void testPow() {
        System.out.print("Testing the pow method... ");
        assert(pow(2,3) == 8);
        assert(pow(4,5) == 256);
        assert(pow(3,-1) == 0);
        // @TODO #3: Finish this! Be complete yet concise in your testing.
        System.out.println("Passed all tests!");
    }

    // integer division...
    public int div(int numerator, int denominator) {
        if ((numerator <= 0) || (denominator <= 0)) {
            oops("Only enter one operator!");
        return 0;
    }
        else
        // @TODO #4: This has a bug!  It does not properly handle an obvious case!
        return Math.round(numerator / denominator);
    }

    public void testDiv() {
        System.out.print("Testing the div method... ");
        assert(div(17,5) == 3);
        assert(div(3,2)==1);
        assert(div(-1,1)==0);

        // @TODO #5: Finish this! Be complete yet concise in your testing.
        System.out.println("Passed all tests!");
    }

    // integer mod (remainder)
    public int mod(int numerator, int denominator) {
        // @TODO #6: this isn't implemented at all -- implement it!
        return numerator%denominator ;
    }

    public void testMod() {
        System.out.print("Testing the mod method... ");
        assert(mod(2,3)==2);
        assert(mod(3,1)==0);
        assert(mod(5,2)==1);
        assert(mod(25,7)==4);
        // @TODO #7: Finish this! Be complete yet concise in your testing.
        System.out.println("Passed all tests!");
    }

    // Returns the current value, as an int, of either the left-hand side (lhs)
    // or the right-hand side (rhs), whichever is currently being entered.
    public int getCurrentValue() {
        boolean useLhs = (op == null);
        String valueString = (useLhs ? lhs : rhs);
        if (valueString == null) valueString = "0";
        return Integer.parseInt(valueString);
    }

    // Sets the current value, as an int, of either the left-hand side (lhs)
    // or the right-hand side (rhs), whichever is currently being entered.
    public void setCurrentValue(int value) {
        boolean useLhs = (op == null);
        if (useLhs)
            lhs = ""+value;
        else
            rhs = ""+value;
    }

    // This method is only called after the user enters '=', and only
    // if the lhs, op, and rhs are set to legal values.  It evaluates the
    // expression and returns the result as a string, not an int.
    public String evaluateExpression() {
        assert((lhs != null) && (op != null) && (rhs != null));
        int lhsValue = Integer.parseInt(lhs);
        int rhsValue = Integer.parseInt(rhs);
        int resultValue = 0;
        switch(op.charAt(0)) {
            case '+':  resultValue = lhsValue + rhsValue;
                break;
            case '-':  resultValue = lhsValue - rhsValue;
                break;
            case '*':  resultValue = lhsValue * rhsValue;
                break;
            case '/':  resultValue = div(lhsValue, rhsValue);
                break;
            case '%':  resultValue = mod(lhsValue, rhsValue);
                break;
            case '^':  resultValue = pow(lhsValue, rhsValue);
                break;
            default:   oops("Unknown operator: " + op.charAt(0));
        }
        return "" + resultValue;
    }

    public void testEvaluateExpression() {
        System.out.print("Testing the evaluateExpression method... ");
        // Note: we must reset the instance variables each time
        // to test this!  To do so, we'll use a helper method
        // for our test method (see next method)!  Cool!
        testEvaluateExpression("12","+","34","46");
        // @TODO #8: Finish this! Be complete yet concise in your testing.
        System.out.println("Passed all tests!");
    }

    public void testEvaluateExpression(String lhsValue, String opValue,
                                       String rhsValue, String resultValue) {
        // set the instance variables as evaluateExpression expects them
        lhs = lhsValue;
        op = opValue;
        rhs = rhsValue;
        String result = evaluateExpression();
        assert(result.equals(resultValue));
    }

    // This method is called when there is an error.  It stores the error
    // message in an instance variable so it can be painted, then beeps.
    public void oops(String msg) {
        errorMsg = "Error: " + msg;
        beep();
    }

    // Return true if the given key is one of '0',...,'9', and false otherwise.
    public boolean isDigitKey(char key) {
        // @TODO #9: This has a bug!  it only works for '1' or '2'.  You should

        // change the code to work for ALL keys.  Also, your solution here
        // may only use ONE LINE of code and only one boolean
        // logical operator (&&, ||, or !).
        return ((key >= '0') && (key <= '9'));
    }

    public void testIsDigitKey() {
        System.out.print("Testing the isDigitKey method... ");
        assert(isDigitKey('1') == true);
        assert(isDigitKey('5') == true);
        assert(isDigitKey('a')== false);
        // @TODO #10: Finish this! Be complete yet concise in your testing.
        System.out.println("Passed all tests!");
    }

    // Convert the given key to its int equivalent (say, converting '1' to 1),
    // or return -1 if the key is not a decimal digit.
    public int toDigit(char key) {
        int k = Character.getNumericValue(key);
        if ((k >=0) && (k<=9))
            return k;
        else

        // @TODO #11: This has a bug.  It should return -1 if the key is not a
        // legal digit key (that is, not one of '0', ..., '9').
        return -1;
    }

    public void testToDigit() {
        System.out.print("Testing the toDigit method... ");
        assert(toDigit('1') == 1);
        assert(toDigit('a') == -1 );
        // @TODO #12: Finish this! Be complete yet concise in your testing.
        System.out.println("Passed all tests!");
    }

    // This method is called when the user presses a digit ('0',...,'9').
    public void digitPressed(char digitKey) {
        int value = getCurrentValue();
        setCurrentValue(10*value + toDigit(digitKey));
    }
    public void backSpacePressed() {
        if (result != null) {
            return;
        }
        else if (rhs!=null) {
            rhs = null;
        }
        else if (op!=null) {
            op = null;
        }
        else if (lhs!=null){
            lhs=null;
        }

    }
    // The calculator uses the tilde key ('~') as +/- (that is,
    // as unary negation).
    public boolean isUnaryNegationKey(char key) {
        return (key == '~');
    }

    // This method is called whenever the user presses the unary
    // negation key ('~').
    public void unaryNegationPressed() {
        // Hint: be sure you understand this test, and just what
        // the two cases are in which it will say "Nothing to negate!"
        if ((lhs == null) || ((op != null) && (rhs == null)))
            oops("Nothing to negate!");
        else
            setCurrentValue(0 - getCurrentValue());
    }

    // Return true if the key is a binary operator that the calculator
    // understands (+,-,*,/,%,^), and false otherwise.
    // Note: You ARE responsible for the String.contains()
    // method, and you also must understand why the argument
    // is (""+key) and not just (key).
    public boolean isBinaryOperatorKey(char key) {
        return ("+-*/%^".contains(""+key));
    }

    // This method is called when the user presses a binary operator.
    // If it is legal to press an operator at this time, the method
    // simply stores the operator in the "op" instance variable.
    // However, if it is not a legal time to press a binary operator,
    // the method instead calls oops() with the appropriate error message.
    public void binaryOperatorPressed(char operatorKey) {
        if (lhs == null)
            oops("Enter a number before the operator!");
        else {
            if (op == null)
                op = "" + operatorKey;
            else
                oops( " Only enter one operator ");
            }
    }
        // @TODO #13: This does not properly handle TWO error cases.
        // First, if the user enters '+' before entering a number.
        // (Hint:  your test for this should involve "lhs")
        // And second, if the user enters '+' after already entering '+'.
        // (No hint here, except to think about the previous hint and
        // how it might be adapted to this situation.)
        // Run the demo to see the errors in each case.

    public boolean isEqualsKey(char key) {
        return (key == '=');
    }

    // This method is called when the user presses the '=' key.
    // If it is legal at this time, the method calls evaluateExpression
    // and stores its result in the "result" instance variable.  But if
    // it's not legal yet to evaluate the expression, the method instead
    // calls the oops method with the appropriate error message.
    public void equalsPressed() {
        if (rhs == null)
            oops ("Nothing to negate!");
        if(op == null)
            oops ("Enter a binary expression first!");
        else
        // @TODO #14: This does not properly handle ONE error case:
        // if the '=' key is pressed before the right-hand side is entered.
        result = evaluateExpression();
    }

    // This method uses the values stored in the "lhs", "op", "rhs",
    // and "result" instance variables to cobble together the string that
    // should be displayed by the calculator, and returns that string.
    // If all these instance variables are null, the method instead returns
    // a prompt ("Enter a simple arithmetic expression.").
    public String getDisplayString() {
        String display;
        if (lhs == null)
            display = "Enter a simple arithmetic expression.";

        else {
            if ((op == null))
                display = lhs;
            else if ((rhs == null))
                display = lhs + " " + op;
            else if ((result == null))
                display = lhs + " " + op + " " + rhs;
            else
                // the expression are still null (not-yet-entered).  As it is,
                // it does not do that!
                display = lhs + " " + op + " " + rhs + " = " + result;
        }
        return display;
    }

    // This method is called when the user presses a key after pressing '='.
    // It sets all the instance variables to null, thus resetting the calculator.
    public void reset() {
        lhs = op = rhs = result = null;
    }

    public void keyPressed(char key) {
        errorMsg = null;
        if (result != null)
            reset();
        if (isUnaryNegationKey(key))
            unaryNegationPressed();
        else if (isBinaryOperatorKey(key))
            binaryOperatorPressed(key);
        else if (isEqualsKey(key))
            equalsPressed();
        else if (isDigitKey(key))
            digitPressed(key);
        else if (isBackSpaceKey(key))
            backSpacePressed();
        else
            oops("Unknown key: " + key);
    }

    private boolean isBackSpaceKey(char key) {
        return (int)(key) == 8;

    }

    // Note: the drawCenteredString method is not part of Java, but
    // instead is defined in JComponentWithEvents (and yes, you are
    // responsible for it!).
    public void paint(Graphics2D page) {
        int width = getWidth();
        int height = getHeight();
        Color saffron = new Color(244, 196, 48);
        page.setColor(saffron);
        page.fillRect(0, 0, width, height);
        Color royalPurple = new Color(107, 63, 160);
        page.setColor(royalPurple);
        String display = getDisplayString();
        page.setFont(new Font("Arial", Font.BOLD, 36));
        drawCenteredString(page, display, 0, 0, width, height/3*2);
        page.setFont(new Font("Arial", Font.BOLD, 24));
        String cmds = "Commands: +  -  *  /  %  ^  ~  =";
        drawCenteredString(page, cmds, 0, height/3*2, width, height/3);
        if (errorMsg != null) {
            Color sangria = new Color(146, 0, 10);
            page.setColor(sangria);
            drawCenteredString(page, errorMsg, 0, 0, width, 32);
        }
        // @TODO #16: delete the following code!



    }

    public void testAll() {
        testPow();
        testDiv();
        testMod();
        testEvaluateExpression();
        testIsDigitKey();
        testToDigit();
    }

    public void start() {
        testAll();
        reset();
    }

    public static void main(String[] args) { launch(700, 300); }
}