import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("How many players?");
        int numberPlayers = keyboard.nextInt();

        Game[] players = new Game[numberPlayers];

        for (int x = 0; x < numberPlayers; x++)
        {
            players[x] = new Game();
            int score = players[x].getScore();
            System.out.println("Player " + (x+1) + " has a score of :" + score);
        }
    }
}
