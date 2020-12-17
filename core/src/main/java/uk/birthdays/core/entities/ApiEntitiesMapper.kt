package uk.birthdays.core.entities

import uk.birthdays.core.entities.api.ApiPerson
import uk.birthdays.core.entities.app.Person

object ApiEntitiesMapper {

    fun ApiPerson.toApp() = Person(first, last, birthday)
}