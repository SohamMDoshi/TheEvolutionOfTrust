public class CopycatPlayer implements Player{
    private Action lastOpponentAction;

    public CopycatPlayer() {
        this.lastOpponentAction = Action.CHEAT;
    }

    public void updateLastOpponentAction(Action opponentAction) {
        this.lastOpponentAction = opponentAction;
    }

    @Override
    public Action act() {
        return lastOpponentAction;
    }
}
