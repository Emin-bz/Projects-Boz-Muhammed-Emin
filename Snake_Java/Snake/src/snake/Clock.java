/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;
import Gui.Draw;
import snake.Hauptsystem;

/**
 *
 * @author Muhammed Emin Boz
 */

//Die Idee, einen weiteren Thread zu benutzen, habe ich aus dem Internet übernommen.
public class Clock extends Thread {
    
    int h = 1;
    public static boolean cooldown_set = false;
    public static boolean cooldown_go = false;
    
    public static boolean after_cooldown_set = false;
    public static boolean after_cooldown_go = false;
    
    public void run () {
      
        cooldown_set = true;
        try {
        Thread.sleep(3000);
        cooldown_set = false;
      } catch(InterruptedException e) {}
        
        cooldown_go = true;
        try {
        Thread.sleep(500);
        cooldown_go = false;
      } catch(InterruptedException e) {}
        
        
        while(h == 1) {
            
            cooldown_set = false;
         
         try { Thread.sleep(150);}catch(InterruptedException e) {
         
         }
         
          if(Statistik.endgültigGewonnen() == true || 
             Statistik.endgültigGewonnen_gegner() == true) {
         
              
              try {
              
              Thread.sleep(5000);
             
          
          } catch(InterruptedException ex) {}
              
         
              
              
              
              
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
