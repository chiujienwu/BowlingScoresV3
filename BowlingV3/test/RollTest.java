import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollTest {

    @Test
    void testGetPins() {
        Roll newFirstRollTest = new Roll();
        int p = newFirstRollTest.getPins();
        assertTrue(p>=0 && p<=10);

        Roll newSecondRollTest = new Roll();
        int q = newSecondRollTest.getPins(p);
        assertTrue((p+q)>=0 && (p+q)<=10);
    }
}