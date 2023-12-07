package dti.g55.wordle

/**
 * Un mot mystère de type Wordle
 *
 * @param motCherché doit comporter exactement 5 lettres dans l'interval A-Z
 *
 * @throws IllegalArgumentException si le mot cherché ne comporte pas exactement 5 caractères
 */
class Wordle( motCherché : String ) {
	// Le mot cherché
	val motCherché : String = ""

	companion object {
		var validateur = { lettres : Array<Int> -> lettres.count{ it == 2 } == 5 }
	}

	// L'état de l'ensemble des lettres possibles
	val lettres = Array<Int>( 26 ){ 0 }
	
	/**
	 * Retourne l'état des 26 lettres, représentées chacune par un caractère
	 *
	 * L'astérisque (*) représente une lettre dont l'état n'est pas encore connue
	 * Un souligné (_) représente une lettre absente du mot
	 * Une minuscule représente une lettre présente dans le mot dont la position est inconnue
	 * Une majuscule représente une lettre présente dans le mot dont la position est connue
	 *
	 * @return L'état des 26 lettres sous forme de chaîne
	 *
	 * @throws IllegalArgumentException si une lettre est dans un état illégal
	 */
	fun obtenirLettres() {
	}

	/**
	 * Permet d'effectuer un essai
	 *
	 * @param essai Le nouveau mot essayé
	 *
	 * @return Le résultat de l'essai sous forme d'une chaîne de 5 caractères
	 *         selon les mêmes critères que pour obtenirLettres
	 *
	 * @throws IllegalArgumentException si le mot essayé ne comporte pas exactement 5 caractères
	 */
	fun essayer() {
	}

	/**
	 * Retourne Vrai si le mot a été trouvé
	 *
	 * @return Vrai si et seulement si toutes les lettres du mot cherché ont été trouvées
	 */
	fun estRéussi() : Boolean {
		return validateur( lettres )
	}

}
