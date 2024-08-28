package com.example.sampleapplications

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.annotations.RealmModule
import io.realm.exceptions.RealmException
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import java.time.LocalDate
import java.util.UUID

@RealmModule(classes = [TaskDo::class])
class RealmCrudActivity : AppCompatActivity() {
    lateinit var realm: Realm
    lateinit var taskAdapter: TaskAdapter
    lateinit var recyclerViewTasks: RecyclerView
    lateinit var config: RealmConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm_crud)

        Realm.init(applicationContext)
        val config = RealmConfiguration.Builder()
            .schemaVersion(2) // Update this if you make schema changes
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        realm = Realm.getDefaultInstance()


        /* Realm.init(this)


          config = RealmConfiguration.Builder()
              //.modules(RealmCrudActivity::class.java,TaskDo::class.java)
             //.name("test.db")
             .allowQueriesOnUiThread(true)
             .schemaVersion(1)
             .allowWritesOnUiThread(true)
             .deleteRealmIfMigrationNeeded()
              .migration { realm, oldVersion, newVersion ->
                  // Example migration logic
                  if (oldVersion < 2) {
                      // Perform migration from version 1 to version 2
                      val schema = realm.schema
                      val newTaskSchema = schema.get("Task1")

                      newTaskSchema!!.addField("id", String::class.java, FieldAttribute.PRIMARY_KEY)
                      newTaskSchema!!.addField("name", String::class.java)
                      newTaskSchema!!.addField("description", String::class.java)
                      newTaskSchema!!.addField("dueDate", Date::class.java)
                      newTaskSchema!!.addField("completed", Boolean::class.java)

                      // Alternatively, you can create a new class version
                      // and modify fields accordingly
                      *//*val newTaskSchema = schema.create("TaskV2")
                     newTaskSchema.addField("id", String::class.java, FieldAttribute.PRIMARY_KEY)
                     newTaskSchema.addField("name", String::class.java)
                     newTaskSchema.addField("description", String::class.java)
                     newTaskSchema.addField("dueDate", Date::class.java)
                     newTaskSchema.addField("completed", Boolean::class.java)
                     newTaskSchema.addField("newField1", String::class.java)
                     newTaskSchema.addField("newField2", Int::class.java)*//*
                 }}
            .build()
        Realm.setDefaultConfiguration(config)*/
        //realm = Realm.getDefaultInstance()


        recyclerViewTasks = findViewById(R.id.recyclerViewTasks)
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)

        /* val tasks: RealmResults<Task> = realm.where(Task::class.java).findAll()
         taskAdapter = TaskAdapter(tasks)
         recyclerViewTasks.adapter = taskAdapter*/


        val buttonAddTask: Button = findViewById(R.id.buttonAddTask)
        buttonAddTask.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                addTask()
            }
        }

        // Set up item click listeners for update and delete operations
        /* recyclerViewTasks.addOnItemTouchListener(
             RecyclerItemClickListener(
                 this,
                 recyclerViewTasks,
                 object : RecyclerItemClickListener.OnItemClickListener {
                     override fun onItemClick(view: View, position: Int) {
                         val task = tasks[position]
                         if (task != null) {
                             // Update task example
                             realm.executeTransaction {
                                 task.name = "Updated Name"
                             }
                             taskAdapter.notifyDataSetChanged()
                         }
                     }

                     override fun onLongItemClick(view: View, position: Int) {
                         val task = tasks[position]
                         if (task != null) {
                             // Delete task example
                             realm.executeTransaction {
                                // task.deleteFromRealm()
                             }
                             taskAdapter.notifyDataSetChanged()
                         }
                     }
                 })
         )*/
    }

    @OptIn(InternalCoroutinesApi::class)
    @RequiresApi(Build.VERSION_CODES.O)
    private fun addTask() {
        val editTextTaskName: EditText = findViewById(R.id.editTextTaskName)
        val editTextTaskDescription: EditText = findViewById(R.id.editTextTaskDescription)

        var name1 = editTextTaskName.text.toString()
        var description1 = editTextTaskDescription.text.toString()

        if (name1.isNotEmpty() && description1.isNotEmpty()) {
            /* var db = Realm.getDefaultInstance()*/
            /* db.executeTransactionAsync {
                 val info = VisitInfo().apply {
                     visitCount = 1
                 }
                 it.insert(info)
             }*/try {
                realm.beginTransaction()
                val info = Task().apply {
                    id = UUID.randomUUID().toString()
                    name = name1
                    description = description1
                    dueDate = LocalDate.now().toString()
                    completed = false
                }
                if (realm.isInTransaction) {
                    realm.cancelTransaction()
                }
                synchronized(realm) {
                    if (!realm.isInTransaction) {
                        realm.executeTransaction { realmTransaction ->
                            realmTransaction.insertOrUpdate(info)
                        }
                    }
                }

                /*  realm.executeTransaction { r ->
                      var info = r.createObject(TaskDo::class.java, UUID.randomUUID().toString())
                      info.id = UUID.randomUUID().toString()
                      info.name = name
                      info.description = description
                      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                          info.dueDate = LocalDateTime.now()
                      }
                      info.completed = false
                  }*/
                realm.commitTransaction()
                realm.close()
            } catch (e: RealmException) {
                e.printStackTrace() // Log the exception for further analysis
                Log.e("RealmInsert", "Failed to insert or update Task: ${e.message}")
            }

            /*  val info = Task().apply {
                  id = UUID.randomUUID().toString()
                  name = name
                  description = description
                  dueDate = Date()
                  completed = false
              }*/
            try {

                /*   realm.executeTransaction { realmTransaction ->
                       realmTransaction.insertOrUpdate(info) // This will update if the object exists
                   }*/
            } catch (e: RealmException) {
                e.printStackTrace() // Log the exception for further analysis
                Log.e("RealmInsert", "Failed to insert or update Task: ${e.message}")
            }
            // db.insert(info)
        }
        /*  realm.executeTransaction {
              val newTask = db.createObject(Task::class.java, UUID.randomUUID().toString())
              newTask.name = name
              newTask.description = description
              newTask.dueDate = Date()
              newTask.completed = false
          }*/
        // taskAdapter.notifyDataSetChanged()
    }


    override fun onDestroy() {
        super.onDestroy()
        if (!realm.isClosed) {
            realm.close()
        }
    }
}

