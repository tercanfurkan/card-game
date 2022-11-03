package com.tercanfurkan.cardgame;

import com.tercanfurkan.cardgame.controller.GameController;
import com.tercanfurkan.cardgame.game.HighCardGameEvaluator;
import com.tercanfurkan.cardgame.model.deck.Deck;
import com.tercanfurkan.cardgame.model.deck.DeckFactory;
import com.tercanfurkan.cardgame.view.SwingGameView;

public class DesktopCardGame {

    public static void main(String[] args) {
        GameController controller = new GameController(
                new SwingGameView(),
                DeckFactory.makeDeck(DeckFactory.DeckType.Normal),
                new HighCardGameEvaluator());
        controller.run();
    }
}
