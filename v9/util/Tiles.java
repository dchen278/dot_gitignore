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

    public static void printTile(int value, int[][] grid) {
        int maxLength = getMaxLength(grid);
        // used to fix issue with expanding board size.
        if (maxLength < 3) {
            maxLength = 3;
        }
        String tile = String.format(tileColor(value) + "\u001b[38;5;245m" + " %-" + maxLength + "s" + RESET + "|", (value == 0) ? " " : value);
        System.out.print(tile);
        }

    public static void printBorder(int[][] a) {
        int maxLength = getMaxLength(a);
        if (maxLength < 3) {
            maxLength = 3;
        }
        // Prints the border of the game board dashes colored
        for (int i = 0; i <  (maxLength + 2)* a.length; i++) {
            System.out.print("\u001B[95m" + "-" + RESET);
        }
    }

    public static int getMaxLength(int[][] a) {
        int max = 0;
        for (int[] arr : a) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        return Integer.toString(max).length();
    }

}