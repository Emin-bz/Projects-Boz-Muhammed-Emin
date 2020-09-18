/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author eminb
 */
public class DrawSpielanleitung extends JLabel {
    
    protected void paintComponent(Graphics g) {
        
        ImageIcon spielanleitung = new ImageIcon("spielanleitung.png"); 
         g.drawImage(spielanleitung.getImage(), 0, 0, this);
    }
    }
    

