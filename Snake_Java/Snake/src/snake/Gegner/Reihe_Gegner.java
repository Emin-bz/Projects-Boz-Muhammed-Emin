/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.Gegner;

/**
 *
 * @author Muhammed Emin Boz
 */
public class Reihe_Gegner {
    
    public int x;
    public int y;
    
    public static boolean wartet = true;
    public static boolean collided = false;
    
    public Reihe_Gegner (int X, int Y) {
    
        this.x = X;
        this.y = Y;
    
    }
    
    public static boolean getWait() {
    
        return wartet;
    }
    
    public static void setWait(boolean Wartet) {
    
    wartet = Wartet;
    
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
    
    public void setSelfCollide (boolean j) {
    
    collided = j;
        
    }
    
    public boolean getSelfCollide () {
    
    return collided;
    }
    
}
