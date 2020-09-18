
package parkhaus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Kasse extends JFrame {
    
    protected Leitsystem system;
  
    protected JComponent footer;
    
    protected Schranken schrank;
    
    Container container;
    JTable table;
   
    
    public Kasse (Leitsystem system) {
    
    //Festlegung der Position auf dem Bildschirm
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width/3-this.getSize().width/3, dim.height/10-this.getSize().height/30);
        
        this.system = system;
        this.setTitle("Kasse");
        this.setSize(600,600);
        
        footer = this.getFooter();
        
        container = getContentPane();
        container.setLayout(new BorderLayout());
        
        container.add(footer, BorderLayout.SOUTH);
        container.add(getRight());
        
        this.setVisible(true);

    
    }
    
    public Ausfahrt ausfahrt;
    
    
    public void Zahlen (ArrayList<Ticket> ID, int key) {
        
        
      
        Ticket ticket = ID.get(key);   
        ticket.setVerfall();
        
        
    }

    
    
    protected JComponent getFooter() {
     
       
        table = new JTable(new Grid(this.system));
        
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(true);
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    
        public void valueChanged(ListSelectionEvent event) {
        
          
        system.Zahlen(table.getSelectedRow());
        
       
        
        table.repaint();
       
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
