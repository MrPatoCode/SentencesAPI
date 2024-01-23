package com.paulinoeme.sentencesapi.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SentencesProvider @Inject  constructor() {
        var sentences: List<SentenceModel> = emptyList()
}