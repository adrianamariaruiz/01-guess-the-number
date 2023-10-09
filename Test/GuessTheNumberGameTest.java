import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GuessTheNumberGameTest {

    @Test
    public void testCheckGuess(){
        GuessTheNumberGame.setTargetNumber(5);
        boolean res = GuessTheNumberGame.checkGuess(5);
        assertTrue(res);
    }

    @Test
    public void testAskPlayerName() {
        String simulatedInput = "adriana ";
        InputStream savedSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Scanner scanner = new Scanner(System.in);
        String res = GuessTheNumberGame.askPlayerName(scanner);
        assertEquals("adriana ", res);

        System.setIn(savedSystemIn);
    }

    @Test
    public void testComputerPlayerMakeGuess() {
        Player computerPlayer = new ComputerPlayer("Computer");
//        Player computerPlayer = mock(HumanPlayer.class);
        int guess = computerPlayer.makeGuess();
        assertTrue(guess >= 1 && guess <= 100);
    }
}