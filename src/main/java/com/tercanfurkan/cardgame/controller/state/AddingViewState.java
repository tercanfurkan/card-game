package com.tercanfurkan.cardgame.controller.state;

import com.tercanfurkan.cardgame.controller.GameController;
import com.tercanfurkan.cardgame.view.GameViews;

public class AddingViewState extends GameState {

    final GameState currentState;

    public AddingViewState(GameController controller, GameViews views) {
        super(controller, views);
        this.currentState = controller.getState();
    }

    @Override
    public void next() {
        controller.setState(currentState);
    }
}
