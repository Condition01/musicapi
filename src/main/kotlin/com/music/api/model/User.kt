package com.music.api.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_user")
class User (
        @Id
        @Column(name = "usr_login", nullable = false)
        val login: String,
        @Column(name = "usr_pass", nullable = false)
        val passWord: String,
        @Column(name = "usr_full_name", nullable = false)
        val fullName: String,
        @Column(name = "urs_role")
        val role: Roles
): UserDetails{

    private val ROLE_PREFIX : String = "ROLE_"

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val grantedAuthorities = mutableListOf<GrantedAuthority>()
        grantedAuthorities.add(SimpleGrantedAuthority(ROLE_PREFIX+role.getRole()))
        return grantedAuthorities
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.login
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return this.passWord
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

}
