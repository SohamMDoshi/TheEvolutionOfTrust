import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrudgerPlayerTest {

    @Test
    public void testCheckActionWhenOtherPlayerCheats() {
        GrudgerPlayer playerOne = new GrudgerPlayer();
        Player playerTwo = new CheatingPlayer();

        assertEquals(Action.COOPERATE, playerOne.act());
        assertEquals(Action.CHEAT, playerOne.act());
    }
}
