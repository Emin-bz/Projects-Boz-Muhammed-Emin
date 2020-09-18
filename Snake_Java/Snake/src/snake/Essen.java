/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Muhammed Emin Boz
 */
public class Essen {
    
    
    int x;
    int y;
    
    public Essen () {
    
        this.x = ThreadLocalRandom.current().nextInt(0, 10);
        this.y = ThreadLocalRandom.current().nextInt(2, 10);
    
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
    
}
