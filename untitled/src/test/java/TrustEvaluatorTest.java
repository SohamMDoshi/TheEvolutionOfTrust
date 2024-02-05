import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrustEvaluatorTest {

    @Test
    public void testPlayerBothPlayerCooperate() {
        Player firstPlayer = new AlwaysCheat();
        Player secondPlayer = new AlwaysCheat();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        trustEvaluator.evaluate(firstPlayer,Action.COOPERATE,secondPlayer,Action.COOPERATE);
        assertEquals(firstPlayer.getScore(), secondPlayer.getScore());
    }

    @Test
    public void testPlayerOnePlayerCheatAnotherCheat() {
        Player firstPlayer = new AlwaysCheat();
        Player secondPlayer = new AlwaysCheat();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        trustEvaluator.evaluate(firstPlayer,Action.CHEAT,secondPlayer,Action.COOPERATE);
        assertEquals(2,firstPlayer.getScore());
        assertEquals(-1,secondPlayer.getScore());
    }

    @Test
    public void testWhenTwoAlwaysCheatPlayerPlayEachOther() {
        Player firstPlayer = new AlwaysCheat();
        Player secondPlayer = new AlwaysCheat();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        trustEvaluator.play(5);
        assertEquals(0,firstPlayer.getScore());
        assertEquals(0,secondPlayer.getScore());
    }

    @Test
    public void testWhenTwoAlwaysCooperatePlayEachOther() {
        Player firstPlayer = new AlawysCooperate();
        Player secondPlayer = new AlawysCooperate();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        trustEvaluator.play(5);
        assertEquals(10,firstPlayer.getScore());
        assertEquals(10,secondPlayer.getScore());
    }

    @Test
    public void testWhenOneAlwaysCheatAndOneCooperatePlayerPlayEachOther() {
        Player firstPlayer = new AlawysCooperate();
        Player secondPlayer = new AlwaysCheat();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        trustEvaluator.play(5);
        assertEquals(-5,firstPlayer.getScore());
        assertEquals(15,secondPlayer.getScore());
    }
}
