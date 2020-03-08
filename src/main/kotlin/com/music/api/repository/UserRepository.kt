package com.music.api.repository

import com.music.api.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String>{
    fun findByLogin(login: String): User?
}