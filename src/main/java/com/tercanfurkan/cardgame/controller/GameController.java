package com.tercanfurkan.cardgame.controller;

import com.tercanfurkan.cardgame.game.GameEvaluator;
import com.tercanfurkan.cardgame.model.IPlayer;
import com.tercanfurkan.cardgame.model.Player;
import com.tercanfurkan.cardgame.model.WinningPlayer;
import com.tercanfurkan.cardgame.model.deck.Deck;
import com.tercanfurkan.cardgame.model.PlayingCard;
import com.tercanfurkan.cardgame.view.IGameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed
    }

    IGameView view;
    Deck deck;
    List<IPlayer> players;
    IPlayer winner;
    GameState gameState;
    GameEvaluator evaluator;
    
    public GameController(IGameView view, Deck deck, GameEvaluator evaluator) {
        this.view = view;
        this.deck = deck;
        this.evaluator = evaluator;
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
        if (players.isEmpty()) {
            view.showFailedToStart("Unable to start without players");
            view.promptForPlayerName();
        } else if(gameState != GameState.CardsDealt) {
            deck.shuffle();
            int playerIndex = 1;
            for (IPlayer player : players) {
                player.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState = GameState.CardsDealt;
        }
    }
    public void flipCards() {
        int playerIndex = 1;
        for (IPlayer player : players) {
            PlayingCard card = player.takeCard(0);
            card.flip();
            view.showCardForPlayer(playerIndex++, player.getName(), card.getRank().toString(), card.getSuit().toString());
        }
        evaluateWinner();
        displayWinner();
        gameState = GameState.WinnerRevealed;
    }

    public void restartGame() {
        rebuildDeck();
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
    }

    void evaluateWinner() {
        winner = new WinningPlayer(evaluator.evaluateWinner(players));
    }
    void displayWinner() {
        view.showWinner(winner.getName());
    }

    void rebuildDeck() {
        for (IPlayer player : players) {
            deck.returnCardToDeck(player.putCardBack());
        }
    }
}
