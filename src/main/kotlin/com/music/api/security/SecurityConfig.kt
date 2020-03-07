package com.music.api.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    //configurações de autenticação
    override fun configure(auth: AuthenticationManagerBuilder?) {
        super.configure(auth)
    }

    //configurações da web
    override fun configure(web: WebSecurity?) {
//        super.configure(web)
        web!!.ignoring().antMatchers("/**").and().ignoring().antMatchers("/getAllMusics/**")
    }

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
        http!!.csrf()
    }
}