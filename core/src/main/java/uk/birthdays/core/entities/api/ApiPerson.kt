package uk.birthdays.core.entities.api

data class ApiPerson(private val _name: String?, private val _birthday: String?){
    val name get() = _name?: ""
    val birthday get() = _birthday?: ""
}