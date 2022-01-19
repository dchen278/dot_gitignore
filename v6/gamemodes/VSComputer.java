package gamemodes;

import util.Computer;

public class VSComputer extends Classic {
    public static String about() {
        return "2048 vsComputer. Play 2048 against an AI. ";
    }
    public void run() {
        Computer bot = new Computer();
        while (!bot.isLoss() && !this.isLoss()) {
            clearScreen();
            bot.playTurn();
            System.out.println("====================================");
            this.playTurn();
        }
        if (this.score > bot.getScore()) {
            System.out.println("GG! You won against the computer!");
        } else if (this.score < bot.getScore()) {
            System.out.println("Not POG! You lost!");
        } else {
            System.out.println("You tied with the computer.");
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
