import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopyKittenPlayerTest {

    @Test
    public void testCopyKittenCopyingCopyCatAction() {
        Player playerOne = new CopyKittenPlayer();
        Player playerTwo = new CopycatPlayer();
        assertEquals(Action.COOPERATE, playerOne.act());
        assertEquals(Action.CHEAT,playerTwo.act());
        assertEquals(Action.COOPERATE,playerTwo.act());

    }
}
