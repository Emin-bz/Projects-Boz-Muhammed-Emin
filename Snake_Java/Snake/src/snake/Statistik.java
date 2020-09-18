/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author Muhammed Emin Boz
 */
public class Statistik {
    
    public static int Punkte = 0;
    public static int Rekord = 0;
    public static int RundenGewonnen = 0;
     public static int Insgesamt = 0;
    
    public static int Punkte_Gegner = 0;
    public static int Rekord_Gegner = 0;
    public static int RundenGewonnen_gegner = 0;
     public static int Insgesamt_gegner = 0;
    
    public static void addPunkte () {
        
        Punkte++;
    
    }
    
    
     public static void addRekord () {
         
         if (Punkte > Rekord) {
         
             Rekord++;
             
         }
    
    }
     
     
      public static void addGewonnenRunde () {
          
        RundenGewonnen++;  
    
    }
      
      
  public static void addPunkte_Gegner () {
          
        Punkte_Gegner++;
    
    }

  
    public static void addRekord_Gegner () {
          
          if (Punkte_Gegner > Rekord_Gegner) {
              
        Rekord_Gegner++; 
          }
    
    }
         
    
    public static void addGewonnenRunden_Gegner () {
          
        RundenGewonnen_gegner++;  
    
    }
    
    public static void insgesamt () {
          
        Insgesamt++;  
    
    }
    public static void insgesamt_gegner () {
          
        Insgesamt_gegner++;  
    
    }
    
    
    
    
    public static boolean endgültigGewonnen () {
    
    if(RundenGewonnen == 5) {
    
    return true;
    
    
    }
    
    return false;
    
    }
    
        public static boolean endgültigGewonnen_gegner () {
    
    if(RundenGewonnen_gegner == 5) {
    
    return true;
    
    
    
    
    }
    
    return false;
    
    }
   
    
}
