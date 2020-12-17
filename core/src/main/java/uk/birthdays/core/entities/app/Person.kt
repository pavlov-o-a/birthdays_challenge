package uk.birthdays.core.entities.app

import java.io.Serializable

data class Person(val first: String, val last: String, val birthday: String): Serializable{
    fun getInitials(): String {
        return (first.firstOrNull()?.toString()?:"") + last.firstOrNull()?.toString()
    }
    fun getFullName(): String {
        return "$first $last"
    }
}