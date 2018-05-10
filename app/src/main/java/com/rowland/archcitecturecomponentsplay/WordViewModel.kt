package com.rowland.archcitecturecomponentsplay


import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

/**
 * Created by Rowland on 5/10/2018.
 */

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: WordRepository
    val allWords: LiveData<List<WordEntity>>

    init {
        mRepository = WordRepository(application)
        allWords = mRepository.allWords
    }

    fun insert(wordEntity: WordEntity) {
        this.mRepository.insert(wordEntity)
    }
}
