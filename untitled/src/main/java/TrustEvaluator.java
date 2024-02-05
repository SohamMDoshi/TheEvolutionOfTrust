public class TrustEvaluator {

    private Player firstPlayer;

    private Player secondPlayer;

    public TrustEvaluator(Player player1, Player player2) {
        this.firstPlayer = player1;
        this.secondPlayer = player2;
    };

    public void play(int round) {
        for (int i = 1; i <= round ; i++) {
            Action actionOfPlayerOne = firstPlayer.action(secondPlayer);
            Action actionOfPlayerTwo = secondPlayer.action(firstPlayer);

            evaluate(firstPlayer, actionOfPlayerOne,secondPlayer,actionOfPlayerTwo);
        }
    }

    public void evaluate(Player firstPlayer, Action actionOfFirstPlayer, Player secondPlayer, Action actionOfSecondPlayer) {
        if (actionOfFirstPlayer == Action.COOPERATE && actionOfSecondPlayer == Action.CHEAT) {
            firstPlayer.minusPoint();
            secondPlayer.plusThreePoints();
        }
        else if (actionOfFirstPlayer == Action.COOPERATE && actionOfSecondPlayer == Action.COOPERATE) {
            firstPlayer.plusTwoPoints();
            secondPlayer.plusTwoPoints();
        }
        else if(actionOfFirstPlayer == Action.CHEAT && actionOfSecondPlayer == Action.COOPERATE) {
            firstPlayer.plusThreePoints();
            secondPlayer.minusPoint();
        }
    }


}
