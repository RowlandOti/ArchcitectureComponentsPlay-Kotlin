package com.rowland.archcitecturecomponentsplay

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by Rowland on 5/10/2018.
 */

@Dao
interface WordDao {

    @get:Query("SELECT * from word ORDER BY spelling ASC")
    val allWords: LiveData<List<WordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(wordEntity: WordEntity)

    @Delete
    fun delete(wordEntity: WordEntity)

    @Query("DELETE FROM word")
    fun deleteAll()

    @Query("Select count(*) from word")
    fun getCount(): Int
}
