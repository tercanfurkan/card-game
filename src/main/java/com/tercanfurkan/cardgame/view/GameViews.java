package com.tercanfurkan.cardgame.view;

import com.tercanfurkan.cardgame.controller.GameController;

import java.util.Vector;

public class GameViews implements IGameView {

    Vector<IGameView> views;

    public GameViews() {
        views = new Vector<>();
    }

    public void addGameView(IGameView view) {
        views.add(view);
    }

    @Override
    public void setController(GameController controller) {
        views.forEach(view -> view.setController(controller));
    }

    @Override
    public void showPlayerName(int playerIndex, String name) {
        views.forEach(view -> view.showPlayerName(playerIndex, name));
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String name) {
        views.forEach(view -> view.showFaceDownCardForPlayer(playerIndex, name));
    }

    @Override
    public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
        views.forEach(view -> view.showCardForPlayer(playerIndex, name, rank, suit));
    }

    @Override
    public void showWinner(String winnerName) {
        views.forEach(view -> view.showWinner(winnerName));
    }

    @Override
    public void showFailedToStart(String reason) {
        views.forEach(view -> view.showFailedToStart(reason));
    }

    @Override
    public void promptForPlayerName() {
        views.forEach(IGameView::promptForPlayerName);
    }

    @Override
    public void promptForFlip() {
        views.forEach(IGameView::promptForFlip);
    }

    @Override
    public void promptForNewGame() {
        views.forEach(IGameView::promptForNewGame);
    }
}
