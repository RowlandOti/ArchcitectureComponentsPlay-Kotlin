package com.rowland.archcitecturecomponentsplay

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import android.content.Intent
import java.util.*
import android.support.design.widget.FloatingActionButton
import android.view.View


class MainActivity : AppCompatActivity() {

    companion object {
        val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
    }

    private var mWordViewModel: WordViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java!!)

        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view)
        val adapter = WordListAdapter(this)
        recyclerView.setAdapter(adapter)
        recyclerView.setLayoutManager(LinearLayoutManager(this))

        mWordViewModel!!.allWords.observe(this, Observer { words ->
            adapter.setWords(words!!)
        })

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)
        })
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val word = WordEntity(data.getStringExtra(NewWordActivity.EXTRA_REPLY), Date())
            mWordViewModel!!.insert(word)
        } else {
            Toast.makeText(applicationContext, R.string.empty_not_saved, Toast.LENGTH_LONG).show()
        }
    }
}
