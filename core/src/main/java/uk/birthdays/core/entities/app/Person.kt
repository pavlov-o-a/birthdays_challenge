package uk.birthdays.core.entities.app

import java.io.Serializable
import java.util.*

data class Person(val first: String, val last: String, val birthday: String): Serializable{
    fun getInitials(): String {
        return (first.firstOrNull()?.toString()?:"") + last.firstOrNull()?.toString()
    }

    fun getFullName(): String {
        return "$first $last"
    }

    fun getAge(): String {
        //parseDate()
        return birthday
    }

    fun getShortBirthday(): String {
        //parseDate()
        return birthday
    }

    fun parseDate(): Date {
        //todo parse date with SimpleDateFormat from birthday
        return Date()
    }
}