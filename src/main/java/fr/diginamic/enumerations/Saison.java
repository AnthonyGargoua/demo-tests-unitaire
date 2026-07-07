package fr.diginamic.enumerations;
/**
 * Représente une saison et fournit les 4 instances de saisons.
 * 
 * @author DIGINAMIC
 *
 */
public enum Saison {

	/** Les 4 instances de Saison */
	PRINTEMPS("Printemps", 1), ETE("Eté", 2), AUTOMNE("Automne", 3), HIVER("Hiver", 4);

	/** libelle */
	private String libelle;
	/** ordre */
	private int ordre;

	/**
	 * Constructeur
	 * 
	 * @param libelle libellé
	 * @param ordre   ordre
	 */
	private Saison(String libelle, int ordre) {
		this.libelle = libelle;
		this.ordre = ordre;
	}

	/**
	 * Permet de rechercher une Saison à partir de son libellé
	 * 
	 * @param libelle libellé
	 * @return {@link Saison}
	 */
//	public static Saison valueOfLibelle(String libelle) {
//		Saison[] saisons = Saison.values();
//		for (Saison saison : saisons) {
//			if (libelle.equals(saison.getLibelle())) {
//				return saison;
//			}
//			else {
//				return null;
//			}
//		}
//		return null;
//	}

	// Nouvelle méthode valueOfLibelle
	public static Saison valueOfLibelle(String libelle) {
		// Cas aux limites : Si le libellé fourni est null, on évite le crash et on retourne null directement
		if (libelle == null) {
			return null;
		}

		Saison[] saisons = Saison.values();
		for (Saison saison : saisons) {
			// Cas nominal : On compare
			if (libelle.equals(saison.getLibelle())) { // Methode cas d'école a connaître : algorithme type
				return saison; // Trouvé ! On arrête la méthode ici en retournant la saison
			}
		}

		// On a parcouru TOUTES les saisons et on n'a rien trouvé (ex: "Toto")
		return null;
	}

	@Override
	public String toString() {
		return ordre + ". " + libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the ordre
	 */
	public int getOrdre() {
		return ordre;
	}
}