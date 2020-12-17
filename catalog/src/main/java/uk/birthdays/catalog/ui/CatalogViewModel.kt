package uk.birthdays.catalog.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uk.birthdays.core.entities.Person

class CatalogViewModel: ViewModel() {
    private val persons = MutableLiveData<List<Person>>()
    private val loading = MutableLiveData<Boolean>()
    
    fun loadPersons(){
        if (persons.value.isNullOrEmpty()){
            viewModelScope.launch {
                loading.value = true
                persons.value = withContext(Dispatchers.IO) { getDummyList() }
                loading.value = false
            }
        }
    }
    
    fun getPersons(): LiveData<List<Person>> = persons
    fun getLoadingListener(): LiveData<Boolean> = loading

    private suspend fun getDummyList(): List<Person>{
        delay(1000)
        val persons = mutableListOf<Person>()
        repeat(30){
            persons.add(Person(IntRange(65,90).random().toChar().toString(), IntRange(0,100).random().toString()))
        }
        return persons
    }
}