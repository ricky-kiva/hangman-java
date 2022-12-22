import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int intHang = 0;

        String missWord = "Misses: ";
        int randWord = (int)(Math.random()*words.length);
        String askWord = words[randWord];

        char[] arrFill = new char[askWord.length()];
        for (int i = 0; i < arrFill.length; i++) {
            arrFill[i] = '_';
        }

        char[] arrAsk = Arrays.copyOf(arrFill, arrFill.length);
        for (int i = 0; i < arrAsk.length; i++) {
            arrAsk[i] = askWord.charAt(i);
        }

        while (intHang < 7) {

            System.out.println("\n" + gallows[intHang]);

            if (intHang == 6) {
                System.out.println("\nU DED!\n");
            }

            String fillWord = "Word: ";
            for (int i = 0; i < arrFill.length; i++) {
                fillWord = fillWord + " " + arrFill[i];
                if (i == (arrFill.length)-1) {
                    System.out.println(fillWord);
                    System.out.println(missWord);
                    if (fillWord.indexOf('_') > -1) {
                        break;
                    }
                    System.out.println("\nGOOD WORK!\n");
                    System.exit(0);
                }
            }

            char charGuess = '_';
            while(charGuess == '_') {
                System.out.print("Guess: ");
                charGuess = scan.next().charAt(0);
            }

            if (askWord.indexOf(charGuess) > -1) {
                for (int i = 0; i < askWord.length(); i++) {
                    if (askWord.charAt(i) == charGuess) {
                        arrFill[i] = charGuess;
                    }
                }
            } else {
                intHang += 1;
                missWord = missWord + charGuess;
            }

        }

        scan.close();
    }

}





