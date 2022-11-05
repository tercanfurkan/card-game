package com.tercanfurkan.cardgame.game;

import com.tercanfurkan.cardgame.controller.GameController;
import com.tercanfurkan.cardgame.rule.evaluator.HighCardGameEvaluator;
import com.tercanfurkan.cardgame.model.deck.DeckFactory;
import com.tercanfurkan.cardgame.view.SwingGameView;

public class GUIGame {

    public static void main(String[] args) {
        GameController controller = new GameController(
                new SwingGameView(),
                DeckFactory.makeDeck(DeckFactory.DeckType.Normal),
                new HighCardGameEvaluator());
        controller.run();
    }
}
