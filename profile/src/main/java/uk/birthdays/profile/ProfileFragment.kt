package uk.birthdays.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.layout_profile.*
import uk.birthdays.core.Constants.PERSON_EXTRA
import uk.birthdays.core.entities.app.Person

class ProfileFragment(): Fragment(R.layout.layout_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getSerializable(PERSON_EXTRA)?.let {
            fillUi(it as Person)
        }
    }

    private fun fillUi(person: Person){
        avatarTV.text = person.getInitials()
        nameTV.text = person.getFullName()
        ageTV.text = person.birthday
        backButton.setOnClickListener { findNavController().navigateUp() }
    }
}