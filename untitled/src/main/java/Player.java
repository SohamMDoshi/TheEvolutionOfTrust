public abstract class Player {

    private int score;

    public Player() {
        this.score = 0;
    }

    public void minusPoint() {
        score--;
    }

    public void plusTwoPoints() {
        score+=2;
    }

    public void plusThreePoints() {
        score+=3;
    }

    public int getScore() {
        return score;
    }

    public abstract Action action(Player opponent);
}
