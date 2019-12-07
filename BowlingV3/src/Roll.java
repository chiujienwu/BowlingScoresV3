public class Roll {

    int pins;

    public int getPins() {

        pins = (int) Math.floor(Math.random()*10)+ 1;
        return pins;
    }

    public int getPins(int firstRoll)
    {
        pins = (int) Math.floor(Math.random()*(10-firstRoll))+ 1;
        return pins;
    }
}
