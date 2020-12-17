package uk.birthdays.catalog.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uk.birthdays.core.entities.Person

class PersonsAdapter(private var items: List<Person> = listOf()): RecyclerView.Adapter<PersonHolder>() {

    fun update(items: List<Person>){
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        return PersonHolder(parent)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}