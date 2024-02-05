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
        if(lastOpponentAction == Action.CHEAT)this.lastOpponentAction = Action.COOPERATE;
        else this.lastOpponentAction = Action.CHEAT;
    }
}
