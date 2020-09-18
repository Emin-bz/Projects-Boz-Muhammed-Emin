package Gui;

import javax.swing.JFrame;
import snake.TastaturEingabe;
/**
 *
 * @author Muhammed Emin Boz
 */
public class Gui extends JFrame {
    
    Draw d;
    
    public Gui () {
    
    d = new Draw();
        
    this.setTitle("Snake 1vs1: Im Spiel");
    this.setSize(1600, 900);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
    
    this.addKeyListener(new TastaturEingabe());
    
    d.setBounds(0,0,1600,900);
    d.setVisible(true);  
  
    this.add(d);
    
    this.setVisible(true);
    
    }
   
}
