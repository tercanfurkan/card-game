package com.tercanfurkan.cardgame.controller;

import com.tercanfurkan.cardgame.controller.state.AddingViewState;
import com.tercanfurkan.cardgame.controller.state.AddingPlayersState;
import com.tercanfurkan.cardgame.controller.state.CardsDealtState;
import com.tercanfurkan.cardgame.controller.state.GameState;
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

    GameViews views;
    Deck deck;
    List<IPlayer> players;
    IPlayer winner;
    GameEvaluator evaluator;
    GameState gameState;
    
    public GameController(IGameView view, Deck deck, GameEvaluator evaluator) {
        this.views = new GameViews();
        this.deck = deck;
        this.evaluator = evaluator;
        players = new ArrayList<>();
        view.setController(this);
        views.addGameView(view);
        gameState = new AddingPlayersState(this, views);
    }

    public void setState(GameState newState) {
        gameState = newState;
    }

    public GameState getState() {
        return gameState;
    }

    public void addView(IGameView view) {
        gameState = new AddingViewState(this, views);
        view.setController(this);
        views.addGameView(view);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gameState.next();
    }

    public void run() {
        views.promptForPlayerName();
    }

    public void addPlayer(String playerName) {
        if (gameState instanceof AddingPlayersState) {
            players.add(new Player(playerName));
            views.showPlayerName(players.size(), playerName);
            views.promptForPlayerName();
        }
    }
    public void startGame() {
        if (players.isEmpty()) {
            views.showFailedToStart("Please add players to start");
            views.promptForPlayerName();
        } else if(!(gameState instanceof CardsDealtState)) {
            deck.shuffle();
            int playerIndex = 1;
            for (IPlayer player : players) {
                player.addCardToHand(deck.removeTopCard());
                views.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState.next();
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
        gameState.next();
    }

    public void restartGame() {
        rebuildDeck();
        players = new ArrayList<>();
        gameState.next();
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
