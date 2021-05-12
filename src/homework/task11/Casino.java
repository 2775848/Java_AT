package homework.task11;

import java.util.Random;

public class Casino {

    @Gamble(testRun = true)
    public void playPoker(){
        gambleResult("Poker");
    }

    @Gamble(testRun = false)
    public void playRoulette(){
        gambleResult("Roulette");
    }

    @Gamble(testRun = true)
    public void playBlackjack(){
        gambleResult("Blackjack");
    }

    public void playBaccarat(){
        gambleResult("Baccarat");
    }

    @Gamble(testRun = true)
    public void playWheelOfFortune(){
        gambleResult("WheelOfFortune");
    }

    void gambleResult(String gambleName) {
        System.out.print(gambleName + " result: ");
        if (new Random().nextBoolean()) {
            System.out.print("YOU WIN!!! ... ");
        } else {
            System.out.print("sorry \uD83D\uDE15 you loose ... ");
        }
        System.out.println(new Random().nextInt(1000) + "$");
    }


}

