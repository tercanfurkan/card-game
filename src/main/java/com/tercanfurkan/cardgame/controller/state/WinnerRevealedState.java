package com.tercanfurkan.cardgame.controller.state;

import com.tercanfurkan.cardgame.controller.GameController;
import com.tercanfurkan.cardgame.view.GameViews;

public class WinnerRevealedState extends GameState {

    public WinnerRevealedState(GameController controller, GameViews views) {
        super(controller, views);
    }

    @Override
    public void next() {
        controller.setState(new AddingPlayersState(controller, views));
        views.promptForPlayerName();
    }
}
