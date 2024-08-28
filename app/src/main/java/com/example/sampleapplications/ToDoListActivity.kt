package com.example.sampleapplications

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.RealmConfiguration
import java.time.LocalDate
import java.util.UUID

class ToDoListActivity : AppCompatActivity() {
    private lateinit var realm: Realm
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskViewModel: TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        // Initialize Realm
        Realm.init(this)
        /* val config = RealmConfiguration.Builder()
             .allowWritesOnUiThread(true)
             .schemaVersion(1)
             .build()
         Realm.setDefaultConfiguration(config)*/
        val config = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .schemaVersion(1)
            .build()
        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance()

        /* val tasks: RealmResults<Task1>? = realm.where(Task1::class.java).findAll()
         adapter = TaskAdapter(tasks)*/

        /* recyclerView = findViewById(R.id.recyclerView)
         recyclerView.layoutManager = LinearLayoutManager(this)
         recyclerView.adapter = adapter*/

        // Setup Add Task button
        val addTaskButton: Button = findViewById(R.id.addTaskButton)
        addTaskButton.setOnClickListener {
            showAddTaskDialog()
        }
    }

    private fun showAddTaskDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.inputlayout_todolist, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialogBuilder.show()

        val etTaskName: EditText = dialogView.findViewById(R.id.taskNameInput)
        val etTaskDescription: EditText = dialogView.findViewById(R.id.taskDescriptionInput)
        val btnAddTask: Button = dialogView.findViewById(R.id.saveTaskButton)

        btnAddTask.setOnClickListener {
            val taskName = etTaskName.text.toString().trim()
            val taskDescription = etTaskDescription.text.toString().trim()

            if (taskName.isNotEmpty()) {
                // Add new task to Realm
                realm.executeTransactionAsync {
                    val newTask = it.createObject(Task::class.java, UUID.randomUUID().toString())
                    newTask.name = taskName
                    newTask.description = taskDescription
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        newTask.dueDate = LocalDate.now().toString()
                    }
                    newTask.completed = false
                }
                dialogBuilder.dismiss()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}


