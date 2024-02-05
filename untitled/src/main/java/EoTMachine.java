public class EoTMachine {

    public EoTMachine() {};

    public void play(Player firstPlayer, Action actionOfFirstPlayer, Player secondPlayer, Action actionOfSecondPlayer) {
        ScoringSystem.resolve(firstPlayer,actionOfFirstPlayer,secondPlayer,actionOfSecondPlayer);
    }


}
