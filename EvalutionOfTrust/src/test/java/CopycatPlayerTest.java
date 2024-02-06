import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopycatPlayerTest {

    @Test
    public void testCopyActionOfOtherPlayer() {
        Player cooperativePlayer = new CooperativePlayer();
        Player copycatPlayer = new CopycatPlayer();
        assertEquals(Action.CHEAT, copycatPlayer.act());
        assertEquals(Action.COOPERATE, copycatPlayer.act());
    }
}
