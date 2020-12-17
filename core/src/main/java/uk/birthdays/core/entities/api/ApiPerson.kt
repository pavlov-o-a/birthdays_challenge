package uk.birthdays.core.entities.api

data class ApiPerson(private val _first: String?, private val _last: String?, private val _birthday: String?){
    val first get() = _first?: ""
    val last get() = _last?: ""
    val birthday get() = _birthday?: ""
}