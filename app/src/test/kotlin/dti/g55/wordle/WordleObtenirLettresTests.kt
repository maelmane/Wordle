package dti.g55.wordle

import kotlin.test.Test
import kotlin.test.*;

class WordleObtenirLettresTests {

	@Test
	fun `Étant donné le mot «RICHE», lorsqu'on récupère les lettres, on obtient 26 astérisques`(){
		val cobaye = Wordle("RICHE")

		assertEquals( "**************************", cobaye.obtenirLettres() )
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

		cobaye.essayer("CORDE")
		cobaye.essayer("CODER")
		assertEquals( "**CDE*********O**R********", cobaye.obtenirLettres() )
	}

	@Test
	fun `Étant donné le mot «CORDE», lorsquon essaie un mélange de lettre au bon et au mauvais endroit et qu'on récupère les lettres, on obtient les bonnes majuscules et minuscules`() {
		val cobaye = Wordle("CORDE")

		cobaye.essayer("ROCKS")
		assertEquals( "**c*******_***O**r_*******", cobaye.obtenirLettres() )
	}

}
