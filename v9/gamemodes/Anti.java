package gamemodes;

public class Anti extends Classic {
    public static String about() {
        return "Anti 4096. Try to fill up the board before reaching 4096";
    }

    public Anti() {
        score = 0;
        grid = new int[6][6];
        grid[(int) (Math.random() * 6)][(int) (Math.random() * 6)] = 2;
        while (true) {
            int x = (int) (Math.random() * 6);
            int y = (int) (Math.random() * 6);
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
            while (!isLoss() && !isWin()) {
                playTurn();
                clearScreen();
            }
            printArr(grid);
            if (isLoss()) {
                System.out.println("Good game! Your final score was: " + score);
            } else {
                System.out.println("You won! Your final score was " + score);
            }
            System.exit(0);
        }

        protected boolean isWin() {
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

        protected boolean isLoss() {
            for (int [] a : grid) {
                for (int i : a) {
                    if (i == 4096) {
                        return true;
                    }
                }
            }
            return false;
        }

    }
