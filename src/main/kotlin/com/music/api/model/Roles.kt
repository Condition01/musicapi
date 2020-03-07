package com.music.api.model

enum class Roles {
    ADMIN{
        override fun getRole(): String = "admin"
    },
    USER{
        override fun getRole(): String = "user"
    };
    abstract fun getRole() : String
}