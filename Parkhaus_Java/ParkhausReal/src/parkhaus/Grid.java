/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhaus;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Muhammed Emin Boz
 */
public class Grid extends AbstractTableModel {
    
    
    private String [] columnNames = {"Ausgabe", "Verfall", "Preis"};
    private Object[][] data = {};
    private Leitsystem system;
    
    
    public Grid (Leitsystem system) {
    this.system = system;
    
    }
    
    public int getColumnCount () {

    return columnNames.length;
}
    
    public int getRowCount () {
    
    return system.getTickets().size();
    }
    
    public String getColumnName (int col) {
    
    return columnNames [col];
    
    }
    
    public Object getValueAt (int row, int col) {
    
    Object value = "";
    
   
    Ticket ticket = system.getTickets().get(row);
    
    if(ticket == null) {
        return null;
    }
  
    switch (col) {
    
        case 0:
            value = ticket.getAusgabe();
            break;
        case 1:
            value = ticket.getVerfall();
            break;
        case 2:
            value = ticket.getPreis();
        
    }
    
    //value = ticket.toString();
    return value;
        
    }
   
    public Class getColumnClass(int column) {
    
    for (int row = 0; row  < getRowCount(); row++) {
    
   
    Object o = getValueAt(row, column);
    

if (o!= null) {
return o.getClass();

}
    }
    
    return Object.class;
}
}
