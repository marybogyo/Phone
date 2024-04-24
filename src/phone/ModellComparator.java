
package phone;

import java.util.Comparator;

public class ModellComparator implements Comparator<OkosTelefon>{


    @Override
    public int compare(OkosTelefon egyik, OkosTelefon masik) {
        return egyik.getModell().compareTo(masik.getModell());
    }
    
}
