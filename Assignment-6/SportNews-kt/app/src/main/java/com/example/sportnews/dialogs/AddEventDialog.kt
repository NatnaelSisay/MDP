package com.example.sportnews.dialogs

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.sportnews.R
import com.example.sportnews.fragments.EventFragment
import com.example.sportnews.models.Event
import com.example.sportnews.validators.EmptyFieldValidator
import java.util.Calendar

class AddEventDialog(private val context: Context, val eventFragment: EventFragment): DialogFragment() {
    private lateinit var selectDate: EditText;
    private lateinit var eventName: EditText;
    private lateinit var eventDescription: EditText;

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val layout = inflater.inflate(R.layout.add_event_dialog, null)

            eventName = layout.findViewById(R.id.etEventDialogName)
            selectDate = layout.findViewById(R.id.etEventDialogDate)
            eventDescription = layout.findViewById(R.id.etEventDialogDescription)

            selectDate.setOnClickListener {
               showDatePickerDialog()
            }

            val validator = EmptyFieldValidator();

            builder.setView(layout)
                .setPositiveButton("Add") { dialog, id ->
                    val isValid = validator.validate(mutableListOf<EditText>(eventName, selectDate, eventDescription))

                    if(isValid){
                        val newEventDialog = Event(
                            eventName.text.toString(),
                            selectDate.text.toString(),
                            eventDescription.text.toString()
                        )
                        eventFragment.addNews(newEventDialog)
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
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            context,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                selectDate.setText("$year-${month + 1}-$dayOfMonth")
            },
            year,
            month,
            day
        )

        datePickerDialog.datePicker.maxDate = calendar.timeInMillis
        datePickerDialog.show()
    }
}