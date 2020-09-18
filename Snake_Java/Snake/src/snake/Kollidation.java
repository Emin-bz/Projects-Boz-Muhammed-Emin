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
public class Kollidation {
    
    
    // Wand Kollidation
    
    public static void WandKollidation () {
    
        if(Hauptsystem.kopf.getX() > 9 || Hauptsystem.kopf.getY() > 10 || Hauptsystem.kopf.getX() < -1 || Hauptsystem.kopf.getY() < 2) {
    
        Hauptsystem.resetKopfWand();
        Hauptsystem.reihe.clear();
        
        Hauptsystem.kopf.setRichtung(Steuerung.RIGHT);
        
        Statistik.Punkte = 0;
        
        Statistik.addGewonnenRunden_Gegner();
        
    
    }
    }
    
    
    public static boolean EssenKollidation () {
    
    if (Hauptsystem.essen.getX() == Hauptsystem.kopf.getX() && Hauptsystem.essen.getY() == Hauptsystem.kopf.getY()) {
        
        Hauptsystem.resetEssenKollidation();
        
        Hauptsystem.createReihe();
        
    return true;
    
    }
    
    return false;
    
    
    } }
    

