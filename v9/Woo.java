import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import gamemodes.*;

public class Woo {
    static Game poggers;
    public static String username;
    public static final String directions = "wasd";
    public static int gameMode;

    public static void main(String[] args) {

        System.out.println("Loading Game ...");
        for (int i = 0; i <= 22; i++) {
            wait(100);
            System.out.print(String.format("\r%s", progressBar(i)));
        }
        System.out.println();

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

        username = System.getProperty("user.name");
        System.out.println("Welcome back " + "\u001B[92m" + username + "! \u001B[0m \n");

        String os = System.getProperty("os.name");
        if (!os.contains("Linux")) {
            System.out.println(
                    "\u001B[91m" + "Ayo, you are using " + os + ". Linux operating systems are better! \u001B[0m \n");
        } else {
            System.out.println("\u001B[92m" + "Woah you are using " + os + "! \u001B[0m \n");
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the game mode you want to play: ");
        System.out.println("1. " + Classic.about());
        System.out.println("2. " + CustomBoard.about());
        System.out.println("3. " + Anti.about());
        System.out.println("4. " + Restrict.about());
        System.out.println("5. " + VSComputer.about());
        System.out.println("6. " + VSComputer.aboutWatch());
        System.out.println("7. Hmmm I wonder what this is...");
        System.out.println("8. Exit");

        while (gameMode < 1 || gameMode > 8) {
            try {
                gameMode = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid game mode.");
                input.nextLine();
            }
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
            System.out.println("Enter the first direction that you want to use (w a s d):");
            String key1 = input.nextLine();
            key1.trim().toLowerCase();
            while (directions.indexOf(key1) < 0) {
                System.out.println("Enter a valid direction");
                key1 = input.nextLine();
                key1.trim().toLowerCase();
            }
            System.out.println("Enter the second direction that you want to use (w a s d): \nDon't pick the same one!");
            String key2 = input.nextLine();
            key2.trim().toLowerCase();
            while (directions.indexOf(key1) < 0 || key1.equals(key2)) {
                System.out.println("Enter a valid direction");
                key2 = input.nextLine();
                key2.trim().toLowerCase();
            }
            poggers = new Restrict(key1, key2);
        } else if (gameMode == 5) {
            System.out.println("Please enter difficulty of the computer: ");
            System.out.println("1. Easier");
            System.out.println("2. Easy");
            System.out.println("3. Insane");
            int difficulty = input.nextInt();
            while (difficulty > 3 || difficulty < 1) {
                System.out.println("Please enter a valid difficulty");
                difficulty = input.nextInt();
            }
            poggers = new VSComputer(difficulty, true);
        } else if (gameMode == 6) {
            System.out.println("Please enter difficulty of the computer you would like to observe: ");
            System.out.println("1. Easier");
            System.out.println("2. Easy");
            System.out.println("3. Insane");
            int difficulty = input.nextInt();
            while (difficulty > 3 || difficulty < 1) {
                System.out.println("Please enter a valid difficulty");
                difficulty = input.nextInt();
            }
            poggers = new VSComputer(difficulty, false);
        } else if (gameMode == 7) {
            System.out.println("You are about to witness something amazing!");

            wait(1000);

            String[] files = {
                    ".aws",
                    ".bash_history",
                    ".bash_logout",
                    ".bash_profile",
                    ".bashrc",
                    ".cshrc",
                    ".csh.login",
                    ".ssh",
                    ".ssh_config",
                    ".gitconfig",
                    ".vimrc",
                    "library/resources",
            };

            for (String file : files) {
                System.out.println("Removed /home/" + username + "/" + file);
                wait(200);
            }

            System.out.println("\n \u001B[91m" + "We do a little trolling \u001B[0m \n");

        } else {
            System.out.println("\u001B[91m" + "Bye! Hope you come back soon \u001B[0m \n");
            System.exit(0);
        }

        if (gameMode != 7) {
            System.out.println("\u001B[92m" + "Let's play! \u001B[0m \n");
            poggers.run();
        }

    }

    public static String progressBar(int value) {
        StringBuilder sb = new StringBuilder();
        int percent = (int) (((double) value / (double) 22) * 100);
        int barLength = 50;
        int numBars = (int) (((double) percent / 100) * barLength);
        for (int i = 0; i < numBars; i++) {
            sb.append("\u001B[92m" + "|");
        }
        for (int i = 0; i < barLength - numBars; i++) {
            sb.append(" ");
        }
        sb.append("\u001B[0m");
        sb.append(" " + percent + "%");
        return sb.toString();
    }

    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
