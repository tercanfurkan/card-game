package com.tercanfurkan.cardgame.model.deck;

import com.tercanfurkan.cardgame.model.PlayingCard;
import com.tercanfurkan.cardgame.model.Rank;
import com.tercanfurkan.cardgame.model.Suit;

import java.util.ArrayList;

public class TestDeck extends Deck {
    public TestDeck() {
        cards = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            cards.add(new PlayingCard(Rank.ACE, Suit.CLUBS));
        }
    }
}
