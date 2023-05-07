import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    List<String> words = List.of("car", "machine", "playground", "garden");
    String word;
    char[] userWord;

    public void play() {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '*');


        while(!gameEnded()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println("Enter another letter: ");

            char letter = scanner.nextLine().charAt(0);
            // TODO check if input correct

            checkLetter(letter);
        }

        scanner.close();
    }

    private void checkLetter(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                userWord[i] = letter;
            }
        }
    }

    private boolean gameEnded() {
        return word.equals(String.valueOf(userWord));
    }
}
