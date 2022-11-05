package com.tercanfurkan.cardgame.rule.evaluator;

import com.tercanfurkan.cardgame.model.IPlayer;

import java.util.List;

public interface GameEvaluator {
    IPlayer evaluateWinner(List<IPlayer> players);
}