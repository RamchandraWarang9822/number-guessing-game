import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Font;

public class Main {

    public static void main(String[] args) {

        UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
        Font font = new Font(null, Font.BOLD, 24);

        UIManager.put("OptionPane.messageFont", font);
        
        Random random = new Random();
        int range = 100;
        int limit = 10;
        int score = 0;
        int rounds = 1;

        System.out.println("Welcome to Number Guessing game");
        while(true){
            int numberToGuess = random.nextInt(range) + 1;
            int attempts = 0;
            String guessString;
            int guess;

            System.out.println("Round " + rounds + " : Guess a number between 1 and " + range);

            while (attempts < limit) {
                guessString = JOptionPane.showInputDialog(null, "Attempt #" + (attempts + 1) + ":");
                if (guessString == null) {
                    JOptionPane.getRootFrame().dispose();
                    break;
                }
                try {
                    guess = Integer.parseInt(guessString);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                    continue;
                }
                attempts++;

                if(guess == numberToGuess){
                    JOptionPane.showMessageDialog(null, "Congratulations, you guessed the number in " + attempts + " attempts!");
                    System.out.println("Congratulations, you guessed the number in " + attempts + " attempts!");
                    score += (limit - attempts + 1) * 10;
                    break;
                } else if (guess < numberToGuess){
                    JOptionPane.showMessageDialog(null, "Too low, try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high, try again.");
                }
            }
            JOptionPane.showMessageDialog(null, "Your score for round " + rounds + " is " + score + ".");
            int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Play again?", JOptionPane.YES_NO_OPTION);
            if (playAgain != JOptionPane.YES_OPTION) {
                break;
            }
            rounds++;
        }
        JOptionPane.showMessageDialog(null, "Your final score : " + score + "\nThanks for playing!");
    }
}
