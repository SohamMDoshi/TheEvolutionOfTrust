public class ScoringSystem {
    public static void resolve(Player firstPlayer, Action actionOfFirstPlayer, Player secondPlayer, Action actionOfSecondPlayer){
        if (actionOfFirstPlayer == Action.COOPERATE && actionOfSecondPlayer == Action.CHEAT) {
            firstPlayer.addToScore(-1);
            secondPlayer.addToScore(2);
        }
        else if (actionOfFirstPlayer == Action.COOPERATE && actionOfSecondPlayer == Action.COOPERATE) {
            firstPlayer.addToScore(2);
            secondPlayer.addToScore(2);
        }
        else if(actionOfFirstPlayer == Action.CHEAT && actionOfSecondPlayer == Action.COOPERATE) {
            firstPlayer.addToScore(2);
            secondPlayer.addToScore(-1);
        }
    }
}
