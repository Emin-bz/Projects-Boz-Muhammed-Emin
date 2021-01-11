/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menue;

import Gui.Gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import snake.Clock;
import snake.Gegner.ClockGegner;
import Gui.Spielanleitung;

/**
 *
 * @author Muhammed Emin Boz
 */
public class Menue extends JFrame {
    
    
JFrame jf;

Container pane;
JComponent gegner;
JComponent spielanleitung;

public void run () {

    jf = new JFrame();

    jf.setTitle("Snake Race: Menü");
    jf.setSize(400, 400);
    jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jf.setResizable(false);
    jf.setLayout(null);
    jf.setLocationRelativeTo(null);
    
    pane = jf.getContentPane();
    pane.setLayout(new BorderLayout());
    
    gegner = Start();
    spielanleitung = Spielanleitung();
    
    pane.add(gegner, BorderLayout.CENTER);
    pane.add(spielanleitung, BorderLayout.SOUTH);
    
    jf.setVisible(true);

}
      
    public JComponent Start () {

    JButton button = new JButton ("Start");
    button.setMinimumSize(new Dimension(400,200));
    button.addActionListener(new ActionListener() {
    
    public void actionPerformed(ActionEvent e) {
   
       
        jf.dispatchEvent(new WindowEvent(jf, WindowEvent.WINDOW_CLOSED));
        
        Gui gui = new Gui();
        Clock clock = new Clock();
        ClockGegner clockgegner = new ClockGegner();
        
        clock.start();   
        clockgegner.start();
        
    }
    });
    
    return button;

}
    
    public JComponent Spielanleitung () {

    JButton button = new JButton ("Spielanleitung");
    button.setMinimumSize(new Dimension(400,200));
    button.addActionListener(new ActionListener() {
    
    public void actionPerformed(ActionEvent e) {
   
        jf.dispatchEvent(new WindowEvent(jf, WindowEvent.WINDOW_LOST_FOCUS));
        
        Spielanleitung spielanleitung = new Spielanleitung();
     
    }
    });
    
    return button;

}
}
    

