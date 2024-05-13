package com.example.animalkingdomexplorer.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.animalkingdomexplorer.databinding.AddAnimalDialogBinding
import com.example.animalkingdomexplorer.model.Animal
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AddAnimalsDialog(val onSave: (Animal) -> Unit) : DialogFragment() {

    lateinit var binding: AddAnimalDialogBinding
    lateinit var dialog: AlertDialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = MaterialAlertDialogBuilder(it)
            binding = AddAnimalDialogBinding.inflate(layoutInflater)
            builder.setView(binding.root)
            dialog = builder.create()
            return dialog

        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding.saveAnimalButton.setOnClickListener {

            val name = binding.animalNameTextField.editText?.text?.trim()
            val habitat = binding.animalHabitatTextField.editText?.text?.trim()
            val diet = binding.animalDietTextField.editText?.text?.trim()

            if (name.isNullOrEmpty() || habitat.isNullOrEmpty() || diet.isNullOrEmpty()) {
                Toast.makeText(context, "Fields can't be empty!!!", Toast.LENGTH_SHORT).show()
            } else {
                val animal = Animal(
                    null,
                    animalName = name.toString(),
                    habitat = habitat.toString(),
                    diet = diet.toString()
                )

                onSave(animal)
                dialog.dismiss()
            }
        }

        binding.cancelAnimalButton.setOnClickListener {
            dialog.dismiss()
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}