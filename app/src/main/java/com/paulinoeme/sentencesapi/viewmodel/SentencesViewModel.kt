package com.paulinoeme.sentencesapi.viewmodel

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulinoeme.sentencesapi.data.model.SentenceModel
import com.paulinoeme.sentencesapi.domain.GetSentenceRandomUserCase
import com.squareup.picasso.Picasso
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SentencesViewModel @Inject constructor(
    private val getSentence: GetSentenceRandomUserCase
) : ViewModel() {
    val sentenceModel = MutableLiveData<SentenceModel>()

    fun getSentenceRandom() {
        viewModelScope.launch {
            val sentence = getSentence()
            sentence?.let {
                sentenceModel.postValue(it)
            }
        }
    }

    fun intoImage(url: String, image: ImageView) {
        Picasso
            .get()
            .load(url)
            .into(image)
    }
}