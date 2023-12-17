package dti.g55.wordle

import java.lang.IllegalStateException

/**
 * Un mot mystère de type Wordle
 *
 * @param motCherché doit comporter exactement 5 lettres dans l'interval A-Z
 *
 * @throws IllegalArgumentException si le mot cherché ne comporte pas exactement 5 caractères
 */
class Wordle( motCherché : String ) {
	// Le mot cherché
	var motCherché : String = ""
		private set

	// Longueur du mot cherché et des essais
	val LONGUEUR_MOT = 5
	init {
		if (motCherché.length != LONGUEUR_MOT || !estSeulementDesLettres(motCherché)){
			throw IllegalArgumentException("Le mot cherché doit comporter exactement 5 lettres [A-Z]")
		}

		this.motCherché = motCherché.uppercase()
	}

	companion object {
		var validateur = { lettres : Array<Int> -> lettres.count{ it == 2 } == 5 }
	}

	// L'état de l'ensemble des lettres possibles
	private val lettres = Array<Int>( 26 ){ 0 }



	// Les états possibles pour une lettre

	// La lettre n'a pas encore été essayée
	val ÉTAT_INCONNUE = 0
	// La lettre n'est pas dans le mot
	val ÉTAT_ABSENTE = 1
	// La lettre dans le mot, sa position est connue
	val ÉTAT_CORRECTE = 2
	// La lettre dans le mot, sa position est inconnue
	val ÉTAT_PRÉSENTE = 3
	var état_actuel = 0
	
	/**
	 * Retourne l'état des 26 lettres, représentées chacune par un caractère
	 *
	 * L'astérisque (*) représente une lettre dont l'état n'est pas encore connue
	 * Un souligné (_) représente une lettre absente du mot
	 * Une minuscule représente une lettre présente dans le mot dont la position est inconnue
	 * Une majuscule représente une lettre présente dans le mot dont la position est connue
	 *
	 * @return (String) L'état des 26 lettres sous forme de chaîne
	 *
	 * @throws IllegalStateException si une lettre est dans un état illégal
	 */
	fun obtenirLettres(): String {
		var builder = StringBuilder()
		for (i in 'a' .. 'z'){
			when (état_actuel) {
				ÉTAT_INCONNUE -> builder.append('*')
				ÉTAT_ABSENTE -> builder.append('_')
				ÉTAT_CORRECTE -> builder.append('a')
				ÉTAT_PRÉSENTE -> builder.append('A')
				else -> throw IllegalStateException("La lettre est dans un état illégal")
			}
		}
		return builder.toString()
	}

	/**
	 * Permet d'effectuer un essai
	 *
	 * @param essai (String) Le nouveau mot essayé
	 *
	 * @return (String) Le résultat de l'essai sous forme d'une chaîne de 5 caractères
	 *         selon les mêmes critères que pour obtenirLettres
	 *
	 * @throws IllegalArgumentException si le mot essayé ne comporte pas exactement 5 caractères
	 */
	fun essayer(essai : String): String {
		var builder = StringBuilder()
		if (essai.length == LONGUEUR_MOT && estSeulementDesLettres(essai)){
			for (i in 0 .. 4){
				builder.append('_')
			}
			for (lettre in motCherché.indices) {
				if (motCherché.contains(essai.uppercase()[lettre])){
					builder[lettre] = (essai[lettre]).lowercaseChar()
				}
				if(motCherché[lettre] == essai.uppercase()[lettre]){
					builder[lettre] = essai[lettre].uppercaseChar()
				}
			}
		}
		else {
			throw IllegalArgumentException("L'essai doit comporter exactement 5 lettres [A-Z]")
		}
		return (builder.toString())
	}

	/**
	 * Retourne Vrai si le mot a été trouvé
	 *
	 * @return (Boolean) Vrai si et seulement si toutes les lettres du mot cherché ont été trouvées
	 */
	fun estRéussi() : Boolean {
		return validateur( lettres )
	}

	fun estSeulementDesLettres(mot: String): Boolean {
		val regex = Regex("^[a-zA-Z]*$")
		return regex.matches(mot)
	}
}
