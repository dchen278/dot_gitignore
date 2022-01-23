package gamemodes;

import java.util.*;

public class Restrict extends Classic {
    String directions = "";

    public static String about() {
        return "Classic 2048 except you can only move in two directions";
    }
    
    public Restrict(String key1, String key2) {
        //variable "directions" contain directions that the player cannot use
        directions = key1 + " " + key2;
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

    protected boolean isCommand(String s) {

        if (s.equals("exit") || directions.indexOf(s) >= 0) {
                return true;
        }
        return false;
    }
    
    protected void playTurn() {
        String move;
        System.out.println("Score: " + score);
        printArr(grid);
        System.out.print("Type \"" + directions + "\" " + " to move tiles, \"exit\" to terminate game: ");
        move = sc.nextLine().trim().toLowerCase();

        while (!isCommand(move)) {
            System.out.print("Type \"" + directions + "\" " + " to move tiles, \"exit\" to terminate game: ");
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
    
}
