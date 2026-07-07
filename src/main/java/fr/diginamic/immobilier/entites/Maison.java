package fr.diginamic.immobilier.entites;
/** Représente une maison avec toutes ses pièces
 * @author DIGINAMIC
 *
 */
public class Maison {

	/** pieces : tableau de pièces de la maison */
	private Piece[] pieces;

	/**
	 * Constructeur
	 */
	public Maison(){
		// Initialisation du tableau de pièces
		pieces = new Piece[0];
	}

	/** Ajoute une pièce à la maison
	 * @param nvPiece nouvelle pièce à ajouter
	 */
	public void ajouterPiece(Piece nvPiece) {
		// --- MODIFICATION 1 (ROBUSTESSE) ---
		// On ajoute cette sécurité pour ignorer la pièce si elle est null (évite les NullPointerException plus tard)
		if (nvPiece == null) {
			return;
		}
		// ------------------------------------

		// On est obligé d'agrandir le tableau initial de 1 à chaque ajout
		// d'une nouvelle pièce

		// On commence donc par créer un tableau temporaire appelé newTab
		// qui a une taille égale à la tableau du tableau pieces+1
		Piece[] newTab = new Piece[pieces.length+1];

		// On déverse toutes les pièces du tableau pieces dans newTab
		for (int i=0; i<pieces.length; i++){
			newTab[i]=pieces[i];
		}

		// On place en dernière position dans le nouveau tableau la nouvelle
		// pièce
		newTab[newTab.length-1]=nvPiece;

		// Enfin on affecte newTab à pieces
		this.pieces=newTab;
	}

	public int nbPieces() {
		// --- MODIFICATION 2 (BUG) ---
		// On remplace "return pieces.length-1;" par la vraie longueur du tableau
		return pieces.length;
	}

	/** Retourne la superficie d'un étage
	 * @param choixEtage choix de l'étage
	 * @return double
	 */
	public double superficieEtage(int choixEtage) {
		double superficieEtage = 0;

		for (int i = 0; i < pieces.length; i++) {
			if (choixEtage == this.pieces[i].getNumEtage()) {
				// --- MODIFICATION 3 (BUG) ---
				// On remplace "=" par "+=" pour additionner les pièces au lieu de les écraser
				superficieEtage += this.pieces[i].getSuperficie();
			}
		}

		return superficieEtage;
	}

	/** Retourne la superficie total pour un type de pièce donné
	 * @param typePiece type de pièce
	 * @return double
	 */
	public double superficieTypePiece(String typePiece) {
		double superficie = 0;

		// --- MODIFICATION 4 (BUG) ---
		// On remplace "int i = 1" par "int i = 0" pour ne pas rater la première pièce du tableau (ton salon !)
		for (int i = 0; i < pieces.length; i++) {
			if (typePiece!=null && typePiece.equals(this.pieces[i].getType())) {
				superficie = superficie + this.pieces[i].getSuperficie();
			}
		}

		return superficie;
	}

	/** Retourne la surface totale
	 * @return double
	 */
	public double calculerSurface() {
		double superficieTot = 0;

		for (int i = 0; i < pieces.length; i++) {
			superficieTot = superficieTot + this.pieces[i].getSuperficie();
		}

		return superficieTot;
	}

	/** Getter pour l'attribut pieces
	 * @return the pieces
	 */
	public Piece[] getPieces() {
		return pieces;
	}

}


//package fr.diginamic.immobilier.entites;
///** Représente une maison avec toutes ses pièces
// * @author DIGINAMIC
// *
// */
//public class Maison {
//
//	/** pieces : tableau de pièces de la maison */
//	private Piece[] pieces;
//
//	/**
//	 * Constructeur
//	 */
//	public Maison(){
//		// Initialisation du tableau de pièces
//		pieces = new Piece[0];
//	}
//
//	/** Ajoute une pièce à la maison
//	 * @param nvPiece nouvelle pièce à ajouter
//	 */
//	public void ajouterPiece(Piece nvPiece) {
//
//		// On est obligé d'agrandir le tableau initial de 1 à chaque ajout
//		// d'une nouvelle pièce
//
//		// On commence donc par créer un tableau temporaire appelé newTab
//		// qui a une taille égale à la tableau du tableau pieces+1
//		Piece[] newTab = new Piece[pieces.length+1];
//
//		// On déverse toutes les pièces du tableau pieces dans newTab
//		for (int i=0; i<pieces.length; i++){
//			newTab[i]=pieces[i];
//		}
//
//		// On place en dernière position dans le nouveau tableau la nouvelle
//		// pièce
//		newTab[newTab.length-1]=nvPiece;
//
//		// Enfin on affecte newTab à pieces
//		this.pieces=newTab;
//	}
//
//	public int nbPieces() {
//		return pieces.length-1;
//	}
//
//	/** Retourne la superficie d'un étage
//	 * @param choixEtage choix de l'étage
//	 * @return double
//	 */
//	public double superficieEtage(int choixEtage) {
//		double superficieEtage = 0;
//
//		for (int i = 0; i < pieces.length; i++) {
//			if (choixEtage == this.pieces[i].getNumEtage()) {
//				superficieEtage = this.pieces[i].getSuperficie();
//			}
//		}
//
//		return superficieEtage;
//	}
//
//	/** Retourne la superficie total pour un type de pièce donné
//	 * @param typePiece type de pièce
//	 * @return double
//	 */
//	public double superficieTypePiece(String typePiece) {
//		double superficie = 0;
//
//		for (int i = 1; i < pieces.length; i++) {
//			if (typePiece!=null && typePiece.equals(this.pieces[i].getType())) {
//				superficie = superficie + this.pieces[i].getSuperficie();
//			}
//		}
//
//		return superficie;
//	}
//
//	/** Retourne la surface totale
//	 * @return double
//	 */
//	public double calculerSurface() {
//		double superficieTot = 0;
//
//		for (int i = 0; i < pieces.length; i++) {
//			superficieTot = superficieTot + this.pieces[i].getSuperficie();
//		}
//
//		return superficieTot;
//	}
//
//	/** Getter pour l'attribut pieces
//	 * @return the pieces
//	 */
//	public Piece[] getPieces() {
//		return pieces;
//	}
//
//}