import java.util.Scanner;

public class Player {
    private final String name;
    private int score;

    public Player() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name:");
        name = sc.nextLine();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrScore() {
        score = score + 1;
    }
}