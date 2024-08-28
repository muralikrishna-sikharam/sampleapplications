package com.example.sampleapplications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults

class TaskAdapter(private val tasks: RealmResults<Task>?) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks!![position]
        holder.textViewName.text = task?.name
        holder.textViewDescription.text = task?.description
    }

    override fun getItemCount(): Int = tasks!!.size

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(android.R.id.text1)
        val textViewDescription: TextView = view.findViewById(android.R.id.text2)
    }

    /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_todolist, parent, false)
         return TaskViewHolder(view)
     }

     override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
         val task = tasks!!.get(position)
         task?.let {
             holder.bindTask(it)
         }
     }

     override fun getItemCount(): Int {
         return tasks!!.size
     }

     inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         private val taskName: TextView = itemView.findViewById(R.id.taskName)
         private val taskDescription: TextView = itemView.findViewById(R.id.taskDescription)
         private val taskDueDate: TextView = itemView.findViewById(R.id.taskDueDate)
         private val taskCompleted: CheckBox = itemView.findViewById(R.id.taskCompleted)

         fun bindTask(task: Task) {
             taskName.text = task.name
             taskDescription.text = task.description
             taskDueDate.text = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(task.dueDate)
             taskCompleted.isChecked = task.completed

             taskCompleted.setOnCheckedChangeListener { _, isChecked ->
                 val realm = Realm.getDefaultInstance()
                 realm.executeTransactionAsync { realmTransaction ->
                     task.completed = isChecked
                 }
             }
         }
     }*/
}
