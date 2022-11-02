package com.tercanfurkan.cardgame;

import com.tercanfurkan.cardgame.model.Deck;

public class CardGame {

    public static void main(String[] args) {
        GameController controller = new GameController(new GameView(), new Deck());
        controller.run();
    }
}
