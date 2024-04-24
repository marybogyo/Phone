
package phone;


public class Telefon implements ITelefon{
    protected String telefonszam;
    protected boolean isHivasbanVan;
    protected Telefon telefonHivas;

    public String getTelefonszam() {
        return telefonszam;
    }

    public boolean getIsHivasbanVan() {
        return isHivasbanVan;
    }

    public void setIsHivasbanVan(boolean isHivasbanVan) {
        this.isHivasbanVan = isHivasbanVan;
    }

    public void setTelefonHivas(Telefon telefonHivas) {
        this.telefonHivas = telefonHivas;
    }


    public void Hiv(Telefon telefon) {
       if(isHivasbanVan == true || telefon.getIsHivasbanVan() == true){
           System.out.println("Valamelyik fél hívásabn van");
     
       }
       if (isHivasbanVan == false && telefon.getIsHivasbanVan() == false){
           isHivasbanVan = true;
           telefon.setIsHivasbanVan(true);
           telefonHivas = telefon;
           telefon.setTelefonHivas(this);
           System.out.println("Hívás létrejött a két telefonszám között");
       }
       
    }

    public void Lerak() 
    {
        if(telefonHivas == null){
            System.out.println("A telefon nincs hívásban");
        }
        if(telefonHivas != null){
            System.out.println("A hívás bontva lett ");
           telefonHivas.setTelefonHivas(null);
           telefonHivas.setIsHivasbanVan(false);
            this.isHivasbanVan = false;
            this.telefonHivas = null;
            
        }
 
        
       
    }

    public Telefon(String telefonszam) {
        this.telefonszam = telefonszam;
        this.isHivasbanVan = false;
        this.telefonHivas = null;
    }

    
}
