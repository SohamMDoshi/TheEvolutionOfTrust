import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EoTMachineTest {

    @Test
    public void testPlayerBothPlayerCooperate() {
        EoTMachine eoTMachine = new EoTMachine();
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();
        eoTMachine.play(firstPlayer,Action.COOPERATE,secondPlayer,Action.COOPERATE);
        assertEquals(firstPlayer.getScore(), secondPlayer.getScore());
    }

    @Test
    public void testPlayerOnePlayerCheatAnotherCheat() {
        EoTMachine eoTMachine = new EoTMachine();
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();
        eoTMachine.play(firstPlayer,Action.CHEAT,secondPlayer,Action.COOPERATE);
        assertEquals(2,firstPlayer.getScore());
        assertEquals(-1,secondPlayer.getScore());
    }
}
