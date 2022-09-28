package dti.g55.wordle

import kotlin.test.Test
import kotlin.test.*;

class WordleTest {

	@Test
	fun `Étant donné le mot «RICHE», lorsqu'on récupère les lettres, on obtient 26 astérisques`(){
		val cobaye = Wordle("RICHE")

		assertEquals( "**************************", cobaye.obtenirLettres() )
	}

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
	fun `Étant donné le mot «CORDE», lorsquon essaie une lettre au bon endroit et qu'on récupère les lettres, on obtient la lettre en majuscule`(){
		val cobaye = Wordle("CORDE")

		cobaye.essayer("CORDE")
		assertEquals( "**CDE*********O**R********", cobaye.obtenirLettres() )
	}
	
	@Test
	fun `Étant donné le mot «CORDE», lorsquon essaie une lettre au mauvais endroit et qu'on récupère les lettres, on obtient la lettre en minuscule`(){
		val cobaye = Wordle("CORDE")

		cobaye.essayer("DECRO")
		assertEquals( "**cde*********o**r********", cobaye.obtenirLettres() )
	}
	
	@Test
	fun `Étant donné le mot «CORDE», lorsquon essaie une lettre au bon endroit puis la même lettre au mauvais endroit et qu'on récupère les lettres, on obtient la lettre en majuscule`() {
		val cobaye = Wordle("CORDE")

		cobaye.essayer("CODER")
		cobaye.essayer("CORDE")
		assertEquals( "**CDE*********O**R********", cobaye.obtenirLettres() )
	}

	@Test
	fun `Étant donné le mot «CORDE», lorsquon essaie un mélange de lettre au bon et au mauvais endroit et qu'on récupère les lettres, on obtient les bonnes majuscules et minuscules`() {
		val cobaye = Wordle("CORDE")

		cobaye.essayer("ROCKS")
		assertEquals( "**c*******_***O**r_*******", cobaye.obtenirLettres() )
	}
	
	@Test
	fun `Étant donné le mot cherché initialisé avec des minuscules, lorsqu'on récupère la propriété, on obtient le mot en majuscules`(){
		val cobaye = Wordle("Corde")

		val résultat_obtenu = cobaye.motCherché

		assertEquals( "CORDE", résultat_obtenu )
	}

	@Test
	fun `Étant donné le mot «CORDE», lorsqu'on essaye le bon mot avec des minuscules, on obtient la bonne réponse en majuscules`(){
		val cobaye = Wordle("CORDE")

		val résultat_obtenu = cobaye.essayer("corde")

		assertEquals( "CORDE", résultat_obtenu )
	}

	@Test
	fun `Étant donné un mot de 3 lettres, lorsqu'on initialise un Wordle, on obtient une exception`(){
		try{
			Wordle("abc")
			fail()
		}
		catch(e : IllegalArgumentException){
			assertEquals( "Le mot cherché doit comporter exactement 5 lettres [A-Z]", e.message )
		}
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
	
}
