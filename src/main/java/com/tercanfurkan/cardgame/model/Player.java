package com.tercanfurkan.cardgame.model;

public class Player {
    String name;
    Hand hand;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public void addCardToHand(PlayingCard card) {
        hand.addCard(card);
    }

    public String getName() {
        return name;
    }

    public PlayingCard takeCard(int index) {
        return hand.getCard(index);
    }

    public PlayingCard putCardBack() {
        return hand.removeCard();
    }
}
