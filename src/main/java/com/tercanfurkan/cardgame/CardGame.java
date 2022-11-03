package com.tercanfurkan.cardgame;

import com.tercanfurkan.cardgame.controller.GameController;
import com.tercanfurkan.cardgame.game.HighCardGameEvaluator;
import com.tercanfurkan.cardgame.model.deck.DeckFactory;
import com.tercanfurkan.cardgame.view.CommandLineGameView;

public class CardGame {

    public static void main(String[] args) {
        GameController controller = new GameController(
                new CommandLineGameView(),
                DeckFactory.makeDeck(DeckFactory.DeckType.Normal),
                new HighCardGameEvaluator());
        controller.run();
    }
}