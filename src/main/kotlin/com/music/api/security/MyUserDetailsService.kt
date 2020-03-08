package com.music.api.security

import com.music.api.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(login: String?): UserDetails {
        val userDetails = userRepository.findByLogin(login!!) ?: throw UsernameNotFoundException("You can't pass a null username")
        return userDetails
    }

}