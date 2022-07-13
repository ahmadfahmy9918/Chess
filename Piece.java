/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessmk3;

/**
 *
 * @author ahmad
 */
public class Piece {
    
    int value;
   // int positionX;
    //int positionY;
    char owner;
    char app;
    
    public Piece(int value, char owner, char app/*,int positionX, int positionY*/){
        this.value = value;
        this.owner = owner;
        this.app = app;
        //this.positionX = positionX;
        //this.positionY = positionY;
        
    }
}
