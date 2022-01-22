package gamemodes;

import java.util.*;

public class Restrict extends Classic {
    String directions = "";

    public static String about() {
        return "Classic 2048 except you can only move in two directions";
    }
    
    public Restrict(String key1, String key2) {
        //variable "directions" contain directions that the player cannot use
        directions = key1 + key2;
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

        if (s.equals("exit") || s.equals("w") || s.equals("s") || s.equals("a") || s.equals("d")) {
            //checks if user input is one of the forbidden directions
            if (directions.indexOf(s) < 0) {
                return true;
            } else { 
                return false; 
            }
        }
        return false;
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
    
}
