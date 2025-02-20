package com.example.ikhsanukk

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var historyAdapter: TaskAdapter
    private var historyList = ArrayList<Task>()
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        dbHelper = DatabaseHelper(this)

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.historyRecyclerView)

        // Inisialisasi adapter dengan hanya menampilkan daftar histori (tanpa fitur edit, hapus, selesai)
        historyAdapter = TaskAdapter(
            this,
            historyList,
            onTaskClicked = {
                // Tidak ada aksi karena tidak ada fitur edit
            },
            onTaskDeleted = { task ->
                // Tidak ada aksi untuk menghapus
            },
            onTaskCompleted = { task ->

            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = historyAdapter


        loadHistory()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadHistory() {

        historyList.clear()
        historyList.addAll(dbHelper.getHistoricalTasks())
        historyAdapter.notifyDataSetChanged()
    }
}