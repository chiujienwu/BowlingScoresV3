public class Game {

    FrameScore[] gameRolls;

    public Game() {
        gameRolls = new FrameScore[10];  //reserve 10 FrameScore objects

        for (int frameIndex = 0; frameIndex < 10; frameIndex++) {

            gameRolls[frameIndex] = new FrameScore(frameIndex+1);  //+1 to array index to get Frame Reference for easier understanding

        }
    }

    public int getScore ()
    {
        int gameScore = 0;

        for (int x = 0; x < 10; x++)
        {
            //score a frame without strike or spare
            if (gameRolls[x].pins1 != 10 && (gameRolls[x].pins1+gameRolls[x].pins2) < 10)
            {
                gameScore = gameScore + (gameRolls[x].pins1+gameRolls[x].pins2);
            }
            //sore a frame with spare
            else if (gameRolls[x].pins1 != 10 && (gameRolls[x].pins1+gameRolls[x].pins2) == 10)
            {
                //determine spare bonus for frames other than frame 10
                int spareBonus = 0;
                if (gameRolls[x].frame <= 9)
                {
                    spareBonus = gameRolls[x+1].pins1;
                }
                //determine spare bonus for frame 10
                else if (gameRolls[x].frame == 10)
                {
                    spareBonus = gameRolls[x].frame10Bonus;
                }
                //score frame with spare bonus once determined
                gameScore = gameScore + (gameRolls[x].pins1+gameRolls[x].pins2+spareBonus);
            }
            //score strike
            else if (gameRolls[x].pins1 == 10)
            {
                int strikeBonus = 0;
                if (gameRolls[x].frame < 9)
                {
                    if (gameRolls[x+1].pins1 == 10)
                    {
                        strikeBonus = gameRolls[x+1].pins1 + gameRolls[x+2].pins1;
                    }
                    else
                    {
                        strikeBonus = gameRolls[x+1].pins1 + gameRolls[x+1].pins2;
                    }
                }
                else if (gameRolls[x].frame == 9)
                {
                    strikeBonus = gameRolls[x+1].pins1 + gameRolls[x+1].pins2;
                }
                else if (gameRolls[x].frame == 10)
                {
                    strikeBonus = gameRolls[x].pins2 + gameRolls[x].frame10Bonus;
                }

                gameScore = gameScore + gameRolls[x].pins1 + strikeBonus;
            }
        }
        return gameScore;
    }

}

