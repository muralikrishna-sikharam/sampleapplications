package com.example.sampleapplications

import io.realm.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


open class Task(
    @PrimaryKey var id: String = "",
    var name: String = "",
    var description: String = "",
    var dueDate: String = "",
    var completed: Boolean = false
) : RealmObject()

