package main;

import java.awt.*;
import javax.swing.*;

/*
    In this class you will paint the flag of benin which
    can be found here https://en.wikipedia.org/wiki/Flag_of_Benin.
    The flag must resize when you resize the window with a margin of 10 pixels on
    all sides. To learn how to pain things please refer to:
    https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html.

    Here you will find a list of functions that you can user.
    Example: to draw a rectangle you can do:
      page.fillRect(10, 10, 100, 100)
    To draw an oval you can do:
      page.fillOval(10, 10, 100, 100)
    For custom colors:
      Color amethyst = new Color(153, 102, 204);
      page.setColor(amethyst);
      page.fillRect(10, 10, 50, 100);
    To set the shape to the width or height
    of the window:
      int width = getWidth();
      int height = getHeight();
      page.fillRect(0, 0, width, height);

 */
public class FlagOfBenin extends JComponent {
    private static int MARGIN = 10;

    public void paint(Graphics page) {
        int width = getWidth();
        int height = getHeight();
        page.setColor(new Color(59, 122, 87));
        page.fillRect(MARGIN, MARGIN, (width - 2 * MARGIN) / 3, height - 2 * MARGIN);
        page.setColor(new Color(255, 191, 0));
        page.fillRect((getWidth() - 2 * MARGIN) / 3 + MARGIN, MARGIN, 2 * (width - 2 * MARGIN) / 3, (height - 2 * MARGIN) / 2);
        page.setColor(new Color(165, 42, 42));
        page.fillRect((getWidth() - 2 * MARGIN) / 3 + MARGIN, MARGIN + (height - 2 * MARGIN) / 2, 2 * (width - 2 * MARGIN) / 3, (height - 2 * MARGIN) / 2);
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
