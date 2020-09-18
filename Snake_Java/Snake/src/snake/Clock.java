/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;
import snake.Hauptsystem;

/**
 *
 * @author Muhammed Emin Boz
 */

//Die Idee, einen weiteren Thread zu benutzen, habe ich aus dem Internet übernommen.
public class Clock extends Thread {
    
    int h = 1;
    
    public void run () {
     
        while(h == 1) {
         
         try { Thread.sleep(150);}catch(InterruptedException e) {
         
         }
         
          if(Statistik.endgültigGewonnen() == true || 
             Statistik.endgültigGewonnen_gegner() == true) {
          try { Thread.sleep(5000);}catch(InterruptedException e) {
         
         }
     Statistik.RundenGewonnen = 0;
         Statistik.RundenGewonnen_gegner = 0;
     }
    
    Kollidation.EssenKollidation();
         
    Hauptsystem.ReiheZufuegen();
    Hauptsystem.bewegen();
    Kollidation.WandKollidation();
    
   
    
    
    
    Hauptsystem.ResetReihe();
    
     if (Kollidation.EssenKollidation() == true) {
    
          Statistik.addPunkte();
          Statistik.addRekord();
            }
     
     

    
        }
        
    }
    
}
