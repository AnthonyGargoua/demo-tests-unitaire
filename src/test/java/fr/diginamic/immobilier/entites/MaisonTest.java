package fr.diginamic.immobilier.entites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaisonTest {

    // Le delta pour la précision des variables double
    private static final double DELTA = 0.001;

    private Maison maison;

    @BeforeEach
    public void setUp() {
        maison = new Maison();
        // Attention à l'ordre : (etage, superficie)
        maison.ajouterPiece(new Salon(0, 30.0));     // étage 0, position 0
        maison.ajouterPiece(new Cuisine(0, 15.0));   // étage 0
        maison.ajouterPiece(new Chambre(1, 20.0));   // étage 1
        maison.ajouterPiece(new Chambre(1, 18.0));   // étage 1
    }

    // CAS NOMINAUX

    @Test
    @DisplayName("nbPieces() doit compter toutes les pièces")
    public void nbPieces_compteCorrect() {
        assertEquals(4, maison.nbPieces());
    }

    @Test
    @DisplayName("calculerSurface() doit sommer toutes les superficies")
    public void calculerSurface_sommeTotale() {
        assertEquals(83.0, maison.calculerSurface(), DELTA);   // 30+15+20+18
    }

    @Test
    @DisplayName("superficieEtage(0) doit sommer les pièces du rez-de-chaussée")
    public void superficieEtage_rdc() {
        assertEquals(45.0, maison.superficieEtage(0), DELTA);  // 30+15
    }

    @Test
    @DisplayName("superficieEtage(1) doit sommer les pièces de l'étage 1")
    public void superficieEtage_etage1() {
        assertEquals(38.0, maison.superficieEtage(1), DELTA);  // 20+18
    }

    @Test
    @DisplayName("superficieTypePiece('Chambre') doit sommer toutes les chambres")
    public void superficieTypePiece_chambres() {
        assertEquals(38.0, maison.superficieTypePiece(Piece.TYPE_CHAMBRE), DELTA);
    }

    @Test
    @DisplayName("superficieTypePiece doit compter la pièce en position 0 (le Salon)")
    public void superficieTypePiece_premierePiece() {
        // Le Salon est en position 0 : attrape le bug "boucle qui démarre à i=1"
        assertEquals(30.0, maison.superficieTypePiece(Piece.TYPE_SALON), DELTA);
    }

    // CAS AUX LIMITES / ROBUSTESSE

    @Test
    @DisplayName("Une maison neuve a 0 pièce et 0 de surface")
    public void maisonVide() {
        Maison vide = new Maison();
        assertEquals(0, vide.nbPieces());
        assertEquals(0.0, vide.calculerSurface(), DELTA);
    }

    @Test
    @DisplayName("Un étage inexistant renvoie une superficie de 0")
    public void superficieEtage_etageInexistant() {
        assertEquals(0.0, maison.superficieEtage(99), DELTA);
    }

    @Test
    @DisplayName("Un type de pièce inconnu renvoie 0")
    public void superficieTypePiece_typeInconnu() {
        assertEquals(0.0, maison.superficieTypePiece("Garage"), DELTA);
    }

    @Test
    @DisplayName("superficieTypePiece(null) ne doit pas planter")
    public void superficieTypePiece_null() {
        assertDoesNotThrow(() -> maison.superficieTypePiece(null));
        assertEquals(0.0, maison.superficieTypePiece(null), DELTA);
    }

    @Test
    @DisplayName("ajouterPiece(null) ne doit pas corrompre la maison ni la faire planter")
    public void ajouterPiece_null() {
        int avant = maison.nbPieces();
        maison.ajouterPiece(null);
        assertEquals(avant, maison.nbPieces());
        assertDoesNotThrow(() -> maison.calculerSurface());
    }
}