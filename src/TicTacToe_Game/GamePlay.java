package TicTacToe_Game;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class GamePlay {
    Deque<Player> players;
    GameBoard gameBoard;


    public void initaliseGame(){
        players = new LinkedList<>();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter player1 name: ");
        Player p1=new Player(sc.nextLine(), new PlayingPiece(PlayingPieceType.O));
        System.out.println("Enter player2 name: ");
        Player p2=new Player(sc.nextLine(),new PlayingPiece(PlayingPieceType.X));

        players.add(p1);
        players.add(p2);

        gameBoard=new GameBoard(3);

    }

    public GameStatus startGame(){

        boolean noWinner=true;
        while(noWinner){
            Player currentPlayer=players.removeFirst();

            gameBoard.printBoard();

            if(!gameBoard.hasSpace()){
                System.out.println("Game is over. It's a TIE");
                break;
            }

            System.out.println(currentPlayer.playerName+" : Enter row & col where you want to play");
            Scanner sc=new Scanner(System.in);
            String input=sc.nextLine();
            String[] values= input.split(",");
            int row=Integer.parseInt(values[0]);
            int col=Integer.parseInt(values[1]);


            boolean validMove=gameBoard.addPiece(currentPlayer.playingPiece,row,col);
            if(!validMove){
                System.out.println("Invalid move "+currentPlayer.playerName+" try again...");
                players.addFirst(currentPlayer);
                continue;
            }
            if(checkWinner(row,col,currentPlayer.playingPiece)){
                gameBoard.printBoard();
                System.out.println("Congratulations "+currentPlayer.playerName+" won!");
                noWinner=false;
                return GameStatus.Win;
            }
            players.addLast(currentPlayer);

        }
        return GameStatus.Tie;
    }

    public boolean checkWinner(int row,int col,PlayingPiece playingPiece){
        boolean rowWin=true;
        boolean colWin=true;
        boolean DiagonalWin=true;
        boolean antiDiagonalWin=true;


        // row check
        for(int i=0;i<gameBoard.size; i++){
            if(gameBoard.board[row][i]==null || gameBoard.board[row][i]!=playingPiece){
                rowWin=false;
                break;
            }
        }

        // col check
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[i][col]==null || gameBoard.board[i][col]!=playingPiece){
                colWin=false;
                break;
            }
        }

        // Diagonal check
        for (int i=0, j=0; i<gameBoard.size; i++, j++){
            if(gameBoard.board[i][j]==null ||gameBoard.board[i][j]!=playingPiece){
                DiagonalWin=false;
                break;
            }
        }

        // AntiDiagonal check

        for(int i=0, j= gameBoard.size-1; i<gameBoard.size; i++, j--){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j]!=playingPiece){
                antiDiagonalWin=false;
                break;
            }
        }

        return rowWin|| colWin||DiagonalWin||antiDiagonalWin;


    }

}
