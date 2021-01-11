package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.ImageFilter;
import java.awt.image.RGBImageFilter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import snake.Hauptsystem;
import snake.Statistik;
import snake.Steuerung;

/**
 *
 * @author Muhammed Emin Boz
 */
public class Draw extends JLabel {
    
    Point koordinate;
    Point koordinate_gegner;
    
    protected void paintComponent(Graphics g) {
        
    super.paintComponent(g);
    
 
  
    //Hintergrund zeichnen
    
    g.setColor(Color.BLACK);
    g.fillRect(0,0,1600,900);
    repaint();
    
    // Spielfeld des Spielers zeichnen
    
    g.setColor(Color.WHITE);
    g.drawRect(55, 177, 705 , 578);

    repaint();
    
    // Spielfeld des Gegners zeichnen
    
    g.setColor(Color.WHITE);
    g.drawRect(817, 177, 705, 578);
    repaint();
    
    
    // Mittlere Linie Zeichnen
    
    g.setColor(Color.WHITE);
    g.drawLine(789, 0, 789, 1200);
    

    // Essen zeichnen
    
    // png bild aus dem Internet 
    ImageIcon essen = new ImageIcon("apple.png");
    
    koordinate = Hauptsystem.Koordinaten(Hauptsystem.essen.getX(), Hauptsystem.essen.getY());
    g.drawImage(essen.getImage(), koordinate.x, koordinate.y, this);
    repaint();
 
    
    
    // Den Spieler zeichnen
  
     ImageIcon head_image = new ImageIcon("head_left.png");
     ImageIcon head_image2 = new ImageIcon("head_right.png");
     ImageIcon head_image3 = new ImageIcon("head_down.png");
     ImageIcon head_image4 = new ImageIcon("head_up.png");
     
      
    koordinate = Hauptsystem.Koordinaten(Hauptsystem.kopf.getX(), Hauptsystem.kopf.getY());
   
    if (Hauptsystem.kopf.getRichtung() == Steuerung.WAIT) {
    g.drawImage(head_image3.getImage(), koordinate.x, koordinate.y, this);
    repaint();
    }   
    else if (Hauptsystem.kopf.getRichtung() == Steuerung.LEFT) {
    g.drawImage(head_image.getImage(), koordinate.x, koordinate.y, this);
    repaint();
    }
    else if (Hauptsystem.kopf.getRichtung() == Steuerung.RIGHT){
    g.drawImage(head_image2.getImage(), koordinate.x, koordinate.y, this);
    }
    else if (Hauptsystem.kopf.getRichtung() == Steuerung.DOWN){
    g.drawImage(head_image3.getImage(), koordinate.x, koordinate.y, this);
    }
    else if (Hauptsystem.kopf.getRichtung() == Steuerung.UP){
    g.drawImage(head_image4.getImage(), koordinate.x, koordinate.y, this);
    }
    repaint();
    
    // Reihe des Gegners zeichnen
    
    g.setColor(Color.WHITE);
    for (int i = 0; i < Hauptsystem.reihe_gegner.size(); i++) {
    
        koordinate = Hauptsystem.Koordinaten_gegner(Hauptsystem.reihe_gegner.get(i).getX(), Hauptsystem.reihe_gegner.get(i).getY());
        g.fillRect(koordinate.x, koordinate.y, 64, 64);
    
    }
    
    
    // Den Gegner zeichnen
 
    koordinate = Hauptsystem.Koordinaten_gegner(Hauptsystem.kopf_gegner.getX(), Hauptsystem.kopf_gegner.getY());
    
    g.setColor(Color.WHITE);
    g.fillRect(koordinate.x, koordinate.y, 64, 64);
    repaint();
    
    
    // Essen des Gegners zeichnen
    
    // png bild aus dem Internet 
    ImageIcon essen_gegner = new ImageIcon("apple.png");
    
    koordinate = Hauptsystem.Koordinaten_gegner(Hauptsystem.essen_gegner.getX(), Hauptsystem.essen_gegner.getY());
    g.drawImage(essen_gegner.getImage(), koordinate.x, koordinate.y, this);
    repaint();

    

    // Reihe zeichnen
    
    g.setColor(Color.GREEN);
    for (int i = 0; i < Hauptsystem.reihe.size(); i++) {
    
    koordinate = Hauptsystem.Koordinaten(Hauptsystem.reihe.get(i).getX(), Hauptsystem.reihe.get(i).getY() );
    g.fillRect(koordinate.x, koordinate.y, 64,64);
    }
    
 
    // Statistik zeichnen
    
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 20));
    
    g.drawString("Punkte: " + Statistik.Punkte, 55, 103);
    g.drawString("Rekord: " + Statistik.Rekord, 55, 125);
    g.drawString("Gewonnene Runden: " + Statistik.RundenGewonnen, 500, 103);
     g.drawString("Insgesamt gewonnen: " + Statistik.Insgesamt, 500, 140);
    
    g.drawString("Punkte: " + Statistik.Punkte_Gegner, 830, 103);
    g.drawString("Rekord: " + Statistik.Rekord_Gegner, 830, 125);
    g.drawString("Gewonnene Runden: " + Statistik.RundenGewonnen_gegner, 1270, 103);
    g.drawString("Insgesamt gewonnen: " + Statistik.Insgesamt_gegner, 1270, 140);
    
    
    
    
    
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 60));
    
  
    
    
          
       if(Statistik.endgültigGewonnen() == true) {
           
           
   
   
       g.drawString("SPIELER GEWINNT!", 535, 400);
       
      
       


       }
      
   if(Statistik.endgültigGewonnen_gegner() == true) {
   
      Hauptsystem.reihe.clear();
      Hauptsystem.reihe_gegner.clear();
     
      Hauptsystem.kopf.setX(4);
      Hauptsystem.kopf.setX(5);
      
      Hauptsystem.kopf_gegner.setX(4);
      Hauptsystem.kopf_gegner.setX(5);
      
       g.drawString("CPU GEWINNT!", 550, 400);
       
}
    
   
   
   if(snake.Clock.cooldown_set == true) {
   
       g.drawString("READY?", 660, 400);
       
   
   }
   
    if(snake.Clock.cooldown_go == true) {
   
       g.drawString("GO!", 720, 400);
       
   
   }
    
   

   
   

   
   
   
   

    }
}
