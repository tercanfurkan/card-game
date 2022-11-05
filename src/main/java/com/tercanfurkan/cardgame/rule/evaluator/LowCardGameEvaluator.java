package com.tercanfurkan.cardgame.rule.evaluator;

import com.tercanfurkan.cardgame.model.IPlayer;

import java.util.Comparator;
import java.util.List;

public class LowCardGameEvaluator implements GameEvaluator {
    @Override
    public IPlayer evaluateWinner(List<IPlayer> players) {
        return players
                .stream()
                .min(Comparator.comparing(player -> player.takeCard(0)))
                .orElseThrow();
    }
}
