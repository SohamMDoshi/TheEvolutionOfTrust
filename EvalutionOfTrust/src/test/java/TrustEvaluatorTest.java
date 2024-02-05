import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrustEvaluatorTest {

    @Test
    public void testWhenTwoAlwaysCheatingPlayerPlayEachOther() {
        Player firstPlayer = new CheatingPlayer();
        Player secondPlayer = new CheatingPlayer();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        int[] result = trustEvaluator.simulate(5);
        int scoreOfFirstPlayer = result[0];
        int scoreOfSecondPlayer = result[1];
        assertEquals(0,scoreOfFirstPlayer);
        assertEquals(0,scoreOfSecondPlayer);
    }

    @Test
    public void testWhenTwoAlwaysCooperativePlayEachOther() {
        Player firstPlayer = new CooperativePlayer();
        Player secondPlayer = new CooperativePlayer();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        int[] result = trustEvaluator.simulate(5);
        int scoreOfFirstPlayer = result[0];
        int scoreOfSecondPlayer = result[1];
        assertEquals(10,scoreOfFirstPlayer);
        assertEquals(10,scoreOfSecondPlayer);
    }

    @Test
    public void testWhenOneCheatingAndOneCooperativePlayerPlayEachOther() {
        Player firstPlayer = new CooperativePlayer();
        Player secondPlayer = new CheatingPlayer();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        int[] result = trustEvaluator.simulate(5);
        int scoreOfFirstPlayer = result[0];
        int scoreOfSecondPlayer = result[1];
        assertEquals(-5,scoreOfFirstPlayer);
        assertEquals(15,scoreOfSecondPlayer);
    }

    @Test
    public void testWhenTwoCopyKittenPlayerPlayEachOther() {
        Player firstPlayer = new CopyKittenPlayer();
        Player secondPlayer = new CopyKittenPlayer();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        int[] result = trustEvaluator.simulate(5);
        int scoreOfFirstPlayer = result[0];
        int scoreOfSecondPlayer = result[1];
        assertEquals(10,scoreOfFirstPlayer);
        assertEquals(10,scoreOfSecondPlayer);
    }

    @Test
    public void testWhenOneCopyKittenPlayerAndCooperativePlayerPlayEachOther() {
        Player firstPlayer = new CopyKittenPlayer();
        Player secondPlayer = new CooperativePlayer();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        int[] result = trustEvaluator.simulate(5);
        int scoreOfFirstPlayer = result[0];
        int scoreOfSecondPlayer = result[1];
        assertEquals(10,scoreOfFirstPlayer);
        assertEquals(10,scoreOfSecondPlayer);
    }

    @Test
    public void testWhenOneCopyKittenPlayerAndCheatingPlayerPlayEachOther() {
        Player firstPlayer = new CheatingPlayer();
        Player secondPlayer = new CopyKittenPlayer();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        int[] result = trustEvaluator.simulate(5);
        int scoreOfFirstPlayer = result[0];
        int scoreOfSecondPlayer = result[1];
        assertEquals(3,scoreOfFirstPlayer);
        assertEquals(-1,scoreOfSecondPlayer);
    }

    @Test
    public void testWhenOneCopyKittenPlayerAndCopycatPlayerPlayEachOther() {
        Player firstPlayer = new CopyKittenPlayer();
        Player secondPlayer = new CopycatPlayer();
        TrustEvaluator trustEvaluator = new TrustEvaluator(firstPlayer,secondPlayer);
        int[] result = trustEvaluator.simulate(5);
        int scoreOfFirstPlayer = result[0];
        int scoreOfSecondPlayer = result[1];
        assertEquals(3,scoreOfFirstPlayer);
        assertEquals(7,scoreOfSecondPlayer);
    }
}
