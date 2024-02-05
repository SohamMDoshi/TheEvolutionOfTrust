public class AlawysCooperate extends Player{

    public AlawysCooperate() {
        super();
    }

    @Override
    public Action action(Player opponent) {
        return Action.COOPERATE;
    }
}
