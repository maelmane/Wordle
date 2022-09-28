package dti.g55.wordle

class Wordle( motCherché : String ) {
	// Longueur du mot cherché et des essais
	val LONGUEUR_MOT = 5

	// Les états possibles pour une lettre

	// La lettre n'a pas encore été essayée
	val ÉTAT_INCONNUE = 0
	// La lettre n'est pas dans le mot
	val ÉTAT_ABSENTE = 1
	// La lettre dans le mot, sa position est connue
	val ÉTAT_CORRECTE = 2
	// La lettre dans le mot, sa position est inconnue
	val ÉTAT_PRÉSENTE = 3

	val motCherché : String = ""
	val lettres = Array<Int>( 26 ){ 0 }
	
	fun estRéussi() : Boolean {
		return lettres.count { it == ÉTAT_CORRECTE } == LONGUEUR_MOT
	}

}
