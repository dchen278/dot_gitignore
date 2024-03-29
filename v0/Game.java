import java.util.*;

public class Game {
    private int[][] grid;
    private int score;
    private Scanner sc;

    public Game() {
        score = 0;
        grid = new int[4][4];
        grid[(int) (Math.random() * 4)][(int) (Math.random() * 4)] = 2;
        while (true) {
            int x = (int) (Math.random() * 4);
            int y = (int) (Math.random() * 4);
            if (grid[y][x] == 0) {
                grid[y][x] = 2;
                break;
            }
        }
        sc = new Scanner(System.in);
    }

    private void playTurn() {
        String move;
        System.out.println("Score: " + score);
        printArr(grid);
        System.out.println("Make a move(Type \"w a s d\" to move tiles, \"exit\" to terminate game): ");
        move = sc.nextLine().trim().toLowerCase();

        while (!isCommand(move)) {
            System.out.println("Make a valid move(Type \"w a s d\" to move tiles, \"exit\" to terminate game): ");
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
        while (!isLoss()) {
            int x = (int) (Math.random() * 4);
            int y = (int) (Math.random() * 4);
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
        System.out.println("GG! Your final score was: " + score);
    }

    // ============Movement methods============

    // move everything down
    private void moveDown() {
        for (int i = grid.length - 1; i > 0; i--) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i - 1][j];
                    grid[i - 1][j] = 0;
                }
            }
        }
    }

    private void combineDown() {
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
    private void moveUp() {
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i + 1][j];
                    grid[i + 1][j] = 0;
                }
            }
        }
    }

    private void combineUp() {
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
    private void moveLeft() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                if (grid[i][j - 1] == 0) {
                    grid[i][j - 1] = grid[i][j];
                    grid[i][j] = 0;
                }
            }
        }
    }

    private void combineLeft() {
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
    private void moveRight() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid.length - 1; j > 0; j--) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i][j - 1];
                    grid[i][j - 1] = 0;
                }
            }
        }
    }

    private void combineRight() {
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

    private boolean isCommand(String s) {
        // check if input is valid command
        if (s.equals("exit") || s.equals("w") || s.equals("s") || s.equals("a") || s.equals("d")) {
            return true;
        }
        return false;
    }

    private boolean isLoss() {
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

    public static void printArr(int[][] a) {
        for (int[] row : a) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}