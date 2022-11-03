package com.tercanfurkan.cardgame.model.deck;

import com.tercanfurkan.cardgame.model.PlayingCard;
import com.tercanfurkan.cardgame.model.Rank;
import com.tercanfurkan.cardgame.model.Suit;

import java.util.ArrayList;

public class SmallDeck extends Deck {
    public SmallDeck() {
        cards = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                if (rank.value() >= 7) {
                    System.out.println("Creating card: [" + rank + ", " + suit + "]");
                    cards.add(new PlayingCard(rank, suit));
                }
            }
        }
        shuffle();
    }
}
