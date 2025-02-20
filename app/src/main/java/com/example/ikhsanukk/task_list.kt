package com.example.ikhsanukk
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private var taskList = ArrayList<Task>()
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        dbHelper = DatabaseHelper(this)

        recyclerView = findViewById(R.id.taskRecyclerView)

        // Menyusun TaskAdapter dengan parameter untuk aksi klik, hapus, dan selesai
        taskAdapter = TaskAdapter(
            this,
            taskList,
            onTaskClicked = { task ->
                // Placeholder jika task diklik (bisa membuka activity edit)
                Toast.makeText(this, "Task clicked: ${task.description}", Toast.LENGTH_SHORT).show()
            },
            onTaskDeleted = { task ->
                dbHelper.moveToHistory(task.id)
                taskList.remove(task)
                taskAdapter.notifyItemRemoved(taskList.indexOf(task))  // Menghapus item dari RecyclerView
                Toast.makeText(this, "Tugas dipindahkan ke histori", Toast.LENGTH_SHORT).show()
            },
            onTaskCompleted = { task ->
                // Pastikan task yang bisa diubah statusnya
                task.isCompleted = true
                dbHelper.updateTask(task)  // Update status tugas ke selesai
                dbHelper.moveToHistory(task.id)  // Memindahkan task ke histori
                taskList.remove(task)
                taskAdapter.notifyItemRemoved(taskList.indexOf(task))  // Menghapus item dari RecyclerView
                Toast.makeText(this, "Tugas dipindahkan ke histori", Toast.LENGTH_SHORT).show()
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter

        loadActiveTasks()
    }

    private fun loadActiveTasks() {
        taskList.clear()
        taskList.addAll(dbHelper.getActiveTasks())  // Mengambil tugas aktif
        taskAdapter.updateTaskList(taskList)  // Perbarui task list pada adapter
    }
}