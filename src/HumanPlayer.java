import java.util.Scanner;
public class HumanPlayer extends Player {
    public HumanPlayer(String name){
        super(name);
    }
    @Override
    public int makeGuess() {
        Scanner scanner = new Scanner(System.in);
        int guess;
        do {
            System.out.print(getName() + ", ingresa un numero: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingresa un número válido entre el 1 y el 100: ");
                scanner.next();
            }
            guess = scanner.nextInt();
        } while (guess < 1 || guess > 100);
        return guess;
    }
}
