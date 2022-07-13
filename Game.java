/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessmk3;

import java.util.ArrayList;

/**
 *
 * @author ahmad
 */
public class Game {
    
        public void printBoard(Piece board[][], ArrayList<Piece> takenBL, ArrayList<Piece> takenWH){
    
            for (int j = 0; j < takenWH.size(); j++) {
                         System.out.println("\nTaken: " + (char)27 + "[31m" + takenWH.get(j).app );
                     }
            
            System.out.print((char)27 + "[0m" + "    1   2   3   4   5   6   7   8    ");


            for(int i = 1; i < 9; i++)
             {
               System.out.println("\n   -------------------------------");
               System.out.print((i) + " | ");


               for(int j = 1; j < 9; j++)
                 {
                   /////////////For printing the white pieces in red
                   if(board[j][i].owner == 'w'){
                         System.out.print((char)27 + "[31m" + board[j][i].app);
                         System.out.print((char)27 + "[0m" + " | ");
                   }

               /////////////white pieces
                   else
                       System.out.print(board[j][i].app + " | ");
                 }

                 if(i == 8)
                 {
                   System.out.print("\n   -------------------------------\n");
                     for (int j = 0; j < takenBL.size(); j++) {
                         System.out.println("Taken: " + takenBL.get(j).app + "\n");
                     }
                   
                 }
             }
            
            
            
            
            

                //////////////////////////////////////////////////BASIC PRINTING
                /*
                for (int k = 1; k < 9; k++)
                {
                    for (int j = 1; j < 9; j++) {
                      System.out.print(board[j][k].app + " | ");
                    }
                }
                */


                 /*
                  /////////////For printing the black pieces in red
                  if(board[moveX][moveY].owner == 'b')
                        System.out.println((char)27 + "[31m" + board[moveX][moveY].app);
                */
            
        }
        
        public void initializeBoard(Piece board[][]){
             ////Pawns
                    Piece P1 = new Piece(1, 'b', 'P');
                    board[1][2] = P1;

                    Piece P2 = P1;
                    board[2][2] = P2;

                    Piece P3 = P1;
                    board[3][2] = P3;

                    Piece P4 = P1;
                    board[4][2] = P4;

                    Piece P5 = P1;
                    board[5][2] = P5;

                    Piece P6 = P1;
                    board[6][2] = P6;

                    Piece P7 = P1;
                    board[7][2] = P7;

                    Piece P8 = P1;
                    board[8][2] = P8;


                    Piece P9 = new Piece(1, 'w', 'P');
                    board[1][7] = P9;

                    Piece P10 = P9;
                    board[2][7] = P10;

                    Piece P11 = P9;
                    board[3][7] = P11;

                    Piece P12 = P9;
                    board[4][7] = P12;

                    Piece P13 = P9;
                    board[5][7] = P13;

                    Piece P14 = P9;
                    board[6][7] = P14;

                    Piece P15 = P9;
                    board[7][7] = P15;

                    Piece P16 = P9;
                    board[8][7] = P16;



            ////ROOKS
                    Piece R1 = new Piece(5, 'b', 'R');
                    board[1][1] = R1;

                    Piece R2 = new Piece(5, 'b', 'R');
                    board[8][1] = R2;

                    Piece R3 = new Piece(5, 'w', 'R');
                    board[1][8] = R3;

                    Piece R4 = new Piece(5, 'w', 'R');
                    board[8][8] = R4;



             /////Knights
                    Piece N1 = new Piece(3, 'b', 'N');
                    board[2][1] = N1;

                    Piece N2 = new Piece(3, 'b', 'N');
                    board[7][1] = N2;

                    Piece N3 = new Piece(3, 'w', 'N');
                    board[2][8] = N3;

                    Piece N4 = new Piece(3, 'w', 'N');
                    board[7][8] = N4;



             /////Bishops
                    Piece B1 = new Piece(3, 'b', 'B');
                    board[3][1] = B1;

                    Piece B2 = new Piece(3, 'b', 'B');
                    board[6][1] = B2;

                    Piece B3 = new Piece(3, 'w', 'B');
                    board[3][8] = B3;

                    Piece B4 = new Piece(3, 'w', 'B');
                    board[6][8] = B4;

             /////Queens
                    Piece Q1 = new Piece(9, 'b', 'Q');
                    board[4][1] = Q1;

                    Piece Q2 = new Piece(9, 'w', 'Q');
                    board[4][8] = Q2;

             /////Kings
                    Piece K1 = new Piece(9, 'b', 'K');
                    board[5][1] = K1;

                    Piece K2 = new Piece(9, 'w', 'K');
                    board[5][8] = K2;




             for(int i = 1; i < 9; i++)
              {
                Piece Empty = new Piece(0, 'n', ' ');
                board[i][6] = Empty;
                board[i][5] = Empty;
                board[i][4] = Empty;
                board[i][3] = Empty;
              }
        }
    
}
