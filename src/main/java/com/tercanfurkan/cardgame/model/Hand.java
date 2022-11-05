package com.tercanfurkan.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<PlayingCard> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    public PlayingCard getCard() {
        return cards.get(0);
    }

    public PlayingCard removeCard() {
        return cards.remove(0);
    }
}
