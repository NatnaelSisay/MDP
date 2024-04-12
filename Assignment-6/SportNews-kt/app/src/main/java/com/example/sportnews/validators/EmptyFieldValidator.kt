package com.example.sportnews.validators

import android.util.Log
import android.widget.EditText

class EmptyFieldValidator() :Validate{
    override fun validate(value: String): Boolean {
        var valueCopy = value.trim();
        Log.i("EmptyFieldValidator"," : $value -> $valueCopy")
        return valueCopy.isNotEmpty()
    }

    override fun validate(values: MutableList<EditText>): Boolean {
        values.forEach {
            if(!validate(it.text.toString())){
                return false
            }
        }
        return true
    }
}