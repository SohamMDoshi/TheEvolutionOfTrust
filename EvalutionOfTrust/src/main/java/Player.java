import java.util.Random;

public class Player {

    private int score;

    public Player() {
        this.score  = 0;
    }
    public Action act() {
        return new Random().nextInt(2) == 0 ? Action.COOPERATE : Action.CHEAT;
    }

    public int score(){
        return this.score;
    }

    public void invest() {
        score+=(-1);
    }

    public void gain() {
        score+=3;
    }
}
