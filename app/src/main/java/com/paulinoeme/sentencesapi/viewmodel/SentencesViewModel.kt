package com.paulinoeme.sentencesapi.viewmodel

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulinoeme.sentencesapi.data.model.SentenceModel
import com.paulinoeme.sentencesapi.domain.GetSentenceRandomUserCase
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class SentencesViewModel:ViewModel() {
    val sentenceModel = MutableLiveData<SentenceModel>()
    val getSentence = GetSentenceRandomUserCase()

    fun getSentenceRandom(){
        viewModelScope.launch {
            val sentence = getSentence()
            sentence?.let {
                sentenceModel.postValue(it)
            }
        }
    }

    fun intoImage(url:String, image: ImageView){
        Picasso
            .get()
            .load(url)
            .into(image)
    }
}