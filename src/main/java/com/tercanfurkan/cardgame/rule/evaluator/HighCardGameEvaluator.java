package com.tercanfurkan.cardgame.rule.evaluator;

import com.tercanfurkan.cardgame.model.IPlayer;

import java.util.Comparator;
import java.util.List;

public class HighCardGameEvaluator implements GameEvaluator {
    @Override
    public IPlayer evaluateWinner(List<IPlayer> players) {
        return players
                .stream()
                .max(Comparator.comparing(IPlayer::getCard))
                .orElseThrow();
    }
}
