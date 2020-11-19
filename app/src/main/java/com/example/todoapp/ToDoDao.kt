package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ToDoDao {

    @Insert
    suspend fun insertTask(toDoModel: ToDoModel):Long

    @Query("select * from ToDoModel where isFinished=0")
    fun getTask():LiveData<List<ToDoModel>>

    @Query("Update ToDoModel set isFinished = 1 where id=:uid")
    fun finishTask(uid:Long)

    @Query("Delete from ToDoModel where id=:uid")
    fun deleteTask(uid:Long)
}