package uk.birthdays.catalog.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.layout_catalog.*
import uk.birthdays.catalog.R
import uk.birthdays.core.Constants

class CatalogFragment: Fragment(R.layout.layout_catalog) {
    private val viewModel by viewModels<CatalogViewModel>()
    private lateinit var personsAdapter: PersonsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        personsAdapter = PersonsAdapter({
            val bundle = Bundle()
            bundle.putSerializable(Constants.PERSON_EXTRA, it)
            findNavController().navigate(uk.birthdays.R.id.action_Catalog_to_Profile, bundle)
        })
        personsRV.adapter = personsAdapter

        viewModel.getPersons().observe(viewLifecycleOwner) {
            personsAdapter.update(it)
        }
        viewModel.getLoadingListener().observe(viewLifecycleOwner) {
            catalogProgress.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.loadPersons()
    }
}