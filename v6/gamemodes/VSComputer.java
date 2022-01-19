package gamemodes;

import util.Computer;

public class VSComputer extends Classic {
    public void run() {
        Computer bot = new Computer();
        while (!bot.isLoss() && !this.isLoss()) {
            bot.playTurn();
            this.playTurn();
        }
    }
}
