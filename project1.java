import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static  Random random = new Random();
    public static String[][] board=  {{"1","2","3"},
                                      {"4","5","6"},
                                      {"7","8","9"}};
    public static String userSymbol = "";
    public static String cpuSymbol = "";


    public static void main(String[] args) {

        printBoard();
        chooseSymbols();

        System.out.println("Choose mode:" +
                "\n1. For Single Round " +
                "\n2. For Best of 3 Round ");
        int mode = input.nextInt();

        if (mode==1){
            playRound();
        }else if (mode==2){
            threeRound();
        }else  System.out.println("Invalid mode selected");

    }

    public static void printBoard() {
        System.out.println("----------");
        System.out.println(board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
        System.out.println("- + - + -");
        System.out.println(board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
        System.out.println("- + - + -");
        System.out.println(board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
        System.out.println("----------");
    }

    public static void chooseSymbols( ){
        System.out.println("Choose your symbol (X or O):");
        userSymbol = input.nextLine();
        while (!userSymbol.equalsIgnoreCase("X") && !userSymbol.equalsIgnoreCase("O")) {
            System.out.println("Invalid choice. Please choose X or O: ");
            userSymbol = input.nextLine();
        }
        cpuSymbol = (userSymbol.equalsIgnoreCase("X")) ? "O" : "X";

    }

    public static void playRound(){
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]=" ";
            }
        }
        while (isBoardEmpty()) {

            int userPosition;
            while (true) {
                System.out.println("Choose your position (1 to 9): ");
                userPosition = input.nextInt();
                if (checkPosition(userPosition)) {
                    break;
                } else System.out.println("This position is already taken. Try again.");
            }

            playing(userPosition, userSymbol);
            if (whoWinner(userSymbol)) {
                printBoard();
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("      Congratulations! You win!      ");
                break;
            }

            int cpuPosition=0;
            while (isBoardEmpty()) {
                cpuPosition = random.nextInt(9) + 1;
                if (cpuPosition != userPosition && checkPosition(cpuPosition)) {
                    break;
                } else ;
            }
            System.out.println("Computer chose position " + cpuPosition);
            playing(cpuPosition, cpuSymbol);
            printBoard();

            if (whoWinner(cpuSymbol)) {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Computer wins! Better luck next time.");
                break;
            }
        }
    }

    public static void threeRound (){
        int userWin=0;
        int cpuWin=0;
        for (int round=1 ; round<=3 ; round++){
            System.out.println("*-*-*-*-*-*-*Round ("+round+") *-*-*-*-*-*-*");
            playRound();
            if (whoWinner(cpuSymbol)) {
                cpuWin++;
            }else if(whoWinner(userSymbol)){
                userWin++;
            }
        }
        if (userWin>cpuWin){
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Congratulations!, You Are The Winner.");
            System.out.println("              ( "+userWin+" : "+cpuWin+" )              ");
        }else if(userWin<cpuWin){
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Sorry Computer is The Winner :( ");
            System.out.println("              ( "+cpuWin+" : "+userWin+" )              ");
        }else { System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("     The game ended in a tie!");}


    }

    public static boolean checkPosition(int position){
        switch (position){
            case 1: return (board[0][0]==" ");
            case 2: return (board[0][1]==" ");
            case 3: return (board[0][2]==" ");
            case 4: return (board[1][0]==" ");
            case 5: return (board[1][1]==" ");
            case 6: return (board[1][2]==" ");
            case 7: return (board[2][0]==" ");
            case 8: return (board[2][1]==" ");
            case 9: return (board[2][2]==" ");
            default:
                return false;
        }
    }

    public static boolean isBoardEmpty() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == " ") {
                    return true;
                }
            }
        }

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("     The game ended in a tie!        ");
        return false;
    }

    public static void playing(int position , String xo){
        switch (position){
            case 1:
                board[0][0]=xo;
                break;
            case 2:
                board[0][1]=xo;
                break;
            case 3:
                board[0][2]=xo;
                break;
            case 4:
                board[1][0]=xo;
                break;
            case 5:
                board[1][1]=xo;
                break;
            case 6:
                board[1][2]=xo;
                break;
            case 7:
                board[2][0]=xo;
                break;
            case 8:
                board[2][1]=xo;
                break;
            case 9:
                board[2][2]=xo;
                break;
        }
    }

    public static boolean whoWinner(String xo ){
        //Rows
        if((board[0][0]==xo && board[0][1]==xo && board[0][2]==xo)||
           (board[1][0]==xo && board[1][1]==xo && board[1][2]==xo)||
           (board[2][0]==xo && board[2][1]==xo && board[2][2]==xo)||
        //Columns
           (board[0][0]==xo && board[1][0]==xo && board[2][0]==xo)||
           (board[0][1]==xo && board[1][1]==xo && board[2][1]==xo)||
           (board[0][2]==xo && board[1][2]==xo && board[2][2]==xo)||
        //X
           (board[0][0]==xo && board[1][1]==xo && board[2][2]==xo)||
           (board[0][2]==xo && board[1][1]==xo && board[2][0]==xo))
            return true;

        return false;
    }





}