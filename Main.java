import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int answer, guess;

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        answer = rand.nextInt(10) + 1;

        System.out.println("Guess a number between 1 & 10: ");
        guess = sc.nextInt();

        System.out.println(
                (guess == answer) ? "Good job the number was : " + answer
                        : "Sorry, but the right number was :" + answer);

    }
}
