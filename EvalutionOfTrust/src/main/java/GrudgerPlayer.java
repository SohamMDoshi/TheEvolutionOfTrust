public class GrudgerPlayer extends Player{

    private boolean cheat = false;
    private int cheatCount = 0;
    public GrudgerPlayer() {
       super();
    }

    @Override
    public Action act() {
        if(cheatCount==1){
            cheat = true;
        }
        Action action = Action.COOPERATE;
        if(cheat)
            action = Action.CHEAT;

        return action;
    }

    @Override
    public void invest() {
        cheatCount++;
        super.invest();
    }

    @Override
    public void gain() {
        cheatCount--;
        super.gain();
    }
}
