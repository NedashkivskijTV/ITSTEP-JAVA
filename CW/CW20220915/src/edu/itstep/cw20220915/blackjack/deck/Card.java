package edu.itstep.cw20220915.blackjack.deck;

public class Card {
    private Suit suit; //масть
    private Value value; //достоинство - значення

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card= " + suit.getImg() + " " + value ;
    }
}
