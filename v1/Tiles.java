public class Tiles {
    public static final String RESET = "\u001B[0m";

    public static String tileColor(int value) {
        int log = (int) (Math.log(value) / Math.log(2));
        int color = log + 40;
        return "\u001B[" + color + "m";
    }

    public static void printTile(int value) {
        System.out.print(tileColor(value) + "\u001B[90m" + "  " + value + "  " + RESET + "|");
    }

    public static void printBorder(int a) {
        // Prints the border of the game board dashes colored
        for (int i = 0; i < a * 6; i++) {
            System.out.print("\u001B[95m" + "-" + RESET);
        }
    }

}