package com.example.ikhsanukk

data class Task(
    val id: Int,
    var description: String,
    var date: String,
    var time: String,
    var category: String,
    var isCompleted: Boolean,  // Pastikan ini adalah var, agar bisa diubah
    var isHistory: Boolean
)
{
    // Constructor tambahan jika diperlukan untuk mempermudah instansiasi task baru
    constructor(description: String, date: String, time: String, category: String, isCompleted: Boolean, isHistory: Boolean) :
            this(0, description, date, time, category, isCompleted, isHistory) // id default 0 saat belum tersimpan di DB
}