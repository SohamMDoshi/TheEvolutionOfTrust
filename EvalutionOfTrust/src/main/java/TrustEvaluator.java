public class TrustEvaluator {
    private final Player firstPlayer;
    private final Player secondPlayer;


    public TrustEvaluator(Player player1, Player player2) {
        this.firstPlayer = player1;
        this.secondPlayer = player2;
    }

    public int[] simulate(int round) {
        for (int i = 1; i <= round; i++) {
            evaluate();
        }
        return new int[]{firstPlayer.score(), secondPlayer.score()};
    }

    private void evaluate() {

        Action playerOneChoice = firstPlayer.act();
        Action playerTwoChoice = secondPlayer.act();

        if(playerOneChoice == Action.COOPERATE){
            this.firstPlayer.invest();
            this.secondPlayer.gain();
        }
        if(playerTwoChoice == Action.COOPERATE){
            this.secondPlayer.invest();
            this.firstPlayer.gain();
        }
    }


}
