package uk.birthdays.catalog.logic

import retrofit2.http.GET

interface CatalogApi {
    @GET("api/?results=1000&seed=chalkboard&inc=name,dob")
    suspend fun getPersons(): PersonsAnswer
}

//todo move all classes to core api entities and add mapping
data class PersonDob(val date: String)
data class PersonName(val first: String, val last: String)
data class PersonAnswer(val name: PersonName, val dob: PersonDob)
data class PersonsAnswer(val results: List<PersonAnswer>)