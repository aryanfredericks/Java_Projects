package Java_Projects.TicTacToe;
import java.util.*;

class TicTacToe{
    int flag[][]= new int[3][3]; //using flag array to check if the position is taken or not
    String[][] board = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
    };
    //creating an ideal situation used for checking if match is draw or not.
    //ideal board used in isDraw(); function
    //cannot use above board as those values get updated
    String[][] startingBoard = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
    };
    //function to print the board
    public void showBoard(){
        System.out.println("-----------------------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }
    //creating a constructor that sets the flag array to initial positions =0(not occupied)
    public TicTacToe(){
        showBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                flag[i][j]=0;
            }
        }
    }
    //function to update the value of x
    public int updateX(String a){
        //using flag2 to check if the value exists...and got updated
        int flag2=0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if(board[i][j].equals(a)&& flag[i][j]==0){
                    board[i][j]="X";
                    flag[i][j]=1;
                    flag2=1;
                    showBoard();
                    break;
                }
            }
        }
        return flag2;
    }
    //function to update value of O
    public int updateO(String a){
        //using flag3 to check if the value exists...and got updated
        int flag3=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j].equals(a)&& flag[i][j]==0){
                    board[i][j]="O";
                    flag[i][j]=1;
                    flag3=1;
                    showBoard();
                }
            }
        }
        return flag3;
    }
    //function to check for victory
    public boolean checkVictory(){
        //using flag to check if the winning pattern is correct
        boolean flag =false;
        if(board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])){
            System.out.println(board[0][0]+"wins");
            flag=true;
        }
        else if(board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])){
            System.out.println(board[1][0]+" wins");
            flag=true;
        }
        else if(board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])){
            System.out.println(board[2][0]+" wins");
            flag=true;
        }
        else if(board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])){
            System.out.println(board[0][0]+" wins");
            flag=true;
        }
        else if(board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])){
            System.out.println(board[1][1]+" wins");
            flag=true;
        }
        else if(board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])){
            System.out.println(board[1][2]+" wins");
            flag=true;
        }
        else if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
            System.out.println(board[1][1]+" wins");
            flag=true;
        }
        else if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])){
            System.out.println(board[1][1]+" wins");
            flag=true;
        }
        return flag;
    }
    //function to check if the match is a draw
    public boolean isDraw(){
        int count = 0;
        boolean isD=false;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if(!board[i][j].equals(startingBoard[i][j])){
                    count+=1;
                    if (count ==9){
                        isD=true;
                    }
                }
            }
        }

        return isD;
    }
}
public class game{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean gameAccessed= true;
        TicTacToe t = new TicTacToe();
        System.out.println("-----------------------------");
        System.out.println("Please choose where you would like to place ");
        while(gameAccessed){
            boolean xValueUpdated=false;
            boolean goNext=false;

            while(!xValueUpdated){
                System.out.println("---------X Choice--------");
                String xPlayer = sc.next();
                if(t.updateX(xPlayer)==1){
                    xValueUpdated=true;
                    goNext=true;
                }
                else{
                    System.out.println("Enter a valid choice");
                }
                if (t.checkVictory()) {
                    gameAccessed = false;
                    break;
                }
                else if(t.isDraw()) {
                    System.out.println("DRAW!!");
                    gameAccessed = false;
                    break;
                }
            }
            if(!gameAccessed){
                break;
            }
            while(goNext){
                System.out.println("---------O Choice--------");
                String oPlayer = sc.next();
                if (t.updateO(oPlayer) == 1) {
                    goNext = false;
                }
                else{
                    System.out.println("Enter a valid choice");
                }
                if (t.checkVictory()) {
                    gameAccessed = false;
                    break;
                }
                else if (t.isDraw()) {
                    System.out.println("DRAW!!");
                    gameAccessed = false;
                    break;
                }
            }
        }
    }
}
