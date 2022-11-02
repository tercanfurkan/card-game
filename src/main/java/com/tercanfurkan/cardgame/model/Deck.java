package com.tercanfurkan.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    List<PlayingCard> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                System.out.println("Creating card: [" + rank + ", " + suit + "]");
                cards.add(new PlayingCard(rank, suit));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            Collections.swap(cards, i, random.nextInt(cards.size()));
        }
    }

    public PlayingCard removeTopCard() {
        return cards.remove(0);
    }

    public void returnCardToDeck(PlayingCard card) {
        cards.add(card);
    }
}
