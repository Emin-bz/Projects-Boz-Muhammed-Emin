/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake.Gegner;

import snake.Hauptsystem;
import snake.Statistik;

/**
 *
 * @author Muhammed Emin Boz
 */
public class ClockGegner extends Thread {
    
    int h = 1;
    
        public void run () {
    
    do {
     try { Thread.sleep(150);}catch(InterruptedException e) {
         
         }
     
             if(Statistik.endgültigGewonnen() == true 
             ) {
          try { Thread.sleep(5000);}catch(InterruptedException e) {
         
         }
          
      Statistik.RundenGewonnen = 0;
      Statistik.insgesamt();
         
      Hauptsystem.reihe.clear();
      Hauptsystem.reihe_gegner.clear();
     
      Hauptsystem.kopf.setX(4);
      Hauptsystem.kopf.setX(5);
      
      Hauptsystem.kopf_gegner.setX(4);
      Hauptsystem.kopf_gegner.setX(5);
     }
         
        else if(Statistik.endgültigGewonnen_gegner() == true) {
         
             try { Thread.sleep(5000);}catch(InterruptedException e) {
         
                 
      Hauptsystem.reihe.clear();
      Hauptsystem.reihe_gegner.clear();
     
      Hauptsystem.kopf.setX(4);
      Hauptsystem.kopf.setX(5);
      
      Hauptsystem.kopf_gegner.setX(4);
      Hauptsystem.kopf_gegner.setX(5);
         }
             
    if(Statistik.Punkte == 7) {
            
            Statistik.RundenGewonnen++;
            Hauptsystem.reihe.clear();
            
            Hauptsystem.kopf.setX(4);
            Hauptsystem.kopf.setX(5);
            
            Hauptsystem.kopf_gegner.setX(4);
            Hauptsystem.kopf_gegner.setX(5);
            Statistik.Punkte = 0;
        
        }         
    else if(Statistik.Punkte_Gegner == 7) {
        
      Statistik.RundenGewonnen_gegner++;
      Hauptsystem.reihe_gegner.clear();
      
      Hauptsystem.kopf_gegner.setX(4);
      Hauptsystem.kopf_gegner.setX(5);
      
      Hauptsystem.kopf_gegner.setX(4);
      Hauptsystem.kopf_gegner.setX(5);
      
      Statistik.Punkte_Gegner = 0;
      
        }           
         Statistik.RundenGewonnen_gegner = 0;
         Statistik.insgesamt_gegner();
         }
     Hauptsystem.ReiheZufuegen_Gegner();
     Kollidation_Gegner.KollidationEssen_gegner();
     
    
     Hauptsystem.bewegen_gegner();
      
      
      
      
      
     Kollidation_Gegner.WandKollidation_gegner();
     Kollidation_Gegner.KollidationSelf_gegner();
    
    }while (h == 1);
    }
    
}
