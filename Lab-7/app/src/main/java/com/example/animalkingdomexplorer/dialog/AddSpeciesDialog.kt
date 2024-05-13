package com.example.animalkingdomexplorer.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.animalkingdomexplorer.databinding.AddSpeciesDialogBinding
import com.example.animalkingdomexplorer.model.Species
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddSpeciesDialog(val onSave: (Species) -> Unit) : DialogFragment() {

    lateinit var binding: AddSpeciesDialogBinding
    lateinit var dialog: AlertDialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = MaterialAlertDialogBuilder(it)
            binding = AddSpeciesDialogBinding.inflate(layoutInflater)
            builder.setView(binding.root)
            dialog = builder.create()
            return dialog

        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding.saveSpeciesButton.setOnClickListener {

            val name = binding.speciesNameTextField.editText?.text?.trim()
            val description = binding.speciesDescriptionTextField.editText?.text?.trim()

            if (!name.isNullOrEmpty() && !description.isNullOrEmpty()) {
                val species = Species(
                    null,
                    name.toString(),
                    description.toString()
                )

                onSave(species)
                dialog.dismiss()
            }
        }

        binding.cancelSpeciesButton.setOnClickListener {
            dialog.dismiss()
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}