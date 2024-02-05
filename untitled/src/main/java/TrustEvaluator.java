public class TrustEvaluator {

    private Player firstPlayer;

    private Player secondPlayer;

    private int scoreOfPlayerOne;
    private int scoreOfAnotherPlayer;

    public TrustEvaluator(Player player1, Player player2) {
        this.firstPlayer = player1;
        this.scoreOfPlayerOne =0;
        this.secondPlayer = player2;
        this.scoreOfAnotherPlayer = 0;
    };

    public int[] simulate(int round) {
        for (int i = 1; i <= round ; i++) {
            Action actionOfPlayerOne = firstPlayer.act();
            Action actionOfPlayerTwo = secondPlayer.act();

            evaluate(actionOfPlayerOne,actionOfPlayerTwo);
        }
        return new int[] {scoreOfPlayerOne,scoreOfAnotherPlayer};
    }

    private void evaluate(Action actionOfFirstPlayer,Action actionOfSecondPlayer) {
        if (actionOfFirstPlayer == Action.COOPERATE && actionOfSecondPlayer == Action.CHEAT) {
            scoreOfPlayerOne--;
            scoreOfAnotherPlayer+=3;
        }
        else if (actionOfFirstPlayer == Action.COOPERATE && actionOfSecondPlayer == Action.COOPERATE) {
            scoreOfPlayerOne+=2;
            scoreOfAnotherPlayer+=2;
        }
        else if(actionOfFirstPlayer == Action.CHEAT && actionOfSecondPlayer == Action.COOPERATE) {
            scoreOfPlayerOne+=3;
            scoreOfAnotherPlayer--;
        }
        if (firstPlayer instanceof CopycatPlayer) ((CopycatPlayer) firstPlayer).updateLastOpponentAction(actionOfSecondPlayer);
        if (secondPlayer instanceof CopycatPlayer) ((CopycatPlayer) secondPlayer).updateLastOpponentAction(actionOfFirstPlayer);
    }


}
