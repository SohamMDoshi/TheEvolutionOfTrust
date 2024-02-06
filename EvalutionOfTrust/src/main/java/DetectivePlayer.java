public class DetectivePlayer extends Player{

    private int roundNo = 0;
    private boolean investedLastRound = false;
    private boolean gainedLastRound = false;
    private boolean isCopyCat = false;


    @Override
    public Action act() {
        roundNo++;
        Action action = Action.CHEAT;
        if(roundNo==1)
            action = Action.COOPERATE;
        else if(roundNo==2)
            action = Action.CHEAT;

        if (investedLastRound && !this.isCopyCat) {
            this.isCopyCat = true;
        }
        if (this.isCopyCat && this.roundNo > 2) {
            if (gainedLastRound) {
                action = Action.COOPERATE;
            }
            gainedLastRound = false;
        }

        return action;
    }

    @Override
    public void invest() {
        investedLastRound = true;
        super.invest();
    }

    @Override
    public void gain() {
        gainedLastRound = true;
        if (investedLastRound)
            investedLastRound = false;

        super.gain();
    }
}
