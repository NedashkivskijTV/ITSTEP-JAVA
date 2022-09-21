package edu.itstep.cw20220915.blackjack.game;

import edu.itstep.cw20220915.blackjack.deck.Deck;
import edu.itstep.cw20220915.blackjack.player.Dealer;
import edu.itstep.cw20220915.blackjack.player.User;

import java.util.Scanner;

public class Game {
    private Dealer dealer = new Dealer();
    private User user = new User();
    private Deck deck = new Deck();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        //int choice = 0;

        begin();

        //System.out.println(deck.getSize());

        //user бере карты
        //System.out.println("Dealer cards score = " + dealer.DeckNominal());
        while (user.deckNominal() < 21) {
            dealer.showFirstCard();
            System.out.println("Count Dealer cards = " + dealer.getCards().size());

            showUserCards();

            System.out.println("Бажаєте взяти ще 1 карту ? 1 - ТАК, 0 - НІ");
            //choice = scanner.nextInt();
            if (scanner.nextInt() == 0) {
                break;
            }
            user.addCard(deck.getCard());

        }

        //dealer бере карты
        while (user.deckNominal() < 21 && dealer.deckNominal() < 17) {
            dealer.addCard(deck.getCard());
        }
        System.out.println("Count Dealer cards = " + dealer.getCards().size());
        System.out.println("Dealer cards score = " + dealer.deckNominal());

        showWinner();
    }

    private void showUserCards() {
        System.out.println("----------- User cards --------------------");
        user.showUserCards();
        System.out.println("User cards score = " + user.deckNominal());
        System.out.println("Count User cards = " + user.getCards().size());
    }

    private void begin() {
        deck.create();
        deck.shuffle();
        dealer.addCard(deck.getCard());
        dealer.addCard(deck.getCard());
        user.addCard(deck.getCard());
        user.addCard(deck.getCard());
    }

    private void showWinner() {
        System.out.println("-------------- Show Winner ------------------------");

        // перехват перебору !!!!!!!!!!!!!!!!!!!!!!
//        if(user.DeckNominal() > 21){
//            System.out.println("Dealer winn");
//        }else if()

        if(user.deckNominal() == 21){
            System.out.println("User winn");
        }else if(dealer.deckNominal() == 21){
            System.out.println("Dealer winn");
        }else if(user.deckNominal() > dealer.deckNominal()){
            System.out.println("User winn");
        }else{
            System.out.println("Dealer winn");
        }
        gameScore();
    }

    private void gameScore(){
        System.out.println("Dealer cards score = " + dealer.deckNominal());
        System.out.println("User cards score = " + user.deckNominal());
    }
}
