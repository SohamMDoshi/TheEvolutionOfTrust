public class CopyKittenPlayer implements Player{
    private Action lastOpponentAction;

    public CopyKittenPlayer() {
        this.lastOpponentAction = Action.COOPERATE;
    }

    @Override
    public Action act() {
        return lastOpponentAction;
    }

    public void copyAction() {

        if(this.lastOpponentAction == Action.CHEAT) lastOpponentAction = Action.COOPERATE;
        else this.lastOpponentAction = Action.CHEAT;
    }
}
