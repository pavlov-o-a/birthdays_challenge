package uk.birthdays.catalog.logic

import kotlinx.coroutines.delay
import kotlinx.coroutines.supervisorScope
import uk.birthdays.core.NetworkManager
import uk.birthdays.core.entities.app.Person

//todo inject networkManager with DI
class CatalogManager(private val interactor: CatalogInteractor = CatalogInteractor(NetworkManager())) {

    suspend fun getPersons(): List<Person>{
        var list = listOf<Person>()
        supervisorScope {
            try {
                delay(500)
                //ask from network
                //todo if successful save to local db
                list = interactor.getPersons()
            } catch (exc: Exception){
                exc.printStackTrace()
                //todo try to get from local db
                list = getDummyList()
            }
        }
        return list
    }

    private suspend fun getDummyList(): List<Person>{
        delay(500)
        val persons = mutableListOf<Person>()
        repeat(30){
            persons.add(Person(IntRange(65,90).random().toChar().toString(),  IntRange(65,90).random().toChar().toString(),  IntRange(0,100).random().toString()))
        }
        return persons
    }
}