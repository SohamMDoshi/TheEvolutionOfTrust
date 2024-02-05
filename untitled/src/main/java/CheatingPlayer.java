public class CheatingPlayer implements Player{
    @Override
    public Action act() {
        return Action.CHEAT;
    }
}
