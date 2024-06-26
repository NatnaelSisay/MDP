package com.example.sportnews.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.sportnews.R
import com.example.sportnews.fragments.NewsFragment
import com.example.sportnews.models.News
import com.example.sportnews.validators.EmptyFieldValidator

class AddNewsDialog(
    private val context: Context,
    private val newsFrag: NewsFragment
): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val layout = inflater.inflate(R.layout.add_news_dialog, null)

            val imageUrl = layout.findViewById<EditText>(R.id.etNewsDialogImgUrl)
            val newsTitle = layout.findViewById<EditText>(R.id.etNewsDialogTitle)
            val newsDescription = layout.findViewById<EditText>(R.id.etNewsDialogDescription)

            val isEmpty = EmptyFieldValidator()

            builder.setView(layout)
                .setPositiveButton("Add") { dialog, id ->
                    val validateImageUrl = isEmpty.validate(imageUrl.text.toString())
                    val newsTitleNotEmpty = isEmpty.validate(newsTitle.text.toString())
                    val newsDescriptionNotEmpty = isEmpty.validate(newsDescription.text.toString())

                    if(validateImageUrl && newsTitleNotEmpty && newsDescriptionNotEmpty){
                        val newNews = News(imageUrl.text.toString(), newsTitle.text.toString(), newsDescription.text.toString())
                        newsFrag.addNews(newNews)
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
}