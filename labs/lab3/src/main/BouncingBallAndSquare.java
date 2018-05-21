package main;

import java.awt.*;

public class BouncingBallAndSquare extends JComponentWithEvents {

    private int rectY = 0;
    private int ovalX = 0;
    int x = getWidth()/2;
    int y = getHeight()/2;
    boolean isDown = true;
    boolean isRight = true;

    public void start() {
        int delayInMilliseconds = 50;
        setTimerDelay(delayInMilliseconds);
    }

    public void timerFired() {
        if (rectY == getHeight() - 20)
            isDown = false;
        if (rectY == 0)
            isDown = true;
        if (isDown == true)
            rectY += 20;
        else
            rectY -= 20;
        if(ovalX == getWidth() - 20)
            isRight = false;
        if(ovalX == 0)
            isRight = true;
        if (isRight == true)
            ovalX += 40;
        else
            ovalX -= 40;


    }
    public void paint(Graphics2D page) {
        if (isDown == true) {
            page.setColor(Color.green);
            page.fillRect(x, rectY, 20, 20);
        }
        else {
            page.setColor(Color.yellow);
            page.fillRect(x, rectY, 20, 20);
        }
        if (isRight == true) {
            page.setColor(Color.red);
            page.fillOval(ovalX, y, 20, 20);
        }
        else {
            page.setColor(Color.blue);
            page.fillOval(ovalX, y ,20,20);
        }
    }
    // Standard main method:
    public static void main(String[] args) { launch(500, 400);
    }
}
