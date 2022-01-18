import java.util.*;

// game mode where you have a limited amount of moves to complete the game
public class CustomBoard extends Classic {

    public static String about() {
        return "Classic 2048 but with a customizable board size";
    }

    public CustomBoard(int boardSize) {
        score = 0;
        grid = new int[boardSize][boardSize];
        grid[(int) (Math.random() * boardSize)][(int) (Math.random() * boardSize)] = 2;
        while (true) {
            int x = (int) (Math.random() * boardSize);
            int y = (int) (Math.random() * boardSize);
            if (grid[y][x] == 0) {
                if (Math.random() < 0.75) {
                    grid[y][x] = 2;
                } else {
                    grid[y][x] = 4;
                }
                break;
            }
            sc = new Scanner(System.in);
        }
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