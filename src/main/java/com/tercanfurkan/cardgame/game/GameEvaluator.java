package com.tercanfurkan.cardgame.game;

import com.tercanfurkan.cardgame.model.IPlayer;

import java.util.List;

public interface GameEvaluator {
    public IPlayer evaluateWinner(List<IPlayer> players);
}