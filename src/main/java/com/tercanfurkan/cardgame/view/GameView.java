package com.tercanfurkan.cardgame.view;

import com.tercanfurkan.cardgame.controller.GameController;

public interface GameView {

    public void setController(GameController controller);

    public void showPlayerName(int playerIndex, String name);
    public void showFaceDownCardForPlayer(int playerIndex, String name);
    public void showCardForPlayer(int playerIndex, String name, String rank, String suit);
    public void showWinner(String winnerName);
    public void showFailedToStart(String reason);

    public void promptForPlayerName();
    public void promptForFlip();
    public void promptForNewGame();

}
