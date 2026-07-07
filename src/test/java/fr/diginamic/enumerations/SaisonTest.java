package fr.diginamic.enumerations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaisonTest {
    @Test
    @DisplayName("valueOfLibelle('Printemps') doit retourner Printemps")
    public void valueOfLibelle_printemps() {
        Saison resultat = Saison.valueOfLibelle("Printemps");
        assertEquals(Saison.PRINTEMPS, resultat);
    }

    @Test
    @DisplayName("valueOfLibelle('Eté') doit retourner Ete")
    public void valueOfLibelle_ete() {
        Saison resultat = Saison.valueOfLibelle("Eté");
        assertEquals(Saison.ETE, resultat);
    }

    @Test
    @DisplayName("valueOfLibelle('Automne') doit retourner Automne")
    public void valueOfLibelle_automne() {
        Saison resultat = Saison.valueOfLibelle("Automne");
        assertEquals(Saison.AUTOMNE, resultat);
    }

    @Test
    @DisplayName("valueOfLibelle('Hiver') doit retourner Hiver")
    public void valueOfLibelle_hiver() {
        Saison resultat = Saison.valueOfLibelle("Hiver");
        assertEquals(Saison.HIVER, resultat);
    }

    // Test de robustesse

    @Test
    @DisplayName("valueOfLibelle avec une valeur nulle doit être robuste et retourner null")
    public void valueOfLibelle_null() {
        Saison resultat = Saison.valueOfLibelle(null);
        assertEquals(null, resultat);
    }

    @Test
    @DisplayName("valueOfLibelle avec un libellé inconnu doit retourner null")
    public void valueOfLibelle_inconnu() {
        Saison resultat = Saison.valueOfLibelle("PrintempsTest");
        assertEquals(null, resultat);
    }
}
