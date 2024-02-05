public class TrustEvaluator {
    private final Player firstPlayer;
    private final Player secondPlayer;
    private int scoreOfPlayerOne;
    private int scoreOfAnotherPlayer;

    public TrustEvaluator(Player player1, Player player2) {
        this.firstPlayer = player1;
        this.scoreOfPlayerOne = 0;
        this.secondPlayer = player2;
        this.scoreOfAnotherPlayer = 0;
    }

    public int[] simulate(int round) {
        for (int i = 1; i <= round; i++) {
            Action actionOfPlayerOne = firstPlayer.act();
            Action actionOfPlayerTwo = secondPlayer.act();

            evaluate(actionOfPlayerOne, actionOfPlayerTwo,i);
        }
        return new int[]{scoreOfPlayerOne, scoreOfAnotherPlayer};
    }

    private void evaluate(Action actionOfFirstPlayer, Action actionOfSecondPlayer,int round) {
        if (actionOfFirstPlayer == Action.COOPERATE && actionOfSecondPlayer == Action.CHEAT) {
            scoreOfPlayerOne--;
            scoreOfAnotherPlayer += 3;
        } else if (actionOfFirstPlayer == Action.COOPERATE && actionOfSecondPlayer == Action.COOPERATE) {
            scoreOfPlayerOne += 2;
            scoreOfAnotherPlayer += 2;
        } else if (actionOfFirstPlayer == Action.CHEAT && actionOfSecondPlayer == Action.COOPERATE) {
            scoreOfPlayerOne += 3;
            scoreOfAnotherPlayer--;
        }
        if (firstPlayer instanceof CopycatPlayer){
            if(round == 1 && (scoreOfPlayerOne == 3 && scoreOfAnotherPlayer == -1)) ((CopycatPlayer) firstPlayer).copyAction();
            else if (round > 1 && secondPlayer instanceof CopyKittenPlayer) ((CopycatPlayer) firstPlayer).copyAction();
        }
        if (secondPlayer instanceof CopycatPlayer)
            if(round == 1 && (scoreOfPlayerOne == -1 && scoreOfAnotherPlayer == 3)) ((CopycatPlayer) secondPlayer).copyAction();
            else if (round > 1 && firstPlayer instanceof CopyKittenPlayer) ((CopycatPlayer) secondPlayer).copyAction();
        if (firstPlayer instanceof CopyKittenPlayer){
            if(round == 1 && (scoreOfPlayerOne == -1 && scoreOfAnotherPlayer == -3)) ((CopyKittenPlayer) firstPlayer).copyAction();
            else if (round > 1 && secondPlayer instanceof CopycatPlayer) ((CopyKittenPlayer) firstPlayer).copyAction();
        }
        if (secondPlayer instanceof CopyKittenPlayer)
            if(round == 1 && (scoreOfPlayerOne == 3 && scoreOfAnotherPlayer == -1)) ((CopyKittenPlayer) secondPlayer).copyAction();
            else if (round > 1 && firstPlayer instanceof CopycatPlayer) ((CopyKittenPlayer) secondPlayer).copyAction();
    }
}
