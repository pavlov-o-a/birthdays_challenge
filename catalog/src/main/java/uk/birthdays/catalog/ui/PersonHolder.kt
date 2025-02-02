package uk.birthdays.catalog.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uk.birthdays.catalog.R
import uk.birthdays.core.entities.app.Person

class PersonHolder(parent: ViewGroup):
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.holder_person, parent, false)) {

    //todo add date transformation
    fun bind(person: Person){
        itemView.findViewById<TextView>(R.id.nameTV).text = person.getFullName()
        itemView.findViewById<TextView>(R.id.birthdayTV).text = person.getShortBirthday()
        itemView.findViewById<TextView>(R.id.avatarTV).text = person.getInitials()
    }
}