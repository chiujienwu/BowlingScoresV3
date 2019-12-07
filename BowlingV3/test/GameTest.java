import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testGame() {
        Game testGame = new Game();

        for (int x = 0; x < 10; x++) {
            if (testGame.gameRolls[x].isStrike) {
                assertTrue(testGame.gameRolls[x].pins1 == 10);
            }

            if (testGame.gameRolls[x].isSpare) {
                assertTrue((testGame.gameRolls[x].pins1 + testGame.gameRolls[x].pins2) == 10);
            }

            if (testGame.gameRolls[x].isSpare == false && testGame.gameRolls[x].isStrike == false)
            {
                assertTrue((testGame.gameRolls[x].pins1 + testGame.gameRolls[x].pins2) < 10);
            }
        }
    }
}