public class CopyKittenPlayer extends Player{


    private boolean gainedLastRound = true;

    public CopyKittenPlayer() {
        super();
    }

    @Override
    public Action act() {
        Action action = Action.CHEAT;
        if(gainedLastRound)
            action = Action.COOPERATE;

        gainedLastRound = false;
        return action;
    }

    @Override
    public void gain(){
        this.gainedLastRound = true;
        super.gain();
    }
}
