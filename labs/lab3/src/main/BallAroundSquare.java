package main;

import java.awt.*;

public class BallAroundSquare extends JComponentWithEvents {
    Direction currentBallDir = Direction.RIGHT;
    enum Direction {
        RIGHT, DOWN, LEFT, UP
    }
    int ballX = 0;
    int ballY = 0;
    int delay = 0;
    String string1= "ABCDEFGHIJKLMNOPQRSTUVYXYZ";
    int x = string1.length();
    boolean isFull = true;
    String string2 = "";
    char lastChar = string1.charAt(x-1);


    public void start() {
        int delayInMilliseconds = 20;
        setTimerDelay(delayInMilliseconds);
    }
    public void timerFired() {
        if (delay == 0) {
            if (currentBallDir == Direction.RIGHT)
                ballX += 10;
            else if (currentBallDir == Direction.DOWN)
                ballY += 10;
            else if (currentBallDir == Direction.LEFT)
                ballX -= 10;
            else if (currentBallDir == Direction.UP)
                ballY -= 10;
        }
        if ((ballX == getWidth() - 20) && (ballY == 0)) {
            delay++;
            if (delay == 15) {
                currentBallDir = Direction.DOWN;
                delay = 0;
            }
        } else if ((ballX == getWidth() - 20) && (ballY == getHeight() - 20)) {
            delay++;
            if (delay == 15) {
                currentBallDir = Direction.LEFT;
                delay = 0;
            }
        } else if ((ballX == 0) && (ballY == getHeight() - 20)) {
            delay++;
            if (delay == 15) {
                currentBallDir = Direction.UP;
                delay = 0;
            }
        } else if ((ballX == 0) && (ballY == 0)) {
            delay++;
            if (delay == 15) {
                currentBallDir = Direction.RIGHT;
                delay = 0;
            }
        }
        if (x == 26)
            isFull = true;

        if (x == 0)
            isFull = false;

        if (isFull == true) {
            lastChar = string1.charAt(x-1);
            string1 = string1.substring(0, x - 1);
            x = string1.length();
            string2 = lastChar + string2;
        } else {
            string1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            x = string1.length();
            string2 = " ";
        }


    }


    public void paint(Graphics2D page) {
        page.setColor(Color.blue);
        page.drawRect( 10,10,getWidth()-20,getHeight()-20);
        if ((ballX == getWidth()-20) && (ballY == 0)) {
            page.setColor(Color.red);
            page.fillOval(ballX, ballY, 20,20);
        }
        else if ((ballX == getWidth()-20) && (ballY == getHeight()-20)) {
            page.setColor(Color.red);
            page.fillOval(ballX, ballY, 20, 20);
        }
        else if ((ballX == 0) && (ballY == getHeight()-20)) {
            page.setColor(Color.red);
            page.fillOval(ballX, ballY, 20, 20);
        }
        else if ((ballY==0) && (ballX==0)) {
            page.setColor(Color.red);
            page.fillOval(ballX, ballY, 20, 20);
        }
        else {
            page.setColor(Color.black);
            page.fillOval(ballX, ballY, 20, 20);
        }

        page.setColor(Color.black);
        page.drawString(string1, 20,30);
        page.drawString(string2, 20,50);

}

    public static void main(String[] args) { launch(500, 400);
    }
}
