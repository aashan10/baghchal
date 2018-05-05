import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BaghChal {

    private static final int TIGER = 1;
    private static final int GOAT = 2;
    private static final int EMPTY = 0;
    //private int TOTAL_REMAINING_TIGERS = 4;
    private int TOTAL_REMAINING_GOATS = 20;
    private int KILLED_GOATS = 0;
    private static int[][] board = new int[5][5];
    private int turn = GOAT;
    private void initBoard(){
        for(int i = 0; i < 5; i++ ){
            for(int j = 0; j < 5; j++){
                board[i][j] = EMPTY;
            }
        }
        board[0][0] = TIGER;
        board[0][4] = TIGER;
        board[4][0] = TIGER;
        board[4][4] = TIGER;
    }
    private void switchTurn(){
        if(this.turn == GOAT){
            this.turn = TIGER;
        }else{
            this.turn = GOAT;
        }
    }
    private void playerInfo(){
        System.out.println("Goats killed : "+ KILLED_GOATS);
        if(this.turn == TIGER){
            System.out.println("\nTigers turn:\n");
        }else{
            System.out.println("\nGoats turn:\n");
            System.out.println("\nREMAINING GOATS: "+ TOTAL_REMAINING_GOATS);
        }
    }
    private void move(){
        Scanner sc = new Scanner(System.in);
        int select;
        if(this.turn == TIGER){
            System.out.println("Select your TIGER to make a move! Please enter the row and column of the tiger.");
                int row = sc.nextInt();
                
                int col = sc.nextInt();
                
                if(row > 5 | row <1 | col > 5 | col < 1){
                    System.out.println("Invalid data!!");
                    move();
                }
                row--;
                col--;
                boolean[] available_moves = availableMove(row, col);
                if(available_moves[0]){
                    System.out.println("1. Move Upwards");
                }
                if(available_moves[1]){
                    System.out.println("2. Move Downwards");
                }
                if(available_moves[2]){
                    System.out.println("3. Move Left");
                }
                if(available_moves[3]){
                    System.out.println("4. Move Right");
                }
                if(available_moves[4]){
                    System.out.println("5. Move Top Left");
                }
                if(available_moves[5]){
                    System.out.println("6. Move Top Right");
                }
                if(available_moves[6]){
                    System.out.println("7. Move Bottom Left");
                }
                if(available_moves[7]){
                    System.out.println("8. Move Bottom Right");
                }
                select = sc.nextInt();
                switch(select){
                    case 1:
                            if((row -1) > -1 && board[row-1][col] == EMPTY){
                                board[row-1][col] = TIGER;
                            }else if(((row - 2) > - 1) && board[row -1][col] == GOAT && board[row-2][col] == EMPTY){
                                board[row-1][col] = EMPTY;
                                KILLED_GOATS++;
                                board[row-2][col] = TIGER;
                            }else{
                                System.out.println("Invalid Move!!");
                                move();
                            }
                        break;
                    case 2:
                        if((row +1) < 5  && board[row+1][col] == EMPTY){
                            board[row+1][col] = TIGER;
                        }else if(((row + 2) < 5) && board[row +1][col]== GOAT && board[row+2][col] == EMPTY){
                            board[row+1][col] = EMPTY;
                            KILLED_GOATS++;
                            board[row+2][col] = TIGER;
                        }else{
                            System.out.println("Invalid Move!!");
                            move();
                        }
                        break;
                    case 3:
                        if(((col -1) > -1 && board[row][col -1 ] == EMPTY)){
                            board[row][col -1 ] = TIGER;
                        }else if( 
                            ((col- 2) > - 1) && board[row][col -1] == GOAT && board[row][col -2] == EMPTY
                        ){
                            board[row][col -2] = TIGER;
                            board[row][col -1] = EMPTY;
                            KILLED_GOATS++;
                        }else{
                            System.out.println("Invalid Move!!");
                            move();
                        }
                        break;
                    case 4:
                        if((col + 1) < 5 && board[row][col + 1 ] == EMPTY){
                            board[row][col + 1 ] = TIGER;
                        }else if((col + 2)  < 5 && board[row][col +1] == GOAT && board[row][col +2] == EMPTY){
                            board[row][col +2] = TIGER;
                            board[row][col +1] = EMPTY;
                            KILLED_GOATS++;
                        }else{
                            System.out.println("Invalid Move!!");
                            move();
                        }
                        break;
                    case 5:
                        if(row -1 > -1 && col -1 > -1 && board[row-1][col-1] == EMPTY){
                            board[row-1][col-1] = TIGER;
                        }else if(
                            row - 2 > -1 &&
                            col - 2 > -1 &&
                            board[row-2][col-2] == EMPTY &&
                            board[row-1][col-1] == GOAT
                        ){
                            board[row-2][col-2] = TIGER;
                            board[row-1][col-1] = EMPTY;
                            KILLED_GOATS++;
                        }else{
                            System.out.println("Invalid Move!!");
                            move();
                        }
                        break;
                    case 6:
                        if( row -1 > -1 && col+1 < 5 && board[row-1][col+1] == EMPTY){
                            board[row-1][col+1] = TIGER;
                        }else if(
                            row - 2 > -1 &&
                            col + 2 < 5 &&
                            board[row-2][col+2] == EMPTY &&
                            board[row-1][col+1] == GOAT
                        ){
                            board[row-2][col+2] = TIGER;
                            board[row-1][col+1] = EMPTY;
                            KILLED_GOATS++;
                        }else{
                            System.out.println("Invalid Move!!");
                            move();
                        }
                        break;
                    case 7:
                        if( row +1 < 5 && col-1 > -1 && board[row+1][col-1] == EMPTY){
                            board[row+1][col-1] = TIGER;
                        }else if(
                            row + 2 < 5 &&
                            col - 2 > -1 &&
                            board[row+2][col-2] == EMPTY &&
                            board[row+1][col-1] == GOAT
                        ){
                            board[row+2][col-2] = TIGER;
                            board[row+1][col-1] = EMPTY;
                            KILLED_GOATS++;
                        }else{
                            System.out.println("Invalid Move!!");
                            move();
                        }
                        break;
                    case 8:
                        if( row +1 < 5 && col+1 < 5 && board[row+1][col+1] == EMPTY){
                            board[row+1][col+1] = TIGER;
                        }else if(
                            row + 2 < 5 &&
                            col + 2 < 5 &&
                            board[row+2][col+2] == EMPTY &&
                            board[row+1][col+1] == GOAT
                        ){
                            board[row+2][col+2] = TIGER;
                            board[row+1][col+1] = EMPTY;
                            KILLED_GOATS++;
                        }else{
                            System.out.println("Invalid Move!!");
                            move();
                        }
                        break;
                    default : 
                        System.out.println("Invalid Move!!");
                        move();
                        break;
                }
                board[row][col] = EMPTY;
        }else{
            if(TOTAL_REMAINING_GOATS < 21 && TOTAL_REMAINING_GOATS > 0){
                System.out.print("\nEnter the row and column to insert goat:\n");
                int row = sc.nextInt();
                
                int column = sc.nextInt();
                
                if(row > 5 | row <1 | column > 5 | column < 1){
                    System.out.println("Invalid data!!");
                    move();
                }
                row--;
                column--;
                if(board[row][column] == EMPTY){
                    board[row][column] = GOAT;
                    TOTAL_REMAINING_GOATS--;
                }else{
                    System.out.print("\nYour move is not valid!!\n");
                    this.move();
                }
            }else{
                System.out.println("Select your GOAT to make a move! Please enter the row and column of the GOAT.");
                int row = sc.nextInt();
                int col = sc.nextInt();
                boolean[] available_moves = availableMove(row, col);
                if(available_moves[0]){
                    System.out.println("1. Move Upwards");
                }
                if(available_moves[1]){
                    System.out.println("2. Move Downwards");
                }
                if(available_moves[2]){
                    System.out.println("3. Move Left");
                }
                if(available_moves[3]){
                    System.out.println("4. Move Right");
                }
                if(available_moves[4]){
                    System.out.println("5. Move Top Left");
                }
                if(available_moves[5]){
                    System.out.println("6. Move Top Right");
                }
                if(available_moves[6]){
                    System.out.println("7. Move Bottom Left");
                }
                if(available_moves[7]){
                    System.out.println("8. Move Bottom Right");
                }
                select = sc.nextInt();
                switch(select){
                    case 1:
                        board[row-1][col] = GOAT;
                        break;
                    case 2:
                        board[row+1][col] = GOAT;
                        break;
                    case 3:
                        board[row][col-1] = GOAT;
                        break;
                    case 4:
                        board[row][col+1] = GOAT;
                        break;
                    case 5:
                        board[row-1][col-1]= GOAT;
                        break;
                    case 6:
                        board[row-1][col+1] = GOAT;
                        break;
                    case 7:
                        board[row+1][col-1] = GOAT;
                        break;
                    case 8:
                        board[row+1][col+1] = GOAT;
                        break;
                    default : 
                        System.out.println("Invalid Move!");
                        break;
                }
                board[row][col] = EMPTY;
            }
        }
        return;
    }
    private void printBoard(){
        //Clear console
        try{
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }catch (final Exception e){
            
        }
        //\Clear Console
        this.playerInfo();
        for(int i = 0; i< 5; i++){
            for(int j = 0;j <5; j++){
                if(this.board[i][j] == TIGER){
                    System.out.print("  T  ");
                }else if(this.board[i][j] == GOAT){
                    System.out.print("  G  ");
                }else{
                    System.out.print("  *  ");
                }
            }
            System.out.println("\n");
        }
    }
    private boolean[] availableMove(int row, int column){
        boolean left = false;
        boolean right = false;
        boolean top = false;
        boolean bottom  = false;
        boolean top_left = false;
        boolean top_right = false;
        boolean bottom_left = false;
        boolean bottom_right = false;
        int move = (this.turn == TIGER) ? TIGER : GOAT ;
        if(move == TIGER){
            if(
                ((row -1) > -1 && board[row-1][column] == EMPTY) |
                (((row - 2) > - 1) && board[row -1][column] == GOAT && board[row-2][column] == EMPTY)
            ){
                top = true;
            }
            if(
                ((row + 1) < 5 && board[row+1][column] == EMPTY) |
                (((row + 2) < 5) && board[row+1][column] == GOAT && board[row+2][column] == EMPTY)
            ){
                bottom = true;
            }
            if(
                ((column -1) > -1 && board[row][column -1 ] == EMPTY) |
                (((column - 2) > - 1) && board[row][column -1] == GOAT && board[row][column -2] == EMPTY)
            ){
                left = true;
            }
            if(
                ((column + 1) < 5 && board[row][column + 1 ] == EMPTY) |
                (((column + 2)  < 5) && board[row][column +1] == GOAT && board[row][column +2] == EMPTY)
            ){
                right = true;
            }
            if(
                ((row -1) > -1) && ((column - 1) > -1) && board[row-1][column-1] == EMPTY |
                (
                    ((row -2) > -1) &&
                    ((column - 2) > -1) && 
                    board[row-2][column-2] == EMPTY && 
                    board[row-1][column - 1] == GOAT
                )
            ){
                top_left = true;
            }
            if(
                ((row -1) > -1) && ((column + 1) < 5) && board[row-1][column+1] == EMPTY |
                (
                    ((row -2) > -1) &&
                    ((column + 2) < 5) && 
                    board[row-2][column+2] == EMPTY && 
                    board[row-1][column + 1] == GOAT
                )
            ){
                top_right = true;
            }
            if(
                ((row +1) < 5 ) && ((column - 1) > -1) && board[row+1][column-1] == EMPTY |
                (
                    ((row + 2) < 5) &&
                    ((column - 2) > -1) && 
                    board[row+2][column-2] == EMPTY && 
                    board[row+1][column - 1] == GOAT
                )
            ){
                bottom_left = true;
            }
            if(
                ((row + 1) < 5) && ((column + 1) < 5) && board[row+1][column+1] == EMPTY |
                (
                    ((row + 2) < 5) &&
                    ((column + 2) < 5) && 
                    board[row+2][column+2] == EMPTY && 
                    board[row+1][column + 1] == GOAT
                )
            ){
                bottom_right = true;
            }
        }else{
            if(
                (row -1) > -1 && 
                board[row-1][column] == EMPTY
            ){
                top = true;
            }
            if(
                (row + 1) < 5 && 
                board[row+1][column] == EMPTY
            ){
                bottom = true;
            }
            if(
                (column -1) > -1 && 
                board[row][column -1 ] == EMPTY
            ){
                left = true;
            }
            if(
                (column + 1) < 5 && 
                board[row][column + 1 ] == EMPTY
            ){
                right = true;
            }
            if(
                ((row -1) > -1) && 
                ((column - 1) > -1) && 
                board[row-1][column-1] == EMPTY 
            ){
                top_left = true;
            }
            if(
                ((row -1) > -1) && 
                ((column + 1) < 5) && 
                board[row-1][column+1] == EMPTY
            ){
                top_right = true;
            }
            if(
                ((row +1) < 5 ) && 
                ((column - 1) > -1) && 
                board[row+1][column-1] == EMPTY
            ){
                bottom_left = true;
            }
            if(
                ((row + 1) < 5) && 
                ((column + 1) < 5) && 
                board[row+1][column+1] == EMPTY
            ){
                bottom_right = true;
            }
        }
        boolean[] array =  { top, bottom, left, right, top_left, top_right, bottom_left, bottom_right };
        return array;
    }
    private void gameInfo(){
        if(KILLED_GOATS > 5){
            System.out.println("*****TIGER WINS THE GAME*****");
            System.exit(0);
        }
        
    }   
    public static void main(String args[]) {
        BaghChal game = new BaghChal();
        game.initBoard();
        while(true){
            game.printBoard();
            game.playerInfo();
            game.move();
            game.gameInfo();
            game.switchTurn();
            if(game.KILLED_GOATS > 5){
                break;
            }
        }
    }
};