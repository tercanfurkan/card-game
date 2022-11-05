package com.tercanfurkan.cardgame.controller.state;

import com.tercanfurkan.cardgame.controller.GameController;
import com.tercanfurkan.cardgame.view.GameViews;

public class AddingPlayersState extends GameState {
    public AddingPlayersState(GameController controller, GameViews views) {
        super(controller, views);
    }

    @Override
    public void next() {
        controller.setState(new CardsDealtState(controller, views));
        views.promptForFlip();
    }
}
