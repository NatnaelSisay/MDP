package com.example.sportnews.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.sportnews.R
import com.example.sportnews.fragments.AthletsFragment
import com.example.sportnews.models.Athlet
import com.example.sportnews.validators.EmptyFieldValidator

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

            val isNotEmpty = EmptyFieldValidator()

            builder.setView(layout)
                .setPositiveButton("Add") { dialog, id ->
                    var allValid = true
                    val fields = mutableListOf<EditText>(athletName, athletSport, athletCountry, athletBest, athletMedals, athletFact)
                    for (field in fields) {
                        if(!isNotEmpty.validate(field.text.toString())){
                            allValid = false
                        }
                    }

                    if(allValid){
                        val newAthlet = Athlet(
                            athletName.text.toString(),
                            athletSport.text.toString(),
                            athletCountry.text.toString(),
                            athletBest.text.toString(),
                            athletMedals.text.toString().toInt(),
                            athletFact.text.toString()
                        )
                        aFragment.addNewSport(newAthlet)
                    } else {
                        Toast.makeText(context, R.string.empty_field, Toast.LENGTH_SHORT).show()
                    }

                }
                .setNegativeButton("Cancel") { dialog, id ->
                    Toast.makeText(context, "Cancel Add Sport", Toast.LENGTH_SHORT).show()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}