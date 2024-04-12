package com.example.sportnews.dialogs

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.sportnews.R
import com.example.sportnews.fragments.HistoricArchievesFragment
import com.example.sportnews.models.Event
import com.example.sportnews.models.History
import com.example.sportnews.validators.EmptyFieldValidator
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

class AddHistoricDialog(private val context: Context, val hFragment: HistoricArchievesFragment ): DialogFragment() {
    private lateinit var eventName: EditText;
    private lateinit var eventDate: EditText;
    private lateinit var eventDescription: EditText;

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val layout = inflater.inflate(R.layout.add_historical_dialog, null)

            eventName = layout.findViewById(R.id.etHistoricalDialogName)
            eventDate = layout.findViewById(R.id.etHistoricalDialogDate)
            eventDescription = layout.findViewById(R.id.etHistoricalDialogDescription)

            eventDate.setOnClickListener {
                this.showDatePickerDialog()
            }

            val validator = EmptyFieldValidator()

            builder.setView(layout)
                .setPositiveButton("Add") { dialog, id ->
                    val isValid = validator.validate(mutableListOf(eventName, eventDate, eventDescription))

                    if(isValid){
                        val newHistoryEvent = History(
                            eventName.text.toString(),
                            eventDate.text.toString(),
                            eventDescription.text.toString()
                        )
                        hFragment.addNews(newHistoryEvent)
                    } else {
                        Toast.makeText(context, R.string.empty_field, Toast.LENGTH_SHORT).show()
                    }
                }
                .setNegativeButton("Cancel") { dialog, id ->
                    Toast.makeText(context, "Cancel Add Sport", Toast.LENGTH_SHORT).show()
                }
            // Create the AlertDialog object and return it.
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            context,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                val yearString = "$year-${month + 1}-$dayOfMonth"

                eventDate.setText(this.formatDate(yearString))
            },
            year,
            month,
            day
        )

        datePickerDialog.datePicker.maxDate = calendar.timeInMillis
        datePickerDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun formatDate(inputDate: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy-M-dd][yyyy-MM-d][yyyy-M-d]", Locale.ENGLISH)
        val outputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH)
        val date = LocalDate.parse(inputDate, inputFormatter)
        return outputFormatter.format(date)
    }
}