package com.tercanfurkan.cardgame.model;

public class WinningPlayer implements IPlayer {
    IPlayer winningPlayer;

    public WinningPlayer(IPlayer player) {
        this.winningPlayer = player;
    }

    @Override
    public void addCardToHand(PlayingCard card) {

    }

    @Override
    public String getName() {
        return "***** " + winningPlayer.getName() + " *****";
    }

    @Override
    public PlayingCard getCard() {
        return null;
    }

    @Override
    public PlayingCard giveCard() {
        return null;
    }
}
