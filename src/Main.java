import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        File dictionary = new File("C:\\Users\\Admin\\IdeaProjects\\Hangman\\src\\dictionary.txt");

        Scanner textScanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        //"words" stores the list of all words in the dictionary
        ArrayList<String> words = new ArrayList<>();
        while (textScanner.hasNext()) {
            words.add(textScanner.nextLine());
        }

        //hidden_text is the text generated randomly
        String hidden_text = words.get((int) (Math.random() * words.size()));
        //textArray stores array of characters in hidden_text
        char[] textArray = hidden_text.toCharArray();

        //myAnswers stores the characters that are guessed by player
        char[] myAnswers = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswers[i] = '?';
        }

        boolean finished = false;
        int lives = 6;
        while (finished == false) {
            System.out.println("*******************************");
            //takes a character from player
            String letter = input.next();
            // checks for valid input
            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Error Input -Try again");
                letter = input.next();
            }

            //checks if the letter is in the word
            boolean found = false;
            for (int i = 0; i < textArray.length; i++) {
                if (letter.charAt(0) == textArray[i]) {
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }
            if (!found) {
                lives--;
                System.out.println("Wrong letter");
            }
            boolean done = true;
            for (int i = 0; i < myAnswers.length; i++) {
                if (myAnswers[i] == '?') {
                    System.out.print(" _");
                    done = false;
                } else {
                    System.out.print(" " + myAnswers[i]);
                }
            }
            System.out.println("\n" + "Lives Left:" + lives);
                drawHangman(lives);
            // check if the game ends
            if (done) {
                System.out.println("Congrats You Found the Word");
                finished = true;
            }
            if (lives <= 0) {
                System.out.println("You are dead!");
                finished = true;
            }
        }
    }
        public static void drawHangman(int l)
        {
            if (l == 6) {
                System.out.println("|----------");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            } else if (l == 5) {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            } else if (l == 4) {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|    |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            } else if (l == 3) {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            } else if (l == 2) {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|-");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            } else if (l == 1) {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|-");
                System.out.println("|   /");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            } else {
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|-");
                System.out.println("|   /|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
        }
    }

