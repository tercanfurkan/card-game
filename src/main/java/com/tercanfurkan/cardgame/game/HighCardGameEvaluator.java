package com.tercanfurkan.cardgame.game;

import com.tercanfurkan.cardgame.model.Player;
import com.tercanfurkan.cardgame.model.PlayingCard;

import java.util.List;

public class HighCardGameEvaluator implements GameEvaluator{
    @Override
    public Player evaluateWinner(List<Player> players) {
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (Player player : players) {
            boolean newBestPlayer = false;

            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard card = player.takeCard(0);
                int thisRank = card.getRank().value();
                if (thisRank >= bestRank) {
                    if (thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (card.getSuit().value() > bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }
            if (newBestPlayer) {
                bestPlayer = player;
                PlayingCard card = player.takeCard(0);
                bestRank = card.getRank().value();
                bestSuit = card.getSuit().value();
            }
        }
        return bestPlayer;
    }
}
