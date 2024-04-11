package com.example.sportnews.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.sportnews.R
import com.example.sportnews.fragments.SportsFragment
import com.example.sportnews.models.Sport

class AddSportDialog(private val context: Context, val sFrag: SportsFragment) : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val layout = inflater.inflate(R.layout.add_sports_dialog, null)

            val spinnerSportType = layout.findViewById<Spinner>(R.id.spinnerSportsDialogType)
            val sportName = layout.findViewById<EditText>(R.id.etSportsDialogName)
            val description = layout.findViewById<EditText>(R.id.etSportsDialogInstruction)

            builder.setView(layout)
                .setPositiveButton("Add") { dialog, id ->
                    val newSport = Sport(
                        spinnerSportType.selectedItem.toString(),
                        sportName.text.toString(),
                        description.text.toString()
                    )
                    sFrag.addNewSport(newSport)
                }
                .setNegativeButton("Cancel") { dialog, id ->
                    Toast.makeText(context, "Cancel Add Sport", Toast.LENGTH_SHORT).show()
                }
            // Create the AlertDialog object and return it.
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}