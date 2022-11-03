package com.tercanfurkan.cardgame.game;

import com.tercanfurkan.cardgame.model.Player;
import com.tercanfurkan.cardgame.model.PlayingCard;

import java.util.List;

public interface GameEvaluator {
    public Player evaluateWinner(List<Player> players);
}