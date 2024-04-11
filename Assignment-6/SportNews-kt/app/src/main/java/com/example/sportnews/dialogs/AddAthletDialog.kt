package com.example.sportnews.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.sportnews.R
import com.example.sportnews.fragments.AthletsFragment
import com.example.sportnews.models.Athlet

class AddAthletDialog(private val context: Context, val aFragment: AthletsFragment): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val layout = inflater.inflate(R.layout.add_athlet_dialog, null)

            val athletName = layout.findViewById<EditText>(R.id.etAthletDialogName)
            val athletSport = layout.findViewById<EditText>(R.id.etAthletDialogSportName)
            val athletCountry = layout.findViewById<EditText>(R.id.etAthletDialogCountry)
            val athletBest = layout.findViewById<EditText>(R.id.etAthletDialogPersonalBest)
            val athletMedals = layout.findViewById<EditText>(R.id.etAthletDialogNumberOfMedals)
            val athletFact = layout.findViewById<EditText>(R.id.etAthletDialogFacts)

            builder.setView(layout)
                .setPositiveButton("Add") { dialog, id ->
                    val newAthlet = Athlet(
                        athletName.text.toString(),
                        athletSport.text.toString(),
                        athletCountry.text.toString(),
                        athletBest.text.toString(),
                        athletMedals.text.toString().toInt(),
                        athletFact.text.toString()
                    )
                    aFragment.addNewSport(newAthlet)
                }
                .setNegativeButton("Cancel") { dialog, id ->
                    Toast.makeText(context, "Cancel Add Sport", Toast.LENGTH_SHORT).show()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}