package uk.birthdays.catalog.logic

import uk.birthdays.core.entities.ApiEntitiesMapper.toApp
import uk.birthdays.core.entities.NetworkManager
import uk.birthdays.core.entities.app.Person

class CatalogInteractor(private val networkManager: NetworkManager) {
    private val catalogApi = networkManager.getService(CatalogApi::class.java)

    suspend fun getPersons(): List<Person> {
        return catalogApi.getPersons().run {
            this.results.map { Person(it.name.first + " " + it.name.last, it.dob.date) }
        }
    }
}