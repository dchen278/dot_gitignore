import java.io.*;
import java.util.*;

public class Game {
    private int[][] grid;
    private int score;
    private InputStreamReader isr;
    private BufferedReader in;

    public Game() {
        score = 0;
        grid = new int[7][20];
        grid[4][4] = 1;
        grid[5][4] = 1;
        isr = new InputStreamReader(System.in);
        in = new BufferedReader(isr);
    }

    public static void printArr(int[][] a) {
        for (int[] row : a) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // plays a turn/frame.
    public boolean playTurn() {
        String command;
        printArr(grid);
        try {
            command = in.readLine();
        } catch (Exception e) {
            command = "";
        }
        if (command.equals("w") || command.equals(" ")) {
            jump();
        }
        score++;
        return true;
    }

    // Make dino jump. May be moved to Dino class later on.
    public void jump() {
        grid[4][4] = 0;
        grid[5][4] = 0;
        grid[3][4] = 1;
        grid[2][4] = 1;
    }

    public static void main(String[] args) {
        Game bob = new Game();
        bob.playTurn();
    }
}