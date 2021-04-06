import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GameTest {
    public static Stream<Arguments> allWinCases() {
        return Stream.of(
                arguments(0, 2, "Player 1 win!"),
                arguments(1, 0, "Player 1 win!"),
                arguments(2, 1, "Player 1 win!")
        );
    }

    public static Stream<Arguments> allLoseCases() {
        return Stream.of(
                arguments(2, 0, "Player 2 win!"),
                arguments(0, 1, "Player 2 win!"),
                arguments(1, 2, "Player 2 win!")
        );
    }

    public static Stream<Arguments> allDrawCases() {
        return Stream.of(
                arguments(0, 0, "Draw!"),
                arguments(1, 1, "Draw!"),
                arguments(2, 2, "Draw!")
        );
    }

    public static Stream<Arguments> validInputCases() {
        return Stream.of(
                arguments("rock", 0),
                arguments("paper", 1),
                arguments("scissors", 2)
        );
    }

    public static Stream<Arguments> invalidInputCases() {
        return Stream.of(
                arguments("123"),
                arguments("invalid"),
                arguments("Rock")
        );
    }

    @ParameterizedTest
    @MethodSource("allWinCases")
    public void allWinCasesTest(int player1 , int player2, String expectedOutput) {
        assertEquals(expectedOutput, Game.play(player1,player2));
    }

    @ParameterizedTest
    @MethodSource("allLoseCases")
    public void allLoseCasesTest(int player1 , int player2, String expectedOutput) {
        assertEquals(expectedOutput, Game.play(player1,player2));
    }

    @ParameterizedTest
    @MethodSource("allDrawCases")
    public void allDrawCasesTest(int player1 , int player2, String expectedOutput) {
        assertEquals(expectedOutput, Game.play(player1,player2));
    }

    @ParameterizedTest
    @MethodSource("validInputCases")
    public void validInputCasesTest(String player , int expectedOutput) {
        assertEquals(expectedOutput, Game.validation(player));
    }

    @ParameterizedTest
    @MethodSource("invalidInputCases")
    public void invalidInputCasesTest(String input) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()->Game.validation(input));
        assertEquals("Bad Choice!", thrown.getMessage());
    }
}
