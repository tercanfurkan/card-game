package com.tercanfurkan.cardgame.view;

import com.tercanfurkan.cardgame.controller.GameController;

import java.util.Scanner;

public class CommandLineGameView implements GameView {
    GameController controller;
    Scanner keyboard = new Scanner(System.in);

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public void showPlayerName(int playerIndex, String name) {
        System.out.println("[" + playerIndex + "][" + name + "]");
    }
    public void showFaceDownCardForPlayer(int playerIndex, String name) {
        System.out.println("[" + playerIndex + "][" + name + "][][]");
    }
    public void showCardForPlayer(int playerIndex, String name, String rank, String suit) {
        System.out.println("[" + playerIndex + "][" + name + "][" + rank +"][" + suit +"]");
    }
    public void showWinner(String winnerName) {
        System.out.println(winnerName + " is the winner!");
    }

    @Override
    public void showFailedToStart(String reason) {
        System.out.println(reason);
    }

    public void promptForPlayerName() {
        System.out.println("Enter player name:");
        String name = keyboard.nextLine();
        if (name.isEmpty()) {
            controller.startGame();
        } else {
            controller.addPlayer(name);
        }
    }

    public void promptForFlip() {
        System.out.println("Press enter to reveal cards:");
        keyboard.nextLine();
        controller.flipCards();
    }

    public void promptForNewGame() {
        System.out.println("Press enter to start a new game:");
        keyboard.nextLine();
        controller.restartGame();
    }
}
