/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.Gegner;

import snake.Steuerung;

/**
 *
 * @author Muhammed Emin Boz
 */
public class Kopf_Gegner {
    
    
    int x;
    int y;
    
    
    static boolean isWait = false;
    
    public Kopf_Gegner (int X, int Y) {
    
        this.x = X;
        this.y = Y;
    
    }
    
    public void setX(int X) {
    
    this.x = X;
    }
    
    public void setY(int Y) {
    
    this.y = Y;
    }
    
    public int getX () {
    
    return x;
    }
    
    public int getY () {
    
    return y;
    }
    

    
    public boolean isWait () {
    
    return isWait;
    
    }
    
    public static void setIsWait(boolean b) {
    
        isWait = b;
        
    }
    
    
    
}
