public class Game {
    static String play(int player1 , int player2){
        if ((player1 == 0 && player2 == 2) || (player1 == 1 && player2 == 0) || (player1 == 2 && player2 == 1)) {
            return "Player 1 win!";
        }
        else if (player1 == player2) {
            return "Draw!";
        }
        else return "Player 2 win!";
    }

    static int validation(String input) throws IllegalArgumentException{
        switch(input){
            case "rock":
                return 0;
            case "paper":
                return 1;
            case "scissors":
                return 2;
            default:
                throw new IllegalArgumentException("Bad Choice!");
        }
    }
}
