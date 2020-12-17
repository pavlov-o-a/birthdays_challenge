package uk.birthdays.catalog

import kotlinx.coroutines.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.Mockito
import uk.birthdays.catalog.logic.CatalogInteractor
import uk.birthdays.catalog.logic.CatalogManager

@ExperimentalCoroutinesApi
class CatalogManagerTest {

    @Test
    fun testGetPersons(){
        val interactor = Mockito.mock(CatalogInteractor::class.java)
        val catalogManager = CatalogManager(interactor)
        runBlockingTest {
            Mockito.`when`(interactor.getPersons()).thenReturn(listOf())
            catalogManager.getPersons()
            Mockito.verify(interactor).getPersons()
        }
    }
}