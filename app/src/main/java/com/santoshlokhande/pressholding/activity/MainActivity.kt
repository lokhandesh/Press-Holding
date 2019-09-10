package com.santoshlokhande.pressholding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.*
import androidx.lifecycle.ViewModelProviders
import com.myproject.albumlist.utility.CheckNetworkConnection
import android.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.santoshlokhande.pressholding.R
import com.santoshlokhande.pressholding.adapter.RecordsAdapter
import com.santoshlokhande.pressholding.data.Records
import com.santoshlokhande.pressholding.viewmodel.RecordViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Santosh Lokhande on 27/7/2019.
 *
 * This is main activity which interact with user.
 *
 * Here we have used RecordsAdapter to display Album title.
 *
 */


class MainActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var parentCoordinate:ConstraintLayout
    private lateinit var recordViewModel: RecordViewModel
    private val adapter = RecordsAdapter(this)
    private var initialLimit = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recordViewModel = ViewModelProviders.of(this).get(RecordViewModel::class.java)

        initUi()

        recordViewModel.getAllRecords(initialLimit).observe(this,
                Observer<List<Records>> {
                    adapter.setRecords(it)
                    progressBar.visibility=View.INVISIBLE
                })


        recordViewModel.retriveError().observe(this,
            Observer<String>{ t ->
                val snackbar = Snackbar
                    .make(parentCoordinate, "API not working properly", Snackbar.LENGTH_LONG)

                // Changing message text color
                snackbar.setActionTextColor(Color.RED)
                snackbar.show()
            })

    }

    fun initUi(){

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        progressBar = findViewById(R.id.progressBar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

         if (CheckNetworkConnection.isConnectingToInternet(this)){
             progressBar.visibility=View.VISIBLE
             recordViewModel.retriveRecordList(initialLimit)
         }else{
             val snackbar = Snackbar
                 .make(parentCoordinate, "Required internet to fetch updated album", Snackbar.LENGTH_LONG)

             // Changing message text color
             snackbar.setActionTextColor(Color.RED)
             snackbar.show()
         }

    }

}