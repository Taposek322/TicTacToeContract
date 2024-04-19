package com.taposek322.tictactoecontract.domain.validation

import com.taposek322.tictactoecontract.R
import com.taposek322.tictactoecontract.domain.util.Resource
import com.taposek322.tictactoecontract.presentation.util.UiText

class ValidationClass {
    fun validateEmptyString(value: String): Resource<UiText> {
        return if (value.isNotEmpty()) {
            Resource.Success(null)
        } else {
            Resource.Error(message = UiText.StringResource(resId = R.string.empty_field_error_message))
        }
    }

    fun validateNumberField(value: String): Resource<UiText> {
        val res = value.toDoubleOrNull()
        return if (res != null) {
            Resource.Success(null)
        } else {
            Resource.Error(message = UiText.StringResource(resId = R.string.numeric_field_error))
        }
    }
}