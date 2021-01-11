/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhaus;

import java.awt.*;
import java.util.TimerTask;
import javax.swing.*;
import java.util.Timer;
import java.util.*;

/**
 *
 * @author Muhammed Emin Boz
 */
public abstract class Schranken extends JFrame {
    
    protected boolean Open;
    
    protected Leitsystem system;
    protected Container pane;
    protected Ampel ampel = new Ampel();
    protected JComponent footer;
    protected JComponent zahlung;
    protected boolean isOffen = false;
    
    protected Schranken () {
    
        this.Open = false;
        
    }
    
    //Festlegen des Layouts und Positionierung der Elemente
    public Schranken (Leitsystem system) {
    
    this.system = system;
    
     footer = this.getFooter();
     
     pane = getContentPane();
     pane.setLayout(new BorderLayout());
     
     pane.add(ampel, BorderLayout.CENTER);
     pane.add(footer, BorderLayout.SOUTH);
     
     this.setVisible(true);
    
    
    }
    
    // Das warten von 4 Sekunden, bis es weitergeht, nicht nötig aber für Kosmetik
    public void oeffnen (boolean isOffenHalten) {
    
        Timer timer;
        this.Open = true;
        ampel.oeffnen();
        
        if(!isOffenHalten) {
    
            timer = new Timer();
            timer.schedule(new Task(this), 3000);
        }
        }
    
    
     public void schliessen() {
    
    Open = false;
    
    ampel.schliessen();
         
    }
    
    protected abstract JComponent getFooter();
    
   
  
     
     
     
    @Override
    public String toString () {
    
        String s;
        return "\tStatus: " + (this.Open ? "offen" : "geschlossen");    
    }
    
    
    
    
    
      class Task extends TimerTask {

        protected Schranken schranke;
        
        public Task (Schranken schranke) {
        
        this.schranke = schranke;
        
        }
        
        public void run() {
        
        schranke.schliessen();
        }
        
        
        
        
        
      
    
    
    }
}
