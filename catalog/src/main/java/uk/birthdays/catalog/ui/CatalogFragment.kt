package uk.birthdays.catalog.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.layout_catalog.*
import uk.birthdays.catalog.R

class CatalogFragment: Fragment(R.layout.layout_catalog) {
    private val viewModel by viewModels<CatalogViewModel>()
    private lateinit var personsAdapter: PersonsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        personsAdapter = PersonsAdapter()
        personsRV.adapter = personsAdapter

        viewModel.getPersons().observe(viewLifecycleOwner) {
            personsAdapter.update(it)
        }
        viewModel.getLoadingListener().observe(viewLifecycleOwner) {

        }

        viewModel.loadPersons()
    }
}