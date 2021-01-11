/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import snake.TastaturEingabe;

/**
 *
 * @author eminb
 */
public class Spielanleitung {
    
    DrawSpielanleitung d;
    
     JFrame jf;
    JButton jb;

    
    public Spielanleitung () {
        
        jb = new JButton("Zurück");
        Container pane;
      jf = new JFrame();
    d = new DrawSpielanleitung();
    
  
      
    jf.setTitle("Snake Race: Spielanleitung");
    jf.setSize(606, 740);
    jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jf.setResizable(false);
    jf.setLayout(null);
    jf.setLocationRelativeTo(null);
    
    jf.addKeyListener(new TastaturEingabe());
    
   
    
    d.setBounds(0,300,600,700);
    d.setVisible(true);  
    
    pane = jf.getContentPane();
    pane.setLayout(new BorderLayout());
    pane.add(Zurücktaste(), BorderLayout.NORTH);
  
    jf.add(d);
    
    jf.setVisible(true);
    
    }
 
    public JComponent Zurücktaste () {

    JButton button = new JButton ("Zurück");
   
    button.addActionListener(new ActionListener() {
    
    public void actionPerformed(ActionEvent e) {
   
       jf.setVisible(false);
      
       
       
       
     
     
    }
    });
    
    return button;

}
    
}
