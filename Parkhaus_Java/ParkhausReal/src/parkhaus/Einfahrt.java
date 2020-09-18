
package parkhaus;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;


public class Einfahrt extends Schranken  {
    
    public Einfahrt () {
    
    }
    
    
    public Einfahrt (Leitsystem system) {
     
    super(system);
        
        
    //Festlegung der Position auf dem Bildschirm
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width/4-this.getSize().width/2, dim.height/4-this.getSize().height/2);
    
        this.setSize(160,350);
        this.setTitle("Einfahrtsschranke");
    
    }
    
    protected JComponent getFooter () {
    
    JButton button = new JButton("Ticket ausgeben");
    button.addActionListener(new ActionListener() {
    
        public void actionPerformed(ActionEvent e) {
        system.Einfahrt();
        }
    });
        return button;
    }
            
    
    public void Einfahren () {
    
    
    
    }
    
    public Ticket Einfahrt () {
        
        this.oeffnen(Open);
        return new Ticket();
    
    }



    
    
    
    
   
    
}
