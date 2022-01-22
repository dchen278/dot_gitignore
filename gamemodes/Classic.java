package gamemodes;

import java.util.Scanner;
import util.Tiles;

public class Classic implements Game {
     int[][] grid;
     int score;
     Scanner sc;

    public static String about() {
        return "Classic 2048";
    }

    public Classic() {
        score = 0;
        grid = new int[4][4];
        grid[(int) (Math.random() * 4)][(int) (Math.random() * 4)] = 2;
        while (true) {
            int x = (int) (Math.random() * 4);
            int y = (int) (Math.random() * 4);
            if (grid[y][x] == 0) {
                if (Math.random() < 0.75) {
                    grid[y][x] = 2;
                } else {
                    grid[y][x] = 4;
                }
                break;
            }
        }
        sc = new Scanner(System.in);
    }

    protected void playTurn() {
        String move;
        System.out.println("Score: " + score);
        printArr(grid);
        System.out.print("Type \"w a s d\" to move tiles, \"exit\" to terminate game: ");
        move = sc.nextLine().trim().toLowerCase();

        while (!isCommand(move)) {
            System.out.print("Type \"w a s d\" to move tiles, \"exit\" to terminate game: ");
            move = sc.nextLine();
            move = move.trim();
            move = move.toLowerCase();
        }

        // move multiple length times to ensure all possible moves are made
        if (move.equals("s")) {
            for (int i = 0; i < grid.length; i++) {
                moveDown();
            }
            combineDown();
            for (int i = 0; i < grid.length; i++) {
                moveDown();
            }
        } else if (move.equals("w")) {
            for (int i = 0; i < grid.length; i++) {
                moveUp();
            }
            combineUp();
            for (int i = 0; i < grid.length; i++) {
                moveUp();
            }
        } else if (move.equals("a")) {
            for (int i = 0; i < grid.length; i++) {
                moveLeft();
            }
            combineLeft();
            for (int i = 0; i < grid.length; i++) {
                moveLeft();
            }
        } else if (move.equals("d")) {
            for (int i = 0; i < grid.length; i++) {
                moveRight();
            }
            combineRight();
            for (int i = 0; i < grid.length; i++) {
                moveRight();
            }
        } else {
            System.out.println("Game has been terminated...");
            System.exit(0);
        }

        // spawn new block at random location
        while (!isFull()) {
            int x = (int) (Math.random() * grid.length);
            int y = (int) (Math.random() * grid.length);
            // spawn 2 or 4
            if (grid[y][x] == 0) {
                if (Math.random() < 0.75) {
                    grid[y][x] = 2;
                } else {
                    grid[y][x] = 4;
                }
                break;
            }
        }
    }

    public void run() {
        // play until loss
        while (!isLoss()) {
            playTurn();
            clearScreen();
        }
        printArr(grid);
        System.out.println("Good game! Your final score was: " + score);
        System.exit(0);
    }

    // ============Movement methods============

    // move everything down
    protected void moveDown() {
        for (int i = grid.length - 1; i > 0; i--) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i - 1][j];
                    grid[i - 1][j] = 0;
                }
            }
        }
    }

    protected void combineDown() {
        for (int i = grid.length - 1; i > 0; i--) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == grid[i - 1][j]) {
                    grid[i][j] *= 2;
                    grid[i - 1][j] = 0;
                    score += grid[i][j];
                }
            }
        }
    }

    // move everything up
    protected void moveUp() {
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i + 1][j];
                    grid[i + 1][j] = 0;
                }
            }
        }
    }

    protected void combineUp() {
        // combine everything up
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i + 1][j] == grid[i][j]) {
                    grid[i][j] *= 2;
                    grid[i + 1][j] = 0;
                    score += grid[i][j];
                }
            }
        }

    }

    // move everything left
    protected void moveLeft() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                if (grid[i][j - 1] == 0) {
                    grid[i][j - 1] = grid[i][j];
                    grid[i][j] = 0;
                }
            }
        }
    }

    protected void combineLeft() {
        // combine tiles left
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length - 1; j++) {
                if (grid[i][j + 1] == grid[i][j]) {
                    grid[i][j] *= 2;
                    grid[i][j + 1] = 0;
                    score += grid[i][j];
                }
            }
        }
    }

    // move everything right
    protected void moveRight() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid.length - 1; j > 0; j--) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i][j - 1];
                    grid[i][j - 1] = 0;
                }
            }
        }
    }

    protected void combineRight() {
        // combine everything right
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid.length - 1; j > 0; j--) {
                if (grid[i][j - 1] == grid[i][j]) {
                    grid[i][j] *= 2;
                    grid[i][j - 1] = 0;
                    score += grid[i][j];
                }
            }
        }
    }
    // ============End Movement methods============

    protected boolean isCommand(String s) {
        // check if input is valid command
        if (s.equals("exit") || s.equals("w") || s.equals("s") || s.equals("a") || s.equals("d")) {
            return true;
        }
        return false;
    }

    protected boolean isLoss() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                // check empty tiles
                if (grid[i][j] == 0) {
                    return false;
                }
                // check for possible merges up and down
                if (i > 0) {
                    if (grid[i][j] == grid[i - 1][j]) {
                        return false;
                    }
                }

                // check for possible merges left and right
                if (j > 0) {
                    if (grid[i][j] == grid[i][j - 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    protected boolean isFull() {
        for (int[] a : grid) {
            for (int i : a) {
                if (i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    protected static void printArr(int[][] a) {
        Tiles.printBorder(a.length);
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                Tiles.printTile(a[i][j]);
            }
            System.out.println();
            Tiles.printBorder(a.length, a[i]);
            System.out.println();
        }
        System.out.println();
    }

    protected static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

}