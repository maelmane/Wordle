package dti.g55.wordle

class Wordle( motCherché : String ) {
	val motCherché : String = ""
	val lettres = Array<Int>( 26 ){ 0 }
	
	fun estRéussi() : Boolean {
		return lettres.count { it == 2 } == 5
	}

}
