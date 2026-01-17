import TicTacToe_Game.GamePlay;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Tic-Tac-Toe Game");
        GamePlay play=new GamePlay();
        play.initaliseGame();
        System.out.println("Game Status : "+play.startGame().toString());

    }
}