package com.rowland.archcitecturecomponentsplay

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

import java.util.Date

/**
 * Created by Rowland on 5/10/2018.
 */

@Entity(tableName = "word")
class WordEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id = 0

    @ColumnInfo(name = "date")
    var updatedAt: Date
        private set

    @ColumnInfo(name = "spelling")
    var spelling: String
        private set


    constructor(id: Int, spelling: String, updatedAt: Date) {
        this.id = id
        this.spelling = spelling
        this.updatedAt = updatedAt
    }

    @Ignore
    constructor(spelling: String, updatedAt: Date) {
        this.spelling = spelling
        this.updatedAt = updatedAt
    }
}