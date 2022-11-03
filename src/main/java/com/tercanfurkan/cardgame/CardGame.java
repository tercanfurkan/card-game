package com.tercanfurkan.cardgame;

import com.tercanfurkan.cardgame.controller.GameController;
import com.tercanfurkan.cardgame.game.HighCardGameEvaluator;
import com.tercanfurkan.cardgame.model.Deck;
import com.tercanfurkan.cardgame.view.CommandLineGameView;

public class CardGame {

    public static void main(String[] args) {
        GameController controller = new GameController(new CommandLineGameView(), new Deck(), new HighCardGameEvaluator());
        controller.run();
    }
}
