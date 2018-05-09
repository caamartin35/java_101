package main;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Snake extends JComponentWithEvents {

    private boolean debug = true;
    private int rows = 10;
    private int cols = 10;
    private int[][] snake = new int[rows][cols];
    private int dir = UP;
    private int headRow, headCol;
    private int foodRow, foodCol;

    public void moveSnake() {
        int snakeLength = snake[headRow][headCol];
        int newHeadRow = headRow, newHeadCol = headCol;
        if (dir == UP) newHeadRow--;
        else if (dir == DOWN) newHeadRow++;
        else if (dir == RIGHT) newHeadCol++;
        else newHeadCol--;
        if ((newHeadRow < 0) || (newHeadRow >= rows) ||
                (newHeadCol < 0) || (newHeadCol >= cols)) {
            die();
        }
        else if (snake[newHeadRow][newHeadCol] > 0) {
            die();
        }
        else if ((newHeadRow == foodRow) && (newHeadCol == foodCol)) {
            headRow = newHeadRow;
            headCol = newHeadCol;
            snake[newHeadRow][newHeadCol] = snakeLength+1;
            placeFood();
        }
        else {
            for (int row=0; row<rows; row++)
                for (int col=0; col<cols; col++)
                    if (snake[row][col] > 0)
                        --snake[row][col];
            snake[newHeadRow][newHeadCol] = snakeLength;
            headRow = newHeadRow;
            headCol = newHeadCol;
        }
    }

    public void die() {
        reset();
    }

    public void keyPressed(char key) {
        if (key == 'm') moveSnake();
        else if (key == UP) dir = UP;
        else if (key == DOWN) dir = DOWN;
        else if (key == RIGHT) dir = RIGHT;
        else if (key == LEFT) dir = LEFT;
    }

    public void timerFired() {
        moveSnake();
    }

    public void start() {
        reset();
    }

    public void reset() {
        for (int row=0; row<rows; row++)
            for (int col=0; col<cols; col++)
                snake[row][col] = 0;
        headRow = 0;
        headCol = 1;
        snake[0][1] = 5;
        snake[1][1] = 4;
        snake[2][1] = 3;
        snake[2][2] = 2;
        snake[3][2] = 1;
        dir = RIGHT;
        placeFood();
    }

    private Random random = new Random();

    public void placeFood() {
        while (true) {
            foodRow = random.nextInt(rows);
            foodCol = random.nextInt(cols);
            System.out.println("placeFood: trying " + foodRow + "," + foodCol);
            if (snake[foodRow][foodCol] == 0)
                break;
        }
        System.out.println("placeFood: worked");
    }

    public void paintCell(Graphics2D page, int row, int col) {
        int width = getWidth(), height = getHeight();
        int left = col * width / cols;
        int right = (col + 1) * width / cols;
        int top  = row * height / rows;
        int bottom = (row + 1) * height / rows;
        page.setColor(Color.black);
        page.drawRect(left, top, right-left, bottom-top);
        if ((row == foodRow) && (col == foodCol)) {
            page.setColor(Color.green);
            page.fillOval(left, top, right-left, bottom-top);
        }
        else if (snake[row][col] > 0) {
            page.setColor(Color.blue);
            page.fillOval(left, top, right-left, bottom-top);
            if (debug) {
                page.setColor(Color.white);
                page.setFont(new Font("Arial", Font.BOLD, 16));
                drawCenteredString(page, ""+snake[row][col],
                        left, top, right-left, bottom-top);
            }
        }
    }

    public void paint(Graphics2D page) {
        for (int row=0; row<rows; row++)
            for (int col=0; col<cols; col++)
                paintCell(page, row, col);
    }

    public static void main(String[] args) { launch(300, 300); }
}
