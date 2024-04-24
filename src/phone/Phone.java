
package phone;

import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Phone {

   
    public static void main(String[] args) {
     List<Telefon> telefonok = new ArrayList<>();
     telefonok.add(new HagyomanyosTelefon("+361789458"));
     telefonok.add(new OkosTelefon("11 pro", OkosTelefon.Gyarto.APPLE, "+36204567894"));
     telefonok.add(new OkosTelefon("13 pro", OkosTelefon.Gyarto.APPLE, "+36304567894"));
     telefonok.add(new OkosTelefon("a51", OkosTelefon.Gyarto.SAMSUNG, "+36204222894"));
     telefonok.add(new OkosTelefon("13", OkosTelefon.Gyarto.GOOGLE, "+36704561114"));
     telefonok.add(new HagyomanyosTelefon("+361321654"));
    
    Telefon tel0 = telefonok.get(0);
    Telefon tel3 = telefonok.get(3);
    Telefon tel4 = telefonok.get(4);
    OkosTelefon tel2 = (OkosTelefon)telefonok.get(2);
    tel0.Hiv(tel3);
    tel4.Hiv(tel3);
    tel3.Lerak();
    
        for (Telefon telefon : telefonok) {
            if(telefon instanceof OkosTelefon oktel && !oktel.getModell().equals(tel2.getModell())){
                try {
                    oktel.BluetoothCsatlakozas(tel2);
                } catch (BluetoothCsatlakozasException bluetoothCsatlakozasException) {
                    System.out.println(bluetoothCsatlakozasException.getMessage());
                }
            }
        }
        
        List<OkosTelefon> okostelefonok = new ArrayList<>();
        for (Telefon telefon : telefonok) {
            if (telefon instanceof OkosTelefon okostel){
                okostelefonok.add(okostel);
            }
        }
        
        Collections.sort(okostelefonok, new ModellComparator());
        
        String adatok = "";
        for (OkosTelefon okosTelefon : okostelefonok) {
            adatok += okosTelefon.getTelefonszam();
            adatok += " ";
            adatok += okosTelefon.getModell();
            adatok += "\n";
        }
        Path path = Paths.get("fajl.txt");
        
        try {
            Files.write(path, adatok.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Phone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
