import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import gamemodes.*;
import util.ComputerInterface;

public class Woo {
    static Game poggers;
    public static final String directions = "wasd";

    public static void main(String[] args) {
        System.out.print("\u001B[92m"
                + "\r\n\u2588\u2588\u2557    \u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2557      \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2557   \u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\r\n\u2588\u2588\u2551    \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u2588\u2588\u2551     \u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\u2588\u2588\u2554\u2550\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2550\u2550\u255D\r\n\u2588\u2588\u2551 \u2588\u2557 \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2551     \u2588\u2588\u2551     \u2588\u2588\u2551   \u2588\u2588\u2551\u2588\u2588\u2554\u2588\u2588\u2588\u2588\u2554\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2557  \r\n\u2588\u2588\u2551\u2588\u2588\u2588\u2557\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u255D  \u2588\u2588\u2551     \u2588\u2588\u2551     \u2588\u2588\u2551   \u2588\u2588\u2551\u2588\u2588\u2551\u255A\u2588\u2588\u2554\u255D\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u255D  \r\n\u255A\u2588\u2588\u2588\u2554\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u255A\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u255A\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2551 \u255A\u2550\u255D \u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\r\n \u255A\u2550\u2550\u255D\u255A\u2550\u2550\u255D \u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D\u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u255D     \u255A\u2550\u255D\u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D\r\n                                                              \r\n");
        System.out.print("\u001B[91m"
                + "\r\n\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \r\n\u255A\u2550\u2550\u2588\u2588\u2554\u2550\u2550\u255D\u2588\u2588\u2554\u2550\u2550\u2550\u2588\u2588\u2557\r\n   \u2588\u2588\u2551   \u2588\u2588\u2551   \u2588\u2588\u2551\r\n   \u2588\u2588\u2551   \u2588\u2588\u2551   \u2588\u2588\u2551\r\n   \u2588\u2588\u2551   \u255A\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D\r\n   \u255A\u2550\u255D    \u255A\u2550\u2550\u2550\u2550\u2550\u255D \r\n                ");
        System.out.print("\u001B[93m"
                + "\r\n\u2588\u2588\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2557  \u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \r\n\u255A\u2550\u2550\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2554\u2550\u2588\u2588\u2588\u2588\u2557\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\r\n \u2588\u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2551\u2588\u2588\u2554\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u255A\u2588\u2588\u2588\u2588\u2588\u2554\u255D\r\n\u2588\u2588\u2554\u2550\u2550\u2550\u255D \u2588\u2588\u2588\u2588\u2554\u255D\u2588\u2588\u2551\u255A\u2550\u2550\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\r\n\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2557\u255A\u2588\u2588\u2588\u2588\u2588\u2588\u2554\u255D     \u2588\u2588\u2551\u255A\u2588\u2588\u2588\u2588\u2588\u2554\u255D\r\n\u255A\u2550\u2550\u2550\u2550\u2550\u2550\u255D \u255A\u2550\u2550\u2550\u2550\u2550\u255D      \u255A\u2550\u255D \u255A\u2550\u2550\u2550\u2550\u255D \r\n                                 \r\n");
        System.out.print("\u001B[94m"
                + "\r\n\u2588\u2588\u2588\u2557   \u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2557   \u2588\u2588\u2557\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2588\u2557 \r\n\u2588\u2588\u2588\u2588\u2557 \u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\u2588\u2588\u2588\u2588\u2557  \u2588\u2588\u2551\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2557\r\n\u2588\u2588\u2554\u2588\u2588\u2588\u2588\u2554\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2554\u2588\u2588\u2557 \u2588\u2588\u2551\u2588\u2588\u2551\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2551\r\n\u2588\u2588\u2551\u255A\u2588\u2588\u2554\u255D\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\u2588\u2588\u2551\u255A\u2588\u2588\u2557\u2588\u2588\u2551\u2588\u2588\u2551\u2588\u2588\u2554\u2550\u2550\u2588\u2588\u2551\r\n\u2588\u2588\u2551 \u255A\u2550\u255D \u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\u2588\u2588\u2551 \u255A\u2588\u2588\u2588\u2588\u2551\u2588\u2588\u2551\u2588\u2588\u2551  \u2588\u2588\u2551\r\n\u255A\u2550\u255D     \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u2550\u2550\u255D\u255A\u2550\u255D\u255A\u2550\u255D  \u255A\u2550\u255D\r\n                                        \r\n");
        System.out.println("\033[0;1m Created By David Chen, Yat Long Chan, and Jaylen Zeng \n");

        checkAndMakeJson();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the game mode you want to play: ");
        System.out.println("1. " + Classic.about());
        System.out.println("2. " + CustomBoard.about());
        System.out.println("3. " + Anti.about());
        System.out.println("4. " + Restrict.about());
        System.out.println("5. " + VSComputer.about());
        System.out.println("6. PVP");
        System.out.println("7. Exit");
        int gameMode = input.nextInt();
        while (gameMode > 7 || gameMode < 1) {
            gameMode = input.nextInt();
        }

        if (gameMode == 1) {
            poggers = new Classic();
        } else if (gameMode == 2) {
            System.out.println("Enter your board size (between 3 and 10): ");
            int boardSize = input.nextInt();
            while (boardSize < 3 || boardSize > 10) {
                System.out.println("Enter a valid board size");
                boardSize = input.nextInt();
            }

            poggers = new CustomBoard(boardSize);
        } else if (gameMode == 3) {
            poggers = new Anti();
        } else if (gameMode == 4) {
            input.nextLine();
            System.out.println("Enter the first direction that you can't use (w a s d):");
            String key1 = input.nextLine();
            key1.trim().toLowerCase();
            while (directions.indexOf(key1) < 0) {
                System.out.println("Enter a valid direction");
                key1 = input.nextLine();
                key1.trim().toLowerCase();
            }
            System.out.println("Enter the second direction that you can't use (w a s d): \nDon't pick the same one!");
            String key2 = input.nextLine();
            key2.trim().toLowerCase();
            while (directions.indexOf(key1) < 0 || key1.equals(key2)) {
                System.out.println("Enter a valid direction");
                key2 = input.nextLine();
                key2.trim().toLowerCase();
            }
            poggers = new Restrict(key1, key2);
        } else if (gameMode == 5) {
            System.out.println("Please enter  difficulty of the computer: ");
            System.out.println("1. Easy");
            System.out.println("2. Hard");
            int difficulty = input.nextInt();
            while (difficulty > 2 || difficulty < 1) {
                System.out.println("Please enter a valid difficulty");
                difficulty = input.nextInt();
            }
            poggers = new VSComputer(difficulty);
        } else if (gameMode == 6) {
            poggers = new Classic();
        } else {
            System.exit(0);
        }

        poggers.run();

    }

    public static void checkAndMakeJson() {
        File file = new File("data.json");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
