package util;

public class AIUtils {
    public static int getBestMove(int[][] gridCopy1) {
        int[][] gridCopy = cloneGrid(gridCopy1);
        int bestMove = 0;
        double bestScore = 0;

        for (int i = 0; i < 4; i++) {
            double score = averageTotalRuns(gridCopy, i);
            if (score > bestScore) {
                bestScore = score;
                bestMove = i;
            }
        }

        return bestMove;
    }

    public static double averageTotalRuns(int[][] grid, int direction) {
        int totalScore = 0;
        int iterations = 1000;

        for (int i = 0; i < iterations; i++) {
            int scores = oneRun(grid, direction);
            totalScore += scores;
        }

        double avg = totalScore / iterations;

        return avg;
    }

    public static int oneRun(int[][] grid, int direction) {
        int[][] copy = cloneGrid(grid);
        int score = 0;

        score += spawnTileAndMove(copy, direction);

        while(!isLoss(copy)) {
            int potentialScore = move(copy, (int) Math.random() * 4);
            score += potentialScore;
            if (potentialScore == 0) {
                return score;
            }
            spawnTile(copy);
        }

        return score;
    }

    public static int spawnTileAndMove(int[][] grid, int direction) {
        int[][] copy = grid;
        int score = 0;
        score += move(copy, direction);
        spawnTile(copy);
        return score;
    }

    public static void spawnTile(int[][] a) {
        int x = (int) (Math.random() * a.length);
        int y = (int) (Math.random() * a.length);
        if (a[y][x] == 0) {
            if (Math.random() < 0.75) {
                a[y][x] = 2;
            } else {
                a[y][x] = 4;
            }
        }
    }

    public static int[][] cloneGrid(int[][] target) {
        int[][] result = new int[4][4];
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length; j++) {
                result[i][j] = target[i][j];
            }
        }
        return result;
    }

    public static boolean isLoss(int [][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
                if (i > 0) {
                    if (grid[i][j] == grid[i - 1][j]) {
                        return false;
                    }
                }

                if (j > 0) {
                    if (grid[i][j] == grid[i][j - 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // basic operations

    public static int move(int[][] gridCopy, int direction) {
        int score = 0;
        if (direction == 0) {
            for (int i = 0; i < gridCopy.length; i++) {
                score += moveUp(gridCopy);
            }
        } else if (direction == 1) {
            for (int i = 0; i < gridCopy.length; i++) {
                score += moveDown(gridCopy);
            }
        } else if (direction == 2) {
            for (int i = 0; i < gridCopy.length; i++) {
                score += moveLeft(gridCopy);
            }
        } else if (direction == 3) {
            for (int i = 0; i < gridCopy.length; i++) {
                score += moveRight(gridCopy);
            }
        }
        return score;
    }

    private static int moveUp(int[][] grid) {
        int score = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i + 1][j];
                    grid[i + 1][j] = 0;
                }
            }
        }
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == grid[i + 1][j]) {
                    grid[i][j] *= 2;
                    grid[i + 1][j] = 0;
                    score += grid[i][j];
                }
            }
        }
        return score;
    }

    private static int moveDown(int[][] grid) {
        int score = 0;
        for (int i = grid.length - 1; i > 0; i--) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i - 1][j];
                    grid[i - 1][j] = 0;
                }
            }
        }
        for (int i = grid.length - 1; i > 0; i--) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == grid[i - 1][j]) {
                    grid[i][j] *= 2;
                    grid[i - 1][j] = 0;
                    score += grid[i][j];
                }
            }
        }
        return score;
    }

    private static int moveLeft(int[][] grid) {
        int score = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                if (grid[i][j - 1] == 0) {
                    grid[i][j - 1] = grid[i][j];
                    grid[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                if (grid[i][j - 1] == grid[i][j]) {
                    grid[i][j] *= 2;
                    grid[i][j - 1] = 0;
                    score += grid[i][j];
                }
            }
        }
        return score;
    }

    private static int moveRight(int[][] grid) {
        int score = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid.length - 2; j >= 0; j--) {
                if (grid[i][j + 1] == 0) {
                    grid[i][j + 1] = grid[i][j];
                    grid[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid.length - 2; j >= 0; j--) {
                if (grid[i][j + 1] == grid[i][j]) {
                    grid[i][j] *= 2;
                    grid[i][j + 1] = 0;
                    score += grid[i][j];
                }
            }
        }
        return score;
    }
}
