package com.scrooge.foodtracker.ui.ingredients

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class Whatever @Inject constructor() {
    val x = 5
}

@HiltViewModel
class IngredientsSearchViewModel @Inject constructor(val whatever: Whatever) : ViewModel() {

}
