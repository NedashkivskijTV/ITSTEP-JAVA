package edu.itstep.cw20220915.blackjack.deck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    public void create(){
        cards.clear();
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card getCard(){
        return cards.remove(cards.size() - 1);
    }

    public int getSize(){
        return cards.size();
    }

    public void showDeck(){
        for (Card card : cards) {
            card.toString();
        }
    }

    public int deckNominal(){
        int nominal = 0;
        for (Card card : cards) {
            nominal += card.getValue().getNominal();
        }
        return nominal;
    }
}
