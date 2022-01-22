
package util;

import java.util.*;

public class Computer {
    private int[][] grid;
    private int score;

    public Computer() {
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
        System.out.println("Computer Score: " + score);
        printArr(grid);

        double random = Math.random();

        // move multiple length times to ensure all possible moves are made
        if (random > 0 && random < 0.1) {
            for (int i = 0; i < grid.length; i++) {
                moveDown();
            }
            combineDown();
            for (int i = 0; i < grid.length; i++) {
                moveDown();
            }
        } else if (random < 0.5) {
            for (int i = 0; i < grid.length; i++) {
                moveUp();
            }
            combineUp();
            for (int i = 0; i < grid.length; i++) {
                moveUp();
            }
        } else if (random < 0.7) {
            for (int i = 0; i < grid.length; i++) {
                moveLeft();
            }
            combineLeft();
            for (int i = 0; i < grid.length; i++) {
                moveLeft();
            }
        } else if (random < 1) {
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

    public static void printArr(int[][] a) {
        Tiles.printBorder(a.length);
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                Tiles.printTile(a[i][j], a);
                if (j == a.length - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            Tiles.printBorder(a.length, a[i]);
            System.out.println();
        }
        System.out.println();
    }

}