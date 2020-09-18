
package parkhaus;

public class Parkhaus {

    static Leitsystem mySystem = new Leitsystem();
    
    public static void main(String[] args) {
      
     
       char eingabe;
       
       do { 
           eingabe = Display();
           
           MenuExe(eingabe);
       }
       while (eingabe != 'x');
       

       
    }
    
       public static char Display () {
       
       for (int i = 0; i <30; i++) {
       System.out.println();
       }
       
       System.out.println(mySystem.getMenu());
       return Scanner.readChar();
       
       }
           
           public static void MenuExe (char Key) {
           
           int key;
           
           switch (Key) {
           
               case 'e':
                   mySystem.Einfahrt();
                   break;
               case 'a':
                   System.out.println("Mit welchem Ticket soll ausgefahren werden?");
                   key = Scanner.readInt();
                   mySystem.Ausfahrt(key);
                   break;
               case 'z':
                   System.out.println("Welches Ticket soll bezahlt werden");
                   key = Scanner.readInt();
                   mySystem.Zahlen(key);
               case 's':
                  System.out.println(mySystem);
                  System.out.println("...B i t t e   e i n e   T a s t e   D r ü c k e n...");
                  new java.util.Scanner(System.in).nextLine();
                  break;
           }
               
           }
    
}
