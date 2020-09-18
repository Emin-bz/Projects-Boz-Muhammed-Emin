/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.Gegner;

import java.util.concurrent.ThreadLocalRandom;
import snake.Hauptsystem;
import static snake.Hauptsystem.reihe;
import snake.Statistik;

/**
 *
 * @author Muhammed Emin Boz
 */
public class Kollidation_Gegner {
    
    
    public static void KollidationEssen_gegner () {
    
    if (Hauptsystem.essen_gegner.getX() == Hauptsystem.kopf_gegner.getX() 
            && Hauptsystem.essen_gegner.getY() == Hauptsystem.kopf_gegner.getY()) {
    
    Hauptsystem.essen_gegner.x = ThreadLocalRandom.current().nextInt(0, 10);
    Hauptsystem.essen_gegner.y = ThreadLocalRandom.current().nextInt(2, 10);
            
    Hauptsystem.createReihe_gegner();
    
    Statistik.addPunkte_Gegner();
    Statistik.addRekord_Gegner();
    
    }
    
    
    
    
    }
    
    
    public static void KollidationSelf_gegner () {
    
        for (int i = 0; i < Hauptsystem.reihe_gegner.size(); i++) {
    if(Hauptsystem.kopf_gegner.getX() == Hauptsystem.reihe_gegner.get(i).getX() && 
            Hauptsystem.kopf_gegner.getY() == Hauptsystem.reihe_gegner.get(i).getY() &&
            !Hauptsystem.reihe_gegner.get(i).getWait() == true) {  
        
        
        Hauptsystem.reihe_gegner.clear();
        
        Hauptsystem.kopf_gegner.setX(4);
        Hauptsystem.kopf_gegner.setY(5);
        Statistik.addGewonnenRunde();
        
        Statistik.Punkte_Gegner = 0;
        }
        }
        
        
       
    
  
    }
    
    
        // Wand Kollidation
    
    public static void WandKollidation_gegner () {
    
        if(Hauptsystem.kopf_gegner.getX() > 10 || Hauptsystem.kopf_gegner.getY() > 10 || Hauptsystem.kopf_gegner.getX() < 0 || Hauptsystem.kopf_gegner.getY() < 2) {
    
        Hauptsystem.resetKopfWand_gegner();
        Hauptsystem.reihe_gegner.clear();
        Hauptsystem.kopf_gegner.setX(4);
         Hauptsystem.kopf_gegner.setY(5);
        
  Statistik.addGewonnenRunde();
        
  Statistik.Punkte_Gegner = 0;
      
    
    }
    }
    
    
}
