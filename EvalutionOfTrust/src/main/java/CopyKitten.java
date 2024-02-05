public class CopyKitten implements Player{
    private Action lastOpponentAction;

    public CopyKitten() {
        this.lastOpponentAction = Action.COOPERATE;
    }

    @Override
    public Action act() {
        return lastOpponentAction;
    }

    public void copyAction() {
        this.lastOpponentAction = Action.CHEAT;
    }
}
