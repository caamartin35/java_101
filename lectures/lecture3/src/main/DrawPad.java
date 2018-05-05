package main;

import java.awt.*;
import javax.swing.*;

public class DrawPad extends JComponentWithEvents {

    public void paint(Graphics page) {
        // Place your paint code here!
    }

    //////////////////////////////////////////////
    ///           END OF YOUR CODE             ///
    ///  (you may ignore all the code below!!! ///
    //////////////////////////////////////////////
    public Dimension getPreferredSize() {
        int initialWidth = 500;
        int initialHeight = 400;
        return new Dimension(initialWidth, initialHeight);
    }
    public static void main(String[] args) {
        JComponent jc = newInstance();
        JFrame frame = new JFrame(jc.getClass().getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel cp = new JPanel();
        cp.setLayout(new BorderLayout());
        cp.add(jc);
        frame.setContentPane(cp);
        frame.pack();
        frame.setVisible(true);
    }
    // Returns an instance of this class as a JComponent.  This is necessary so
    // students can rename this class without changing the "main" method's body.
    public static JComponent newInstance() {
        StackTraceElement[] trace = null;
        try { throw new RuntimeException(); }
        catch (Exception e) { trace = e.getStackTrace(); }
        try { return (JComponent)Class.forName(trace[0].getClassName()).newInstance(); }
        catch (Exception e) { return null; }
    }
}

