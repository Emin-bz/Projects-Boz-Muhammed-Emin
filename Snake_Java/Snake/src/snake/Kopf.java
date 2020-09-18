/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author Muhammed Emin Boz
 */
public class Kopf {
    
    int x;
    int y;
    public Steuerung r = Steuerung.RIGHT;
    
    public Kopf (int X, int Y) {
    
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
    
    public void setRichtung(Steuerung R) {
    
        r = R;
    }
    
    
    public Steuerung getRichtung() {
    
        return r;
    }
    
    
    
}
