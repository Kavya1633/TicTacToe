package TicTacToe_Game;

public class GameBoard {

    int size;
    PlayingPiece[][] board;

    public GameBoard(int size){
        this.size = size;
        board=new PlayingPiece[size][size];
    }

    boolean addPiece(PlayingPiece playingPiece, int row,int col){

        if( row<0 || col<0 || row>=size || col>=size || board[row][col]!=null){
            return false;
        }
        board[row][col]=playingPiece;
        return true;
    }

    boolean hasSpace(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){ return true;}
            }
        }

        return false;
    }

    void  printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null)
                    System.out.print(board[i][j].playingPieceType.toString()+" | ");
                else System.out.print("_"+" | ");
            }

            System.out.println(" ");
        }
    }

}
