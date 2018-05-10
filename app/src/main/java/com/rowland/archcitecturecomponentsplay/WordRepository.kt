package com.rowland.archcitecturecomponentsplay

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

/**
 * Created by Rowland on 5/10/2018.
 */

class WordRepository internal constructor(application: Application) {

    private val mWordDao: WordDao
    val allWords: LiveData<List<WordEntity>>

    init {
        val db = WordRoomDatabase.getDatabase(application)
        mWordDao = db.wordDao()
        allWords = mWordDao.allWords
    }

    fun insert(wordEntity: WordEntity) {
        insertAsyncTask(mWordDao).execute(wordEntity)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: WordDao) : AsyncTask<WordEntity, Void, Void>() {

        override fun doInBackground(vararg params: WordEntity): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}
