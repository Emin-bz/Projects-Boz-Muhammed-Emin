/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Point;
import java.util.ArrayList;
import Gui.Gui;
import java.util.concurrent.ThreadLocalRandom;
import snake.Gegner.Essen_Gegner;
import snake.Gegner.Kopf_Gegner;
import snake.Gegner.Reihe_Gegner;
    

/**
 *
 * @author Muhammed Emin Boz
 */
public class Hauptsystem {
    
    // Objekte der Klassen des Spielers
    
    public Kopf kopf1;
    public static Kopf kopf = new Kopf(4,5);
    public static  ArrayList <Reihe> reihe = new ArrayList<Reihe>();
    public static Essen essen = new Essen();
    
    public static boolean wartet = true;
    
    // Objekte der Klassen des Spielers
    public static Kopf_Gegner kopf_gegner = new Kopf_Gegner(4,5);
    public static Essen_Gegner essen_gegner = new Essen_Gegner();
     public static  ArrayList <Reihe_Gegner> reihe_gegner = new ArrayList<Reihe_Gegner>();
    
    
    
    /* Mit dieser Funktion wird die Klasse Point verwendet. Durch diese Klasse werden die Koordinaten
     des jeweiligen Characters richtig und in der gewünschten Pixeleinheit festgelegt
     */
    
     
     public Hauptsystem () {
     
         this.kopf1 = new Kopf(4,5);
     
     }
    
    public static Point Koordinaten(int x, int y)  {
    
     Point p = new Point (0, 0);
     p.x = x * 64 + 120;
     p.y = y * 64 + 50;
     
     return p;
    
    
    }
    
       public static Point Koordinaten_gegner(int x, int y)  {
    
     Point p = new Point (0, 0);
     p.x = x * 64 + 817;
     p.y = y * 64 + 50;
     
     return p;
    
    
    }
    
    
    // Funktion für das Bewegen des Characters (bzw. Kopfes)
    
    public static void bewegen () {
    
    switch (kopf.getRichtung()) {
    
            case UP:
            kopf.setY(kopf.getY() - 1);
            break;
            case DOWN:
            kopf.setY(kopf.getY() + 1);
            break;
            case RIGHT:
            kopf.setX(kopf.getX() + 1);
            break;
            case LEFT:
            kopf.setX(kopf.getX() - 1);
            break;
            
    
    
    }
    
    }
    
    
    public static void resetKopfWand () {
    
        kopf.setX(4);
        kopf.setY(5);
        
        
        kopf.setRichtung(Steuerung.WAIT);
    
    }
    
        public static void resetKopfWand_gegner () {
    
        kopf_gegner.setX(4);
        kopf_gegner.setY(5);
        
        
      
    
    }
    
    public static void resetEssenKollidation () {
    
        essen.x = ThreadLocalRandom.current().nextInt(-1, 9);
        essen.y = ThreadLocalRandom.current().nextInt(2, 10);
        
    }
    
    
 
    public static void createReihe () {
    
        if (reihe.size() < 1) {
        
            reihe.add(new Reihe(kopf.getX(), kopf.getY()));
            
        
        } else {
        
            reihe.add(new Reihe(reihe.get(reihe.size()-1).x, reihe.get(reihe.size() -1).y));
        }
    
    }
    

    public static void ReiheZufuegen () {
    
        // Reihe bewegen
        
        if (reihe.size() >= 2) {
        for (int i = reihe.size() - 1; i >= 1; i--) {
            if (reihe.get(i).getWait() == true) {
            
                reihe.get(i).setWait(false);
            }
            
            else if (reihe.get(i).getWait() == false){
            
                reihe.get(i).setX(reihe.get(i - 1).getX());
                reihe.get(i).setY(reihe.get(i - 1).getY());
            }
        
        }
        }
        
        // Reihe zu Kopf bewegen
        
        if (reihe.size() >= 1) {
            if (reihe.get(0).getWait() == true) {
                
                reihe.get(0).setWait(false);
            } 
            else {
                
                reihe.get(0).setX(kopf.getX());
                reihe.get(0).setY(kopf.getY());
            }
        }
        
    }
    
    
    public static boolean ResetReihe() {
    
    for(int i = 0; i < reihe.size(); i++) {
        if (reihe.get(i).getX() == kopf.getX() && reihe.get(i).getY() == kopf.getY() && !reihe.get(i).getWait() == true) {
            
            reihe.clear();
            Statistik.Punkte = 0;
            Statistik.addGewonnenRunden_Gegner();
            
            kopf.setX(4);
            kopf.setY(5);
            kopf.setRichtung(Steuerung.WAIT);
          
            
            
            return true;
        }
      
    
    
    }
 return false; 
    
 
    
    }
    
    static int random;

        
    
    public static void bewegen_gegner () {

        
        
    // über dem Essen, gleicher X Wert
    if (kopf_gegner.getX() == essen_gegner.getX() && 
            kopf_gegner.getY() <= essen_gegner.getY()) {
    
        kopf_gegner.setY(kopf_gegner.getY() + 1);
        
        if (essen_gegner.getX() != kopf_gegner.getX()) {
        
        kopf_gegner.setX(kopf_gegner.getX() + 1);
        }
        
     
    }
    
    
    // unter dem Essen, gleicher X Wert
    else if (kopf_gegner.getX() == essen_gegner.getX() && 
            kopf_gegner.getY() >= essen_gegner.getY()) {
    
    kopf_gegner.setY(kopf_gegner.getY() - 1);
      
    if (essen_gegner.getX() != kopf_gegner.getX()) {
        
        kopf_gegner.setX(kopf_gegner.getX() + 1);
        }
    
    
    
    }
    
    // Gleiche Höhe wie Essen, rechts vom Kopf
    else if (kopf_gegner.getY() == essen_gegner.getY() && essen_gegner.getX() > 
            kopf_gegner.getX()) {
    
        kopf_gegner.setX(kopf_gegner.getX() + 1);
        
         if (essen_gegner.getY() != kopf_gegner.getY()) {
        
        kopf_gegner.setY(kopf_gegner.getY() + 1);
        }
       
    }
             
    
    
     // Gleiche Höhe wie Essen, links vom Kopf
    else if (kopf_gegner.getY() == essen_gegner.getY() && essen_gegner.getX() < 
            kopf_gegner.getX()) {
    
        kopf_gegner.setX(kopf_gegner.getX() - 1);
    } 
    
    // Links vom Essen
    else if (kopf_gegner.getX() < essen_gegner.getX()) {
    
    kopf_gegner.setX(kopf_gegner.getX() + 1);
    }
    
    // Rechts vom Essen
    else if (kopf_gegner.getX() > essen_gegner.getX()) {
    
    kopf_gegner.setX(kopf_gegner.getX() - 1);
    
    }
    
    else if(reihe_gegner.size() >= 2) {
   
        if (reihe_gegner.get(reihe_gegner.size()).getX() > kopf_gegner.getX()
                && reihe_gegner.get(reihe_gegner.size()).getY() == kopf_gegner.getY()
                && reihe_gegner.get(reihe_gegner.size()).getWait() == true) {
        
            kopf_gegner.setY(kopf_gegner.getY() + 1);
        
        }
        
        
         if (reihe_gegner.get(reihe_gegner.size()).getY() < kopf_gegner.getY()
                && reihe_gegner.get(reihe_gegner.size()).getX() == kopf_gegner.getX()
                && reihe_gegner.get(reihe_gegner.size()).getWait() == true) {
        
            kopf_gegner.setX(kopf_gegner.getX() + 1);
        
        }
     
         if (reihe_gegner.get(reihe_gegner.size()).getY() > kopf_gegner.getY()
                && reihe_gegner.get(reihe_gegner.size()).getX() == kopf_gegner.getX()
                && reihe_gegner.get(reihe_gegner.size()).getWait() == true) {
        
            kopf_gegner.setX(kopf_gegner.getX() - 1);
        
        }
      
          if (reihe_gegner.get(reihe_gegner.size()).getX() > kopf_gegner.getX()
                && reihe_gegner.get(reihe_gegner.size()).getY() == kopf_gegner.getY()
                && reihe_gegner.get(reihe_gegner.size()).getWait() == true) {
        
            kopf_gegner.setY(kopf_gegner.getX() + 1);
        
        }
           
                  if (reihe_gegner.get(reihe_gegner.size()).getX() == kopf_gegner.getX() + 1
                && reihe_gegner.get(reihe_gegner.size()).getY() == kopf_gegner.getY()
                && reihe_gegner.get(reihe_gegner.size()).getWait() == true) {
        
            kopf_gegner.setY(kopf_gegner.getY() + 1);
        
        }
    
    
    
    }
               
              
                     
       
        
    }
    
    
    public static void createReihe_gegner () {
    
        if (reihe_gegner.size() < 1) {
        
            reihe_gegner.add(new Reihe_Gegner(kopf_gegner.getX(), kopf_gegner.getY()));
            
        
        } else {
        
            reihe_gegner.add(new Reihe_Gegner(reihe_gegner.get(reihe_gegner.size()-1).x, reihe_gegner.get(reihe_gegner.size() -1).y));
        }
    
    }
    
    public static void ReiheZufuegen_Gegner () {
    
     // Reihe bewegen vom Spieler einfach für den Gegner
        
        if (reihe_gegner.size() >= 2) {
        for (int i = reihe_gegner.size() - 1; i >= 1; i--) {
            if (reihe_gegner.get(i).getWait() == true) {
            
                reihe_gegner.get(i).setWait(false);
            }
            
            else if (reihe_gegner.get(i).getWait() == false){
            
                reihe_gegner.get(i).setX(reihe_gegner.get(i - 1).getX());
                reihe_gegner.get(i).setY(reihe_gegner.get(i - 1).getY());
            }
        
        }
        }
        
        // Reihe zu Kopf bewegen
        
        if (reihe_gegner.size() >= 1) {
            if (reihe_gegner.get(0).getWait() == true) {
                
                reihe_gegner.get(0).setWait(false);
            } 
            else {
                
                reihe_gegner.get(0).setX(kopf_gegner.getX());
                reihe_gegner.get(0).setY(kopf_gegner.getY());
            }
        }
    
    }
    
}
