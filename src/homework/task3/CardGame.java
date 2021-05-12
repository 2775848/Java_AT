package homework.task3;

import java.util.Random;
import java.util.Scanner;

public class CardGame {
    public static int NUMBER_OF_PLAYERS;
    public final static int CARDS_IN_HAND = 6;

    public static void main(String[]args) {
        // ввод числа игроков через консоль, не по условию задачи... просто для тренировки
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number of players (from 1 to 6):");
        if (sc.hasNextInt()) {
            NUMBER_OF_PLAYERS = sc.nextInt();
        }
        if (NUMBER_OF_PLAYERS < 1 || NUMBER_OF_PLAYERS > 6) {
            System.out.println("Invalid number of players, game over!");
            return;
        }
        // раздача
        CardDeck cardDeck = new CardDeck();
        for (int i = 1; i <= NUMBER_OF_PLAYERS; i++) {
            System.out.print("Hand" + i + ":");
            for (int j = 1; j <= CARDS_IN_HAND; j++) {
                System.out.print(" " + cardDeck.getCard());
            }
            System.out.println();
        }

        // доп.методы
        System.out.println("----------------------------------------------");
        System.out.println("Cards remaining: " + cardDeck.remained());
        cardDeck.reset();
        System.out.println("Cards remaining: " + cardDeck.remained());
    }
}

class CardDeck {
    private final String[] cardSuits = {"\u2660", "\u2665", "\u2663", "\u2666"};
    private final String[] cardRanks = {"6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private int cardsRemaining = cardRanks.length * cardSuits.length;
    private final Random r = new Random();
    private final StringBuilder usedCards = new StringBuilder();

    public String getCard() {
        if (cardsRemaining == 0) {
            return "\n <deck is over>";
        }
        String newCard;
        do {
            newCard = cardRanks[r.nextInt(cardRanks.length)] + cardSuits[r.nextInt(cardSuits.length)];
        } while ( usedCards.toString().contains(newCard) );
        usedCards.append(newCard);
        cardsRemaining--;
        return newCard;
    }


    /* дополнительные методы, опять же не по условию, а для тренировки  */

    // сбросить колоду
    public void reset() {
        usedCards.delete(0, usedCards.length());
        cardsRemaining = cardRanks.length * cardSuits.length;
        System.out.println("Reset deck");
    }

    //узнать остаток карт в колоде
    public int remained() {
        return cardsRemaining;
    }
}
