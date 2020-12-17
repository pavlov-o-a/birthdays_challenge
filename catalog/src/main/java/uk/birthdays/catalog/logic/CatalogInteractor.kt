package uk.birthdays.catalog.logic

import uk.birthdays.core.NetworkManager
import uk.birthdays.core.entities.app.Person

class CatalogInteractor(private val networkManager: NetworkManager) {
    private val catalogApi = networkManager.getService(CatalogApi::class.java)

    suspend fun getPersons(): List<Person> {
        //todo add mapping to ApiEntitiesMapper. make mapping safe
        return catalogApi.getPersons().run {
            this.results.map { Person(it.name.first, it.name.last, it.dob.date) }
        }
    }
}