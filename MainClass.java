/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessmk3;

import static java.lang.Math.*;
import java.util.*;


/**
 *
 * @author ahmad
 */
public class MainClass extends Game {
    static int movecounter = 0;
    static Piece board[][] = new Piece[9][9];

    public static boolean kingInCheckMate(){


        //kingInCheck();


        return false;
    }

    public static boolean kingInCheck(){

        int kingX, kingY;

        //finding white's king
        if(movecounter%2 == 0){
            for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {
                    if(board[i][j].app == 'K' && board[i][j].owner == 'w'){
                        kingX = i;
                        kingY = j;
                        break;
                    }
                }
            }
        }

        //finding black's king
        else
            for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {
                    if(board[i][j].app == 'K' && board[i][j].owner == 'b'){
                        kingX = i;
                        kingY = j;
                        break;
                    }
                }
            }



        return false;
    }


    public static boolean checkvalid(char piece, char piece2, char owner, int x1, int x2, int y1, int y2){

        if((movecounter%2 ==0 && owner == 'w') || (movecounter%2 !=0 && owner == 'b')){
                switch(piece){
               case 'K':
                   if(abs(x2-x1) == 1 && abs(y2-y1) == 1) ///INCLUDE CASTLING - you can just hardcode it in an if condition and place it above this one so it catches it first
                       return true;
                   else
                       return false;


               case 'Q':
                   if((abs((x2-x1)/(y2-y1)) == 1) || x2-x1 == 0 || y2-y1 == 0)
                       return true;
                   else
                        return false;

               case 'B':
                   if(abs((x2-x1)/(y2-y1)) == 1)
                       return true;
                   else
                       return false;


               case 'R':
                   if(x2-x1 == 0 || y2-y1 == 0)
                       return true;

                   else
                       return false;

            //////////////////CHECK THIS\/\/\/
               case 'N':
                   if(((abs(y2-y1) == 1) && (abs(x2-x1) == 2)) || ((abs(y2-y1) == 2) && (abs(x2-x1) == 1)))
                       return true;

                   else
                       return false;


               case 'P':
                   if(owner == 'b'){
                       if((x2==x1 && y2-y1 == 1) || (board[x2][y2].app != ' ' && abs(x2-x1)==1 && y2-y1 ==1) || (y1 ==2 &&x2==x1 && y2-y1 == 2))
                            return true;
                       else
                            return false;
                   }

                   else
                       if((x2==x1 && y2-y1 == -1) || (board[x2][y2].app != ' ' && abs(x2-x1)==1 && y2-y1 ==-1) || (y1 ==7 &&x2==x1 && y2-y1 == -2))
                            return true;
                       else
                            return false;



            }
        }


            return false;
    }


    public static void main(String[] args) {
        Piece board[][] = new Piece[9][9];
        Piece Empty = new Piece(0, 'n', ' ');
        Piece temp = new Piece(0, 'n', ' ');


        ArrayList<Piece> takenBL = new ArrayList<Piece>();
        ArrayList<Piece> takenWH = new ArrayList<Piece>();

        Scanner userInput = new Scanner(System.in);



        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;



        Game g1 = new Game();
        g1.initializeBoard(board);


        System.out.println("Enter your move by inputting the initial and final positions using x y coordinates");


        while(kingInCheckMate() == false){

            g1.printBoard(board, takenBL, takenWH);

            if(movecounter%2 == 0)
                System.out.println("White:");

            else
                System.out.println("Black:");

            x1 = userInput.nextInt();
            y1 = userInput.nextInt();
            x2 = userInput.nextInt();
            y2 = userInput.nextInt();

            if((x1 < 9 && x1 > 0) && (x2 < 9 && x2 > 0) && (y1 < 9 && y1 > 0) && (y2 < 9 && y2 > 0))
            {
                ////If the king in check this forces them to move only that king
                if(kingInCheck() == true && checkvalid(board[x1][y1].app, board[x2][y2].app, board[x1][y1].owner, x1, x2, y1, y2) == true)
                {
                    temp = board[x2][y2];
                    board[x2][y2] = board[x1][y1];
                    board[x1][y1] = Empty;

                    //after the move, king was still in check so it undoes the move
                    if(kingInCheck() == true){
                        System.out.println("Invalid move please enter again");
                        board[x1][y1] = board[x2][y2];
                        board[x2][y2] = temp;
                    }

                    //valid move
                    else
                    {
                       if(temp.app != ' ')
                       {
                           if(movecounter%2 == 0) //takes modulous << if its even it goes here & is white's move
                            {
                                takenBL.add(board[x2][y2]);
                            }

                            else
                            {
                                takenWH.add(board[x2][y2]);
                            }
                       }
                        movecounter++;
                    }

                }

                else if(kingInCheck() == false && checkvalid(board[x1][y1].app, board[x2][y2].app, board[x1][y1].owner, x1, x2, y1, y2) == true){
                    //new position is empty
                        if(board[x2][y2].app == ' '){
                            //do nothing and carry on with the code
                        }

                        //new position contains a piece
                        else{
                            if(movecounter%2 == 0) //takes modulous << if its even it goes here & is white's move
                            {
                                takenBL.add(board[x2][y2]);
                            }

                            else
                            {
                                takenWH.add(board[x2][y2]);
                            }
                        }

                    //make the actual move too
                    //Do it here \/\/\/



                    board[x2][y2] = board[x1][y1];
                    board[x1][y1] = Empty;

                    movecounter++;
                }

                else
                  System.out.println("Invalid move please enter again");
            }

            else
              System.out.println("Invalid move please enter again");

        }



    }

}
