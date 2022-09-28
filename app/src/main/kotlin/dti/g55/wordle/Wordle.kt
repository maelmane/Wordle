package dti.g55.wordle

class Wordle( motCherché : String ) {
	// Le mot cherché
	val motCherché : String = ""

	// L'état de l'ensemble des lettres possibles
	val lettres = Array<Int>( 26 ){ 0 }
	
	/**
	 * Retourne l'état des 26 lettres, représentées chacune par un caractère
	 *
	 * L'astérisque (*) représente une lettre dont l'état n'est pas encore connue
	 * Un souligné (_) représente une lettre absente du mot
	 * Une minuscule représente une lettre présente dans le mot dont la position est inconnue
	 * Une majuscule représente une lettre présente dans le mot dont la position est connue
	 */
	fun obtenirLettres() {
	}

	/**
	 * Permet d'effectuer un essai
	 *
	 * @param Le nouveau mot essayé
	 * @return Le résultat de l'essai sous forme d'une chaîne de 5 caractères
	 *         selon les mêmes critères que pour obtenirLettres
	 */
	fun essayer() {
	}

	/**
	 * Retourne Vrai si le mot a été trouvé
	 *
	 * @return Vrai si et seulement si toutes les lettres du mot cherché ont été trouvées
	 */
	fun estRéussi() : Boolean {
		return lettres.count { it == 2 } == 5
	}

}
