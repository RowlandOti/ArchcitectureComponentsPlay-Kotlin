package com.rowland.archcitecturecomponentsplay

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

/**
 * Created by Rowland on 5/10/2018.
 */

class WordListAdapter internal constructor(context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private val mInflater: LayoutInflater
    //private var mWordEntities: List<WordEntity>? = null
    private var mWordEntities: List<WordEntity> = ArrayList();

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = mInflater.inflate(R.layout.row_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        if (mWordEntities != null) {
            val current = mWordEntities!![position]
            holder.wordItemView.text = current.spelling
        } else {
            holder.wordItemView.text = "No WordEntity"
        }
    }

    internal fun setWords(wordEntities: List<WordEntity>) {
        mWordEntities = wordEntities
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (mWordEntities != null) mWordEntities!!.size else 0
    }

    inner class WordViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView

        init {
            wordItemView = itemView.findViewById(R.id.textView)
        }
    }
}