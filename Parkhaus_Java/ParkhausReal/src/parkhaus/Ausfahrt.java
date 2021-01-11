
package parkhaus;

// --- Imports ------
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.joda.time.*;

public class Ausfahrt extends Schranken {
    
    JTable table;
    public Ausfahrt () {}
    
    
    
    public Ausfahrt (Leitsystem system) {
    
    super(system);
    
    //Festlegung der Position auf dem Bildschirm
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width/19-this.getSize().width/4, dim.height/3-this.getSize().height/10);
    
    
    pane.add(getRight(), BorderLayout.EAST);  
    
    
    this.setSize(350, 500);
    this.setTitle("Ausfahrtsschranke");
    }
    
   
    
    public Ticket Ausfahren (ArrayList<Ticket> ID, int key) {
        
        
        DateTime jetzt = new DateTime(DateTimeZone.UTC);
        
        Ticket ticket = ID.get(key);
        
        
        
        if (ticket.EinfahrtZeit.isAfterNow()) {
            this.oeffnen(Open);
            
            
            ID.remove(key);
        }
       
        return ticket;
    }
    
    
    Ticket t = new Ticket();
  

    protected JComponent getFooter() {
     
       
        table = new JTable(new Grid(this.system));
        
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(true);
        
      
         
             
        table.addMouseListener(new MouseAdapter() {
    
       
        public void mouseClicked(MouseEvent event) {
 
        int row = table.rowAtPoint(event.getPoint());
        int col = table.columnAtPoint(event.getPoint());
        
       
            
        if(row >= 0 && col >= 0) {
        system.Ausfahrt(table.getSelectedRow());
   
        
        table.repaint();
        
        }   
        }
    });
       
    
      
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(200,200));
        
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);
        
        return panel;
}
    
    
    protected JComponent getRight () {
    
    JButton button = new JButton ("Liste aktualisieren");
    button.setMinimumSize(new Dimension(400,200));
    button.addActionListener(new ActionListener() {
    
    public void actionPerformed(ActionEvent e) {
    table.repaint();
    }
    });
    
    return button;
    
    }




}
