import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Player {
    private String name;
    private List<Integer> guesses;

    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>();
    }

    public abstract int makeGuess();

   public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Integer> getGuesses() {
        return guesses;
    }

    public void addGuess(int guess) {
        guesses.add(guess);
    }

}
