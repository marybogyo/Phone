
package phone;


public class OkosTelefon extends Telefon implements IBloototh{
    
    String modell;
    Gyarto gyarto;
    

    public Gyarto getGyarto() {
        return gyarto;
    }

    public String getModell() {
        return modell;
    }
    
    public enum Gyarto{
        APPLE, SAMSUNG, HUAWEI, GOOGLE
    }

    public OkosTelefon(String modell, Gyarto gyarto, String telefonszam) {
        super(telefonszam);
        this.modell = modell;
        this.gyarto = gyarto;
    }
    
    @Override
 public void BluetoothCsatlakozas(OkosTelefon okostelefon) throws BluetoothCsatlakozasException
 {
     if(gyarto == Gyarto.APPLE || okostelefon.getGyarto() == Gyarto.APPLE){
        if(gyarto != Gyarto.APPLE || okostelefon.getGyarto() != Gyarto.APPLE){
            throw new BluetoothCsatlakozasException("Nem lehet a két telefont összekapcsolni");
        }
        
     }
     System.out.println("A kapcsolat rendben létrejött");
 }
    
}
