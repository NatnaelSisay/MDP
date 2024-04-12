package com.example.sportnews.validators

import android.widget.EditText

interface Validate {
    public fun validate(value: String): Boolean;
    public fun validate(values: MutableList<EditText>): Boolean
}