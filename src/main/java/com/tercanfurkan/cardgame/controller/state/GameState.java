package com.tercanfurkan.cardgame.controller.state;

import com.tercanfurkan.cardgame.controller.GameController;
import com.tercanfurkan.cardgame.view.GameViews;

public abstract class GameState {
    final GameController controller;
    final GameViews views;

    public GameState(GameController controller, GameViews views) {
        this.controller = controller;
        this.views = views;
    }

    public abstract void next();
}
