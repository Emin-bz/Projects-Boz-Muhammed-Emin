
package parkhaus;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Map.Entry;
import javax.swing.*;


public class Leitsystem extends JFrame implements ActionListener {
    
    protected ArrayList <Ticket> TicketTree = new ArrayList <Ticket>();
     
    protected Einfahrt einfahrt = new Einfahrt(this);
    protected Ausfahrt ausfahrt = new Ausfahrt(this);
    
    protected Kasse kasse = new Kasse(this);
    
    
    protected final int MAX_PLAETZE = 100;
    
    
    public Leitsystem () {
    
    createCommand();
        
    this.setTitle("Leitsystem");
  
    //Festlegung der Position auf dem Bildschirm
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width/3-this.getSize().width/2, dim.height/4-this.getSize().height/2);
    
    this.setSize(600, 600);
    this.getContentPane().setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    
    this.repaint();
    
    }
    
    
    public void createCommand () {
    
    JMenuBar bar;
    
    JMenu menu;
    JMenu submenu;
    
    JMenuItem menuItem;
    
    
    JRadioButtonMenuItem radioItem;
    JCheckBoxMenuItem boxItem;
    
    
    bar = new JMenuBar();
    menu = new JMenu("Befehle");
    bar.add(menu);
    
    // Einfahrtsschranke
    submenu = new JMenu("Einfahrtsschranke");
    
    
    menuItem = new JMenuItem("Oeffnen");
    menuItem.setActionCommand("Einfahrt oeffnen");
    menuItem.addActionListener(this);
    submenu.add(menuItem);

    menuItem = new JMenuItem("Offen lassen");
    menuItem.setActionCommand("Einfahrt offenlassen");
    menuItem.addActionListener(this);
    submenu.add(menuItem);
    
    menuItem = new JMenuItem("Schliessen");
    menuItem.setActionCommand("Einfahrt schliessen");
    menuItem.addActionListener(this);
    submenu.add(menuItem);
    
    menu.add(submenu);
    
    radioItem = new JRadioButtonMenuItem();
    boxItem = new JCheckBoxMenuItem();
    
    
    // Ausfahrtschranke
    
    submenu = new JMenu("Ausfahrtsschranke");
    
    
    
    menuItem = new JMenuItem("Oeffnen");
    menuItem.setActionCommand("Ausfahrt oeffnen");
    menuItem.addActionListener(this);
    submenu.add(menuItem);
    
    menuItem = new JMenuItem("Offen lassen");
    menuItem.setActionCommand("Ausfahrt offenlassen");
    menuItem.addActionListener(this);
    submenu.add(menuItem);
    
    
    menuItem = new JMenuItem("Schliessen");
    menuItem.setActionCommand("Schranke schliessen");
    menuItem.addActionListener(this);
    submenu.add(menuItem);
    
    
    menu.add(submenu);
    
    menu.addSeparator();
    
    menuItem = new JMenuItem("Beenden");
    menuItem.setActionCommand("Programm beenden");
    menuItem.addActionListener(this);
    menu.add(menuItem);
    
    this.setJMenuBar(bar);
    
        
        
    }
    
    public ArrayList<Ticket> getTickets () {
    
    return TicketTree;
    
    }
    

    
    
    public void actionPerformed(ActionEvent e) {
    
    switch (e.getActionCommand()) {
    
        case "Einfahrt oeffnen":
            einfahrt.oeffnen(false);
            break;
        case "Einfahrt offenlassen":
            einfahrt.oeffnen(true);
            break;
        case "Einfahrt schliessen":
            einfahrt.schliessen();
            break;
        case "Ausfahrt oeffnen":
            ausfahrt.oeffnen(false);
            break;
        case "Ausfahrt offenlassen":
            ausfahrt.oeffnen(true);
            break;
        case "Schranke schliessen":
            ausfahrt.schliessen();
            break;
        case "Programm beenden":
            System.exit(0);
            break;
    }
    
    
    }
    
    
    public int getFreiePlaetze () {
    
        return MAX_PLAETZE - this.getBelegtePlaetze();
    
    }
    
    public int getBelegtePlaetze () {
      
    return TicketTree.size();
    }
    
    public String getMenu () {
    
        String s = "";
        
        if (getFreiePlaetze() > 0) {
        
        s += "e = Einfahrt\n";
        }
        
        if (this.getBelegtePlaetze() > 0) {
        
        s+= "a = Ausfahrt\n";
        s+= "z = Zahlen\n";
        }
        
        s+= "s = Status \n";
        s+= "x = Beenden";
        return s;
    
    }
    
    
    public void Einfahrt () {
    
        if (this.getFreiePlaetze() > 0) {

            TicketTree.add(new Ticket());
            einfahrt.oeffnen(false);
         
        }
    
    
    }
    

    
    
    
    public void Ausfahrt (int key) {
    
        ausfahrt.Ausfahren(TicketTree, key);
        
        }
    
    
    public void Zahlen (int key) {
    
     
    kasse.Zahlen(TicketTree, key);

}
    
    
    
    @Override
    public String toString () {
        
        for (int i = 0; i <50; i++) {
        System.out.println();
        }
        String s = " ";
        
        s = "Anzahl Plaetze\n";
        s+= "Parkingslots:\t" + this.MAX_PLAETZE + "\n";
        s += "Belegt:\t\t" + this.getBelegtePlaetze() + "\n";
        s+= "Frei:\t\t" + this.getFreiePlaetze() + "\n";
        
        s+= "Einfahrsschranke" + einfahrt + "\n";
        s+= "Ausfahrtsschranke" + ausfahrt + "\n";
        
        s+= "Tickets:\n";
        
        //for (java.util.Iterator<Entry<Integer, Ticket>> i = this.TicketTree.entrySet().iterator(); i.hasNext();) {
        
          //  Entry e = (Entry) i.next();
       //     s+= "Nr:" + e.getKey() + "\t" + e.getValue() + "\n"; 
       // }
       // return s;
    
   // }

 

return s;  
}

}
