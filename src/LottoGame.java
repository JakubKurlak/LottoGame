import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    public static <T> void main(String[] args) {
        int numberOfNumbers = 6;
        int range = 49;

        System.out.println("Welcome in Lotto Simulator! " +
                "\nType Your " + numberOfNumbers + " lucky numbers from 1 to " + range + " and click Enter ;)");

        List<Integer> myNumbers = new ArrayList<>();
        List<Integer> randomNumbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numberOfNumbers; )
            try {
                int myNumber = Integer.parseInt(scanner.next());
                if (myNumber < 1 || myNumber > range) {
                    System.out.println("Your number is out of range from 1 to 49");
                } else if (myNumbers.contains(myNumber)) {
                    System.out.println("You use this number. ");
                } else {
                    myNumbers.add(myNumber);
                    i++;
                    if (i < 6) {
                        System.out.println("Type your another lucky number.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You should write the number.");
            }
        Collections.sort(myNumbers);

        System.out.println("You type your " + numberOfNumbers + " lucky numbers. " +
                "\nThey are: " + myNumbers +
                "\n\nNow lottery machine lottery " + numberOfNumbers + " numbers.");

        for (int i = 0; i < numberOfNumbers; ) {
            Random random = new Random();
            int randomNumber = random.nextInt(range) + 1;
            if (randomNumbers.contains(randomNumber))
                ;
            else {
                randomNumbers.add(randomNumber);
                i++;
            }
        }
        Collections.sort(randomNumbers);
        System.out.println("They are: " + randomNumbers + "\n");

        List<T> guessedNumbers = (List<T>) randomNumbers.stream().filter(myNumbers::contains).collect(Collectors.toList());

        int choosenNumber = guessedNumbers.size();

        if (choosenNumber == 6)
            System.out.println("Ladies and Gentlemen! You guessed " + choosenNumber + " numbers " + guessedNumbers +
                    ". \nYou won first prize in our lottery 1 000 000 zł! \nCongratulations!");
        else if (choosenNumber == 5)
            System.out.println("You guessed " + choosenNumber + " numbers " + guessedNumbers + ". You won 1000 zł.");
        else if (choosenNumber == 4)
            System.out.println("You guessed " + choosenNumber + " numbers " + guessedNumbers + ". You won 100 zł.");
        else if (choosenNumber == 3)
            System.out.println("You guessed " + choosenNumber + " numbers " + guessedNumbers + ". You won 10 zł.");
        else if (choosenNumber == 2)
            System.out.println("You guessed " + choosenNumber + " numbers " + guessedNumbers + ". Try again.");
        else if (choosenNumber == 1)
            System.out.println("You guessed " + choosenNumber + " number " + guessedNumbers + ". Try again.");
        else
            System.out.println("You guessed " + choosenNumber + " numbers. Try again.");
    }
}
