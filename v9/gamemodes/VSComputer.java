package gamemodes;

import util.Computer;
import util.HardComputer;
import util.ComputerInterface;
import util.*;

public class VSComputer extends Classic {
    private int difficulty;
    public ComputerInterface bot;

    public static String about() {
        return "2048 vsComputer. Play 2048 against an AI. ";
    }

    public VSComputer(int difficulty) {
        super();
        this.difficulty = difficulty;
        if (difficulty == 1) {
             bot = new Computer();
        } else {
            bot = new HardComputer();
        }
    }

    public void run() {
        while (!bot.isLoss() && !this.isLoss()) {
            clearScreen();
            bot.playTurn();
            System.out.println("====================================");
            this.playTurn();
            // wait(500);
        }
        clearScreen();
        System.out.println("Bot Grid:");
        bot.printArr(bot.getGrid());
        System.out.println("====================================");
        System.out.println("Your Grid:");
        this.printArr(this.grid);
        if (bot.isLoss()) {
            System.out.println("GG! You won against the computer!");
        } else {
            System.out.println("Not POG! You lost!");
        } 
    }

    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    protected void playTurn() {
        String move;
        System.out.println("Your Score: " + score);
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
}
