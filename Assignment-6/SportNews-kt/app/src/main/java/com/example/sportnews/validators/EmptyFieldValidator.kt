package com.example.sportnews.validators

import android.util.Log

class EmptyFieldValidator() :Validate{
    override fun validate(value: String): Boolean {
        var valueCopy = value.trim();
        Log.i("EmptyFieldValidator"," : $value -> $valueCopy")
        return valueCopy.isNotEmpty()
    }
}