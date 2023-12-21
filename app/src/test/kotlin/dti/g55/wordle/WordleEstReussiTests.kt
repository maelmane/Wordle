package dti.g55.wordle

import kotlin.test.Test
import kotlin.test.*;
class WordleEstReussiTests {

    @Test
    fun `Étant donné le mot «RICHE» et l'essaie «COEUR», lorsqu'on vérifie si le wordle est réussi, on obtient false`(){
        val cobaye = Wordle("RICHE")

        cobaye.essayer("COEUR")

        assertEquals(false, cobaye.estRéussi())
    }

    @Test
    fun `Étant donné le mot «RICHE» et l'essaie «RICHE», lorsqu'on vérifie si le wordle est réussi, on obtient true`(){
        val cobaye = Wordle("RICHE")

        cobaye.essayer("RICHE")

        assertEquals(true, cobaye.estRéussi())
    }

    @Test
    fun `Étant donné le mot «RICHE» et l'essaie «riche» en minuscule, lorsqu'on vérifie si le wordle est réussi, on obtient true`(){
        val cobaye = Wordle("RICHE")

        cobaye.essayer("RICHE")

        assertEquals(true, cobaye.estRéussi())
    }
}