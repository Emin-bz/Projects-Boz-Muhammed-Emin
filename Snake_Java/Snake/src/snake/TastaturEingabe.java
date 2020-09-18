/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import snake.Kopf;

/**
 *
 * @author Muhammed Emin Boz
 */
public class TastaturEingabe implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        //Keine Nutzung
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        
    switch(e.getKeyCode()) {
        
                case KeyEvent.VK_UP:
                   
                    if (Hauptsystem.kopf.getRichtung() != Steuerung.DOWN)
                    Hauptsystem.kopf.setRichtung(Steuerung.UP);
                break;
                   
                case KeyEvent.VK_DOWN:
               
                    if (Hauptsystem.kopf.getRichtung() != Steuerung.UP)
                    Hauptsystem.kopf.setRichtung(Steuerung.DOWN);
                break;
                case KeyEvent.VK_RIGHT:
                    
                    if (Hauptsystem.kopf.getRichtung() != Steuerung.LEFT)
                    Hauptsystem.kopf.setRichtung(Steuerung.RIGHT);
                
                    break;              
                case KeyEvent.VK_LEFT:
                   
                    if (Hauptsystem.kopf.getRichtung() != Steuerung.RIGHT)
                    Hauptsystem.kopf.setRichtung(Steuerung.LEFT);
                break;                
                   }
    }

    @Override
    public void keyReleased(KeyEvent e) {
      // Keine Nutzung
    }
    
    
    
}
