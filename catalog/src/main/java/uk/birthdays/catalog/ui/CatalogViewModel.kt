package uk.birthdays.catalog.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uk.birthdays.catalog.logic.CatalogManager
import uk.birthdays.core.entities.Person

class CatalogViewModel: ViewModel() {
    private val persons = MutableLiveData<List<Person>>()
    private val loading = MutableLiveData<Boolean>()
    //inject with DI
    private val catalogManager = CatalogManager()
    
    fun loadPersons(){
        if (persons.value.isNullOrEmpty()){
            viewModelScope.launch {
                loading.value = true
                persons.value = withContext(Dispatchers.IO) { catalogManager.getPersons() }
                loading.value = false
            }
        }
    }
    
    fun getPersons(): LiveData<List<Person>> = persons
    fun getLoadingListener(): LiveData<Boolean> = loading
}