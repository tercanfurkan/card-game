package com.tercanfurkan.cardgame;

import com.tercanfurkan.cardgame.model.Deck;
import com.tercanfurkan.cardgame.model.Player;
import com.tercanfurkan.cardgame.model.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed
    }

    GameView view;
    Deck deck;
    List<Player> players;
    Player winner;
    GameState gameState;
    
    public GameController(GameView view, Deck deck) {
        this.view = view;
        this.deck = deck;
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
        view.setController(this);
    }

    public void run() {
        while (true) {
            switch (gameState) {
                case AddingPlayers:
                    view.promptForPlayerName();
                    break;
                case CardsDealt:
                    view.promptForFlip();
                    break;
                case WinnerRevealed:
                    view.promptForNewGame();
                    break;
            }
        }
    }

    public void addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers) {
            players.add(new Player(playerName));
            view.showPlayerName(players.size(), playerName);
        }
    }
    public void startGame() {
        if (gameState != GameState.CardsDealt) {
            deck.shuffle();
            int playerIndex = 1;
            for (Player player : players) {
                player.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState = GameState.CardsDealt;
        }
    }
    public void flipCards() {
        int playerIndex = 1;
        for (Player player : players) {
            PlayingCard card = player.takeCard(0);
            card.flip();
            view.showCardForPlayer(playerIndex++, player.getName(), card.getRank().toString(), card.getSuit().toString());
        }
        evaluateWinner();
        displayWinner();
        gameState = GameState.WinnerRevealed;
        rebuildDeck();
    }

    void evaluateWinner() {
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (Player player : players) {
            boolean newBestPlayer = false;

            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard card = player.takeCard(0);
                int thisRank = card.getRank().value();
                if (thisRank >= bestRank) {
                    if (thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (card.getSuit().value() > bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }
            if (newBestPlayer) {
                bestPlayer = player;
                PlayingCard card = player.takeCard(0);
                bestRank = card.getRank().value();
                bestSuit = card.getSuit().value();
            }
        }
        winner = bestPlayer;
    }
    void displayWinner() {
        view.showWinner(winner.getName());
    }
    void rebuildDeck() {
        for (Player player : players) {
            deck.returnCardToDeck(player.putCardBack());
        }
    }
}
