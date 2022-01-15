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
        System.out.println("Make a move(Type \"exit\" to terminate game): ");
        move = sc.nextLine();
        move = move.trim();
        move = move.toLowerCase();

        while (!isCommand(move)) {
            System.out.println("Make a valid move (Type \"exit\" to terminate game): ");
            move = sc.nextLine();
            move = move.trim();
            move = move.toLowerCase();
        }

        // move multiple length times to ensure all possible moves are made
        if (move.equals("down")) {
            for (int i = 0; i < grid.length; i++) {
                moveDown();
            }
            combineDown();
        } else if (move.equals("up")) {
            for (int i = 0; i < grid.length; i++) {
                moveUp();
            }
            combineUp();
        } else if (move.equals("left")) {
            for (int i = 0; i < grid.length; i++) {
                moveLeft();
            }
            combineLeft();
        } else if (move.equals("right")) {
            for (int i = 0; i < grid.length; i++) {
                moveRight();
            }
            combineRight();
        } else {
            System.out.println("Game has been terminated...");
            System.exit(0);
        }

        if (isLoss()) {
            return;
        }

        // spawn new block at random location
        while (true) {
            int x = (int) (Math.random() * 4);
            int y = (int) (Math.random() * 4);
            if (grid[y][x] == 0) {
                grid[y][x] = 2;
                break;
            }
        }
    }

    public void run() {
        clearScreen();
        while (!isLoss()) {
            playTurn();
            clearScreen();
        }
        System.out.println("GG! Your final score was: " + score);
    }

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

    private boolean isCommand(String s) {
        if (s.equals("exit") || s.equals("up") || s.equals("down") || s.equals("left") || s.equals("right")) {
            return true;
        }
        return false;
    }

    private boolean isLoss() {
        for (int[] a : grid) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] == a[i + 1] || a[i] == 0) {
                    return false;
                }
            }
        }

        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == grid[i + 1][j]) {
                    return false;
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