package com.tercanfurkan.cardgame.game;

import com.tercanfurkan.cardgame.controller.GameController;
import com.tercanfurkan.cardgame.model.deck.DeckFactory;
import com.tercanfurkan.cardgame.rule.evaluator.HighCardGameEvaluator;
import com.tercanfurkan.cardgame.rule.evaluator.LowCardGameEvaluator;
import com.tercanfurkan.cardgame.view.CommandLineGameView;

public class HighCardGameCLI {

    public static void main(String[] args) {
        GameController controller = new GameController(
                new CommandLineGameView(),
                DeckFactory.makeDeck(DeckFactory.DeckType.Normal),
                new HighCardGameEvaluator());
        controller.run();
    }
}