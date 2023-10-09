import java.util.Scanner;

public class GuessTheNumberGame {
    static int targetNumber = (int) (Math.random() * 10 + 1);
    public static void setTargetNumber(int targetNumber) {
        GuessTheNumberGame.targetNumber = targetNumber;
    }
    public static int getTargetNumber() {
        return targetNumber;
    }
    public static String askPlayerName(Scanner scanner){
        String playerName;
        do {
            System.out.print("Hola, para iniciar el juego ingresa tu nombre: ");
            playerName = scanner.nextLine();
        }while (!validName(playerName));
        return playerName;
    }
    public static boolean validName(String playerName) {
        return !playerName.isEmpty() && !playerName.matches(".*\\d.*");
    }

    public static void main(String[] args) {

        System.out.println(targetNumber);

        Scanner scanner = new Scanner(System.in);
        String playerName = askPlayerName(scanner);

        Player humanPlayer = new HumanPlayer(playerName);
        Player computerPlayer = new ComputerPlayer("Computadora");

        Player currentPlayer = humanPlayer;

        System.out.println("✨" + humanPlayer.getName() + "✨ Bienvenid@ al juego de adivinanza. 🤗");
        System.out.println("El número a adivinar está entre el 1 y el 100. ");

        do{
            System.out.println("⭐ --------------- ⭐ ------------ ⭐");
            int guess = currentPlayer.makeGuess();
            currentPlayer.addGuess(guess);

            ComputerPlayer.allGuesses.add(guess);

            if (currentPlayer == computerPlayer){
                System.out.println(currentPlayer.getName() + " supone que es el numero: " + guess);
            }

            if (checkGuess(guess)) {
                int totalLength = currentPlayer.getGuesses().size();
                if(currentPlayer.getName().equals("Computadora")){
                    System.out.println( "💻 " + currentPlayer.getName() + " ha adivinado el número 😔. Puedes volverlo a intentar!");
                }else {
                    System.out.println( currentPlayer.getName() + " has adivinado el número. ✨ ¡Felicidades! ✨");
                }
                System.out.println("Historial de suposiciones de " + currentPlayer.getName() + ": " + currentPlayer.getGuesses());
                System.out.println("Total de intentos de " + currentPlayer.getName() + ": " + totalLength);
                break;
            }
            currentPlayer = (currentPlayer == humanPlayer) ? computerPlayer : humanPlayer;
        } while(true);
    }
    public static boolean checkGuess(int guess) {
        if (guess == targetNumber) {
            return true;
        } else {
            if (guess < targetNumber) {
                System.out.println("El numero " + guess + " es demasiado bajo. ");
            } else {
                System.out.println("El numero " + guess + " es demasiado alto.");
            }
            return false;
        }
    }
}