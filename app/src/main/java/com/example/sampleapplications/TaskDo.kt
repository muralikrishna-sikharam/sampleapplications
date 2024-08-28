package com.example.sampleapplications

import android.os.Build
import androidx.annotation.RequiresApi
import io.realm.RealmModel
import io.realm.RealmObject
import java.time.LocalDateTime

class TaskDo(
    var id: String,
    var name: String,
    var description: String,
    var dueDate: LocalDateTime,
    var completed: Boolean = false
) : RealmObject(), RealmModel {
    fun markAsCompleted() {
        completed = true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun isOverdue(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime.now().isAfter(dueDate)
        } else {
            TODO("VERSION.SDK_INT < O")
        }
    }

    override fun toString(): String {
        return "Task(name='$name', description='$description', dueDate=$dueDate, completed=$completed)"
    }
}
