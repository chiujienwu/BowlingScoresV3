public class FrameScore {

    int frame;
    int pins1;
    int pins2;

    boolean isStrike = false;
    boolean isSpare = false;
    int frame10Bonus;

    public FrameScore(int frame) {
        this.frame = frame;

        //frame 10 is a special case

        if (frame <= 10) {

            System.out.println("Frame: " + frame);

            //initiate first roll of frame
            Roll firstRoll = new Roll();
            this.pins1 = firstRoll.getPins();
            System.out.println("First roll of : " + this.pins1);

            if (this.pins1 == 10) {
                System.out.println("Strike!");
                this.isStrike = true;
            //System.out.println(this.pins2);
            } else {
                //initiate second roll of frame since first roll failed to obtain strike
                Roll secondRoll = new Roll();
                this.pins2 = secondRoll.getPins(this.pins1);
                System.out.println("Second roll of : " + this.pins2);

                if ((this.pins1 + this.pins2) == 10)  //no need to check for isStrike == false given this portion is in the ELSE portion
                {
                    System.out.println("Spare!");
                    this.isSpare = true;
                }
            }
        } // start of frame 10 exception

        if (frame == 10 && isStrike) {
            Roll secondRoll = new Roll();
            this.pins2 = secondRoll.getPins(this.pins1);
            System.out.println("Second roll of : " + this.pins2);
            Roll thirdRoll = new Roll();
            this.frame10Bonus = thirdRoll.getPins();
            System.out.println("Final roll of : " + this.frame10Bonus);
        } else if (frame == 10 && isSpare) {
            Roll thirdRoll = new Roll();
            this.frame10Bonus = thirdRoll.getPins();
            System.out.println("Final roll of : " + this.frame10Bonus);
        }
    }
}
