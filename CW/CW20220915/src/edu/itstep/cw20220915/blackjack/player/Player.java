package edu.itstep.cw20220915.blackjack.player;

import edu.itstep.cw20220915.blackjack.deck.Card;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    public int deckNominal(){
        int nominal = 0;
        for (Card card : cards) {
            nominal += card.getValue().getNominal();
        }
        return nominal;
    }
}
