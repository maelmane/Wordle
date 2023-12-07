package dti.g55.wordle

import kotlin.test.Test
import kotlin.test.*;

class WordleEssayerTests {

	@Test
	fun `Étant donné le mot «CORDE», lorsquon essaie «ABCDE», on obtient «__cDE»`(){
		val cobaye = Wordle("CORDE")

		assertEquals( "__cDE", cobaye.essayer("ABCDE") )
	}
	
	@Test
	fun `Étant donné le mot «CORDE», lorsquon essaie «COEUR», on obtient «COe_r»`(){
		val cobaye = Wordle("CORDE")

		assertEquals( "COe_r", cobaye.essayer("COEUR") )		
	}

	@Test
	fun `Étant donné le mot «CORDE», lorsquon essaie «CORDE», on obtient «CORDE»`(){
		val cobaye = Wordle("CORDE")

		assertEquals( "CORDE", cobaye.essayer("CORDE") )		
	}
		
	@Test
	fun `Étant donné le mot «CORDE», lorsqu'on essaye le bon mot avec des minuscules, on obtient la bonne réponse en majuscules`(){
		val cobaye = Wordle("CORDE")

		val résultat_obtenu = cobaye.essayer("corde")

		assertEquals( "CORDE", résultat_obtenu )
	}

	@Test
	fun `Étant donné le mot «ABCDE», lorsqu'on essaye un mot de 3 lettres, on obtient une exception`(){
		try{
			val cobaye = Wordle("ABCDE")
			cobaye.essayer("abc")
			fail()
		}
		catch(e : IllegalArgumentException){
			assertEquals( "L'essai doit comporter exactement 5 lettres [A-Z]", e.message )
		}
	}

	@Test
	fun `Étant donné le mot «ABCDE», lorsqu'on essaye un mot de 6 lettres, on obtient une exception`(){
		try{
			val cobaye = Wordle("ABCDE")
			cobaye.essayer("abcdef")
			fail()
		}
		catch(e : IllegalArgumentException){
			assertEquals( "L'essai doit comporter exactement 5 lettres [A-Z]", e.message )
		}
	}

	@Test
	fun `Étant donné le mot «ABCDE», lorsqu'on essaye un mot comportant des caractères illégaux, on obtient une exception`(){
		try{
			val cobaye = Wordle("ABCDE")
			cobaye.essayer("étale")
			fail()
		}
		catch(e : IllegalArgumentException){
			assertEquals( "L'essai doit comporter exactement 5 lettres [A-Z]", e.message )
		}
	}
	
}
