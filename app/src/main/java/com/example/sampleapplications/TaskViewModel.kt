package com.example.sampleapplications

import io.realm.RealmModel
import io.realm.annotations.RealmClass
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.Date
import java.util.UUID

@RealmClass
class TaskViewModel : RealmModel {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var name: String = ""
    var description: String = ""
    var dueDate: Date = Date()
    var completed: Boolean = false
}

