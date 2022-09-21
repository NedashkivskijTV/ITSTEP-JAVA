package edu.itstep.cw20220915.blackjack.player;

import edu.itstep.cw20220915.blackjack.deck.Card;

public class User extends Player{
    public void showUserCards(){
        for (Card card : getCards()) {
            System.out.println(card);
        }
    }
}
