package parkhaus;
import org.joda.time.*;

public class Ticket {
    
    protected DateTime ausgabe;
    protected DateTime EinfahrtZeit;
    
    protected final double PREIS = 2.50;
    
    
    public Ticket() {
        ausgabe = new DateTime(DateTimeZone.UTC);
        EinfahrtZeit = ausgabe.plusSeconds(10);
    
    }
    
    
    public double getPreis () {
    
        DateTime jetzt = new DateTime(DateTimeZone.UTC);
        int sekunden = Seconds.secondsBetween(EinfahrtZeit, jetzt).getSeconds();
        
        if (sekunden <= 0) 
            return 0;
        
        else 
            return sekunden * PREIS;
    }
    
    
    public void setVerfall () {
    
    DateTime jetzt = new DateTime (DateTimeZone.UTC);
    EinfahrtZeit = jetzt.plusSeconds(10);
    
    }
    
    
     public DateTime getAusgabe () {
    
        return ausgabe;
    }
     
     
     public DateTime getVerfall() {
     
     return EinfahrtZeit;
     }
    
    @Override
    public String toString() {
    
    String s = " ";
    
    s+= "Ausgabe: " + this.ausgabe.toString() + "\t";
    s+= "Verfall: " + this.EinfahrtZeit.toString() + "\t";
    s+= "Preis: " + this.getPreis();
    return s;
    }
    
}
