package util;

public class Tiles {
    public static final String RESET = "\u001B[0m";

    public static String tileColor(int value) {
        int log = (int) (Math.log(value) / Math.log(2));
        int color = log;
        // skip colors that are hard to read
        if (color == 8 || color == 104) {
            color += 1;
        }
        return "\u001B[48;5;" + color + "m";
    }

    public static void printTile(int value) {
        
        System.out.print(tileColor(value) + "\u001B[90m" + "  " + ((value == 0) ? " " : value) + "  " + RESET + "|");
    }

    public static void printBorder(int a, int[] b) {
        // Prints the border of the game board dashes colored
        // add the number of digits in b to the length of the border
        int digits = 0;
        for (int num : b) {
            if (num != 0 && num > 10) {
                digits += Integer.toString(num).length();
            }
        }

        for (int i = 0; i < a * 6 + digits; i++) {
            System.out.print("\u001B[95m" + "-" + RESET);
        }
    }

    public static void printBorder(int a) {
        // Prints the border of the game board dashes colored
        for (int i = 0; i < a * 6; i++) {
            System.out.print("\u001B[95m" + "-" + RESET);
        }
    }

}