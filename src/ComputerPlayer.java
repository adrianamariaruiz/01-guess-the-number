import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends Player {
    static List<Integer> allGuesses = new ArrayList<>();
    public ComputerPlayer(String name){
        super(name);
    }

    @Override
    public  int makeGuess() {
        int guess;
        do {
            guess = (int)(Math.random() * 10 + 1);
        } while (allGuesses.contains(guess));
        return guess;
    }
}
