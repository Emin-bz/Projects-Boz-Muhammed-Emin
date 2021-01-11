
package parkhaus;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


public class Ampel extends JPanel {
    
    
    protected boolean isOpen = false;
    
    public void oeffnen () {
    
    this.isOpen = true;
    this.repaint();
    
    
    }
    
    public void schliessen () {
    
    this.isOpen = false;
    this.repaint();
    
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
    
    super.paintComponent(g);
    
    Graphics2D g2d = (Graphics2D) g;
    Ellipse2D.Double oben = new Ellipse2D.Double(30, 30, 100, 100);
    Ellipse2D.Double unten = new Ellipse2D.Double(30, 160, 100, 100);
    
    
    if (isOpen) {
    
        g2d.setColor(Color.GRAY);
        g2d.fill(oben);
    
        g2d.setColor(Color.GREEN);
        g2d.fill(unten);
    } else {
    
        g2d.setColor(Color.RED);
        g2d.fill(oben);
        
        g2d.setColor(Color.GRAY);
        g2d.fill(unten);
    }
  
    
    
    
    }
    
    
    
    
    
    
}
