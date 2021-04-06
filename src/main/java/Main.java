import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");
        System.out.println("Enter Player 1 choice (rock , paper or scissors):");
        int player1 = Game.validation(scanner.next());
        System.out.println("Enter Player 2 choice (rock , paper or scissors):");
        int player2 = Game.validation(scanner.next());
        System.out.println(Game.play(player1 , player2));
    }
}
