import java.util.*;

public class Encryption {

      private Scanner input;
      private Random random;
      private ArrayList<Character> list, shuffledList;
      private char character;
      private String line;
      private char[] letters;

      Encryption() {
            input = new Scanner(System.in);
            random = new Random();
            list = new ArrayList<>();
            shuffledList = new ArrayList<>();
            character = ' ';

            newKey();
            askQuestion();
      }

      // Declare the necessary methods:

      private void askQuestion() {

            while (true) {
                  System.out.println("\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                  System.out.println("Choose an option: ");
                  System.out.println("N -> new key, G -> get key, E -> Encrypt text, D -> Decrypt text, Q -> Quit");

                  char response = Character.toUpperCase(input.nextLine().charAt(0));
                  // We take the first letter the user enters, convert it to uppercase, and store it in the "response" variable.

                  switch (response) {
                        case 'N' -> newKey();
                        case 'G' -> getKey();
                        case 'E' -> encryptText();
                        case 'D' -> decryptText();
                        case 'Q' -> exit();
                        default -> System.out.println("Choose from the above options!");
                  }
            }

      }

      private void newKey() {
            // Clear the previous lists to make room for new ones:
            character = ' ';
            list.clear();
            shuffledList.clear();

            // Add the "character" variable filled with numbers to the character list:
            for (int i = 32; i < 127; i++) {
                  list.add(Character.valueOf(character));
                  character++;
            }

            shuffledList = new ArrayList<>(list);  // copy the character list to shuffle later

            // Shuffle the characters in the list:
            Collections.shuffle(shuffledList);

            System.out.println("A new key has been generated!");

      }

      private void getKey() {

            System.out.println("The key in the list is: ");

            for (Character x : list) {
                  System.out.print(x);
            }

            System.out.println("\n" + "The key in the shuffled list is: ");

            for (Character y : shuffledList) {
                  System.out.print(y);
            }

      }

      private void encryptText() {
            System.out.println("Enter text to encrypt: ");

            String message = input.nextLine();

            // Convert the text to an array:

            letters = message.toCharArray();

            for (int i = 0; i < letters.length; i++) {
                  for (int j = 0; j < list.size(); j++) {
                        if (letters[i] == list.get(j)) {
                              letters[i] = shuffledList.get(j);
                              break;
                        }

                  }
            }
            System.out.println("Encoded message: ");

            for (char x : letters) {
                  System.out.print(x);
            }

      }

      private void decryptText() {

            System.out.println("Enter text to decrypt: ");

            String message = input.nextLine();

            // Convert the text to an array:

            letters = message.toCharArray();

            for (int i = 0; i < letters.length; i++) {
                  for (int j = 0; j < shuffledList.size(); j++) {
                        if (letters[i] == shuffledList.get(j)) {
                              letters[i] = list.get(j);
                              break;
                        }

                  }
            }
            System.out.println("Decoded message: ");

            for (char x : letters) {
                  System.out.print(x);
            }

      }

      private void exit() {

            System.out.println("Goodbye ;(");
            System.exit(0); // --> End the program

      }
}
