package com.tercanfurkan.cardgame.model;

public class PlayingCard implements Comparable<PlayingCard> {
    Rank rank;
    Suit suit;
    boolean faceUp;

    public PlayingCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.faceUp = false;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void flip() {
        this.faceUp = !faceUp;
    }

    @Override
    public int compareTo(PlayingCard o) {
        if (this.getRank().value() > o.getRank().value()) {
            return 1;
        } else if (this.getRank().value() < o.getRank().value()){
            return -1;
        } else {
            if (this.getSuit().value() >= o.getSuit().value()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
