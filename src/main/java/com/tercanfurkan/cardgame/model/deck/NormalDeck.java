package com.tercanfurkan.cardgame.model.deck;

import com.tercanfurkan.cardgame.model.PlayingCard;
import com.tercanfurkan.cardgame.model.Rank;
import com.tercanfurkan.cardgame.model.Suit;

import java.util.ArrayList;

public class NormalDeck extends Deck {
    public NormalDeck() {
        cards = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                System.out.println("Creating card: [" + rank + ", " + suit + "]");
                cards.add(new PlayingCard(rank, suit));
            }
        }
        shuffle();
    }
}
