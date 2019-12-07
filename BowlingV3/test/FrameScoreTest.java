import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameScoreTest {

    @Test
    void frameScore() {

        for (int x = 1; x < 11; x++)
        {
            FrameScore newFrame = new FrameScore(x);
            assertTrue((newFrame.pins1+newFrame.pins2) <= 10);

            if (newFrame.pins1 == 10) { assertTrue(newFrame.isStrike); }
            if ((newFrame.pins1+newFrame.pins2) == 10 && newFrame.isStrike == false) { assertTrue(newFrame.isSpare); }
        }
    }


}