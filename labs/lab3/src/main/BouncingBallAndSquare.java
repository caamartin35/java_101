package main;

import java.awt.*;

public class BouncingBallAndSquare extends JComponentWithEvents {

    private int rectX = 0;

    public void timerFired() {
        rectX += 1;
    }

    public void paint(Graphics2D page) {
        page.fillRect(rectX, 0, 10, 10);
    }
    // Standard main method:
    public static void main(String[] args) { launch(500, 400); }
}
