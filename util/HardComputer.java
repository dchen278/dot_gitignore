package util;

import java.lang.InterruptedException;

public class HardComputer implements ComputerInterface {
    private int[][] grid;
    private int score;

    public HardComputer() {
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
    }

    public void playTurn() {

        System.out.println("Hard Computer Score: " + score);
        printArr(grid);

        // USE AIUtils.java
        int bestMove = AIUtils.getBestMove(grid);
        printMove(bestMove);

        if (bestMove == 0) {
            for (int i = 0; i < grid.length; i++) {
                moveUp();
            }
            combineUp();
            for (int i = 0; i < grid.length; i++) {
                moveUp();
            }
        } else if (bestMove == 1) {
            for (int i = 0; i < grid.length; i++) {
                moveDown();
            }
            combineDown();
            for (int i = 0; i < grid.length; i++) {
                moveDown();
            }
        } else if (bestMove == 2) {
            for (int i = 0; i < grid.length; i++) {
                moveLeft();
            }
            combineLeft();
            for (int i = 0; i < grid.length; i++) {
                moveLeft();
            }
        } else {
            for (int i = 0; i < grid.length; i++) {
                moveRight();
            }
            combineRight();
            for (int i = 0; i < grid.length; i++) {
                moveRight();
            }
        }

        // spawn new block at random location
        while (!isFull()) {
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

    public static void printMove(int direction) {
        if (direction == 0) {
            System.out.println("Computer chose move: up");
        } else if (direction == 1) {
            System.out.println("Computer chose move: down");
        } else if (direction == 2) {
            System.out.println("Computer chose move: left");
        } else if (direction == 3) {
            System.out.println("Computer chose move: right");
        }
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

    public boolean isLoss() {
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

    private boolean isFull() {
        for (int[] a : grid) {
            for (int i : a) {
                if (i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getScore() {
        return score;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void printArr(int[][] a) {
        Tiles.printBorder(a);
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                Tiles.printTile(a[i][j], a);
            }
            System.out.println();
            Tiles.printBorder(a);
            System.out.println();
        }
        System.out.println();
    }

}