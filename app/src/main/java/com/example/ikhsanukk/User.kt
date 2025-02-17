package com.example.ikhsanukk

data class User(val username: String, val password: String) {
    companion object {
        private val userList = mutableListOf<User>()

        // Tambahkan user baru ke daftar
        fun addUser(user: User) {
            userList.add(user)
        }

        // Mendapatkan user berdasarkan username
        fun getUserByUsername(username: String): User? {
            return userList.find { it.username == username }
        }
    }
}