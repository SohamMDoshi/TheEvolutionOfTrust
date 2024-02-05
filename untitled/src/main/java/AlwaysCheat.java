public class AlwaysCheat extends Player{

    public AlwaysCheat() {
        super();
    }
    @Override
    public Action action(Player opponent) {
        return Action.CHEAT;
    }
}
