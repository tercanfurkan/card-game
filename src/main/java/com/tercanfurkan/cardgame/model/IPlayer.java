package com.tercanfurkan.cardgame.model;

public interface IPlayer {
    void addCardToHand(PlayingCard card);

    String getName();

    PlayingCard getCard();

    PlayingCard giveCard();
}
