package com.tercanfurkan.cardgame.controller.state;

import com.tercanfurkan.cardgame.controller.GameController;
import com.tercanfurkan.cardgame.view.GameViews;

public class CardsDealtState extends GameState {

    public CardsDealtState(GameController controller, GameViews views) {
        super(controller, views);
    }

    @Override
    public void next() {
        controller.setState(new WinnerRevealedState(controller, views));
        views.promptForNewGame();
    }
}
