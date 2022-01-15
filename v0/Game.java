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
        System.out.println("Make a move: ");
        move = sc.nextLine();

        while (!isDirection(move)) {
            System.out.println("Make a valid move: ");
            move = sc.nextLine();
        }

        if (move.equals("down")) {
            moveDown();
        } else if (move.equals("up")) {
            moveUp();
        } else if (move.equals("left")) {
            moveLeft();
        } else {
            moveRight();
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
        while (!isLoss()) {
            playTurn();
        }
        System.out.println("GG! Your final score was: " + score);
    }

    // move everything down
    private void moveDown() {
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i + 1][j] == 0) {
                    grid[i + 1][j] = grid[i][j];
                    grid[i][j] = 0;
                } else if (grid[i + 1][j] == grid[i][j]) {
                    grid[i + 1][j] *= 2;
                    grid[i][j] = 0;
                    score += grid[i + 1][j];
                }
            }
        }
    }

    // move everything up
    private void moveUp() {
        for (int i = grid.length - 1; i > 0; i --) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i - 1][j] == 0) {
                    grid[i - 1][j] = grid[i][j];
                    grid[i][j] = 0;
                } else if (grid[i][j] == grid[i - 1][j]) {
                    grid[i - 1][j] *= 2;
                    grid[i][j] = 0;
                    score += grid[i - 1][j];
                }
            }
        }
    }

    // move everything left
    private void moveLeft() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[i].length - 1; j > 0; j --) {
                if (grid[i][j - 1] == 0) {
                    grid[i][j - 1] = grid[i][j];
                    grid[i][j] = 0;
                } else if (grid[i][j - 1] == grid[i][j]) {
                    grid[i][j - 1] *= 2;
                    grid[i][j] = 0;
                    score += grid[i][j - 1];
                }
            }
        }
    }

    // move everything right
    private void moveRight() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length - 1; j ++) {
                if (grid[i][j + 1] == 0) {
                    grid[i][j + 1] = grid[i][j];
                    grid[i][j] = 0;
                } else if (grid[i][j + 1] == grid[i][j]) {
                    grid[i][j + 1] *= 2;
                    grid[i][j] = 0;
                    score += grid[i][j + 1];
                }
            }
        }
    }

    private boolean isDirection(String s) {
        String temp = s.trim();
        temp = s.toLowerCase();
        if (temp.equals("up") || temp.equals("down") || temp.equals("left") || temp.equals("right")) {
            return true;
        }
        return false;
    }

    private boolean isLoss() {
        for (int[] a : grid) {
            for (int i = 0; i < a.length - 1; i ++) {
                if (a[i] == a[i + 1] || a[i] == 0){
                    return false;
                }
            }
        }

        for (int i = 0; i < grid.length - 1; i ++) {
            for (int j = 0; j < grid.length; j ++) {
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

}