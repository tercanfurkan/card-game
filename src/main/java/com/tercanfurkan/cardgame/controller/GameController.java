package com.tercanfurkan.cardgame.controller;

import com.tercanfurkan.cardgame.model.IPlayer;
import com.tercanfurkan.cardgame.model.Player;
import com.tercanfurkan.cardgame.model.PlayingCard;
import com.tercanfurkan.cardgame.model.WinningPlayer;
import com.tercanfurkan.cardgame.model.deck.Deck;
import com.tercanfurkan.cardgame.rule.evaluator.GameEvaluator;
import com.tercanfurkan.cardgame.view.GameViews;
import com.tercanfurkan.cardgame.view.IGameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed,
        AddingView
    }

    GameViews views;
    Deck deck;
    List<IPlayer> players;
    IPlayer winner;
    GameState gameState;
    GameEvaluator evaluator;
    
    public GameController(IGameView view, Deck deck, GameEvaluator evaluator) {
        this.views = new GameViews();
        this.deck = deck;
        this.evaluator = evaluator;
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
        addView(view);
    }

    public void addView(IGameView view) {
        GameState currentState = gameState;
        gameState = GameState.AddingView;
        view.setController(this);
        views.addGameView(view);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gameState = currentState;
    }

    public void run() {
        while (true) {
            switch (gameState) {
                case AddingPlayers:
                    views.promptForPlayerName();
                    break;
                case CardsDealt:
                    views.promptForFlip();
                    break;
                case WinnerRevealed:
                    views.promptForNewGame();
                    break;
                case AddingView:
                    break;
            }
        }
    }

    public void addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers) {
            players.add(new Player(playerName));
            views.showPlayerName(players.size(), playerName);
        }
    }
    public void startGame() {
        if (players.isEmpty()) {
            views.showFailedToStart("Unable to start without players");
            views.promptForPlayerName();
        } else if(gameState != GameState.CardsDealt) {
            deck.shuffle();
            int playerIndex = 1;
            for (IPlayer player : players) {
                player.addCardToHand(deck.removeTopCard());
                views.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState = GameState.CardsDealt;
        }
    }
    public void flipCards() {
        int playerIndex = 1;
        for (IPlayer player : players) {
            PlayingCard card = player.getCard();
            card.flip();
            views.showCardForPlayer(playerIndex++, player.getName(), card.getRank().toString(), card.getSuit().toString());
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
        views.showWinner(winner.getName());
    }

    void rebuildDeck() {
        for (IPlayer player : players) {
            deck.returnCardToDeck(player.giveCard());
        }
    }
}
