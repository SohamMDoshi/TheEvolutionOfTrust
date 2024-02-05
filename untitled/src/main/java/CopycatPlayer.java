public class CopycatPlayer implements Player{
    private Action lastOpponentAction;

    public CopycatPlayer() {
        this.lastOpponentAction = Action.CHEAT;
    }

    @Override
    public Action act() {
        return lastOpponentAction;
    }

    public void copyAction() {
        this.lastOpponentAction = Action.COOPERATE;
    }
}
