package com.tercanfurkan.cardgame.model;

public class Player implements IPlayer {
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

    public PlayingCard getCard() {
        return hand.getCard();
    }

    public PlayingCard giveCard() {
        return hand.removeCard();
    }
}
