package uk.birthdays.catalog.logic

import kotlinx.coroutines.delay
import kotlinx.coroutines.supervisorScope
import uk.birthdays.core.entities.NetworkManager
import uk.birthdays.core.entities.app.Person

//inject networkManager with DI
class CatalogManager(networkManager: NetworkManager = NetworkManager()) {
    private val interactor = CatalogInteractor(networkManager)

    suspend fun getPersons(): List<Person>{
        var list = listOf<Person>()
        supervisorScope {
            try {
                delay(500)
                //ask from network
                //if successful save to local db
                list = interactor.getPersons()
            } catch (exc: Exception){
                exc.printStackTrace()
                //try to get from local db
                list = getDummyList()
            }
        }
        return list
    }

    private suspend fun getDummyList(): List<Person>{
        delay(500)
        val persons = mutableListOf<Person>()
        repeat(30){
            persons.add(Person(IntRange(65,90).random().toChar().toString(), IntRange(0,100).random().toString()))
        }
        return persons
    }
}