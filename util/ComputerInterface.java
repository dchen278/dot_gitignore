package util;

public interface ComputerInterface {
    private void moveUp() {}
    private void moveDown() {}
    private void moveLeft(){}
    private void moveRight(){}
    public boolean isLoss();
    public int[][] getGrid();
    public void printArr(int[][] arr);
    public void playTurn();
}