package com.music.api.security

import com.music.api.model.Roles
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Role
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

//form base authentication
@Configuration
@EnableWebSecurity
class SecurityConfig(private val myUserDetailsService : MyUserDetailsService) : WebSecurityConfigurerAdapter() {

    //authentication configs
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(myUserDetailsService)
                ?.passwordEncoder(passwordEncoder())
    }


    override fun configure(http: HttpSecurity?) {
        http!!.csrf()
                .disable().formLogin().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/albums/**")
                .hasRole(Roles.ADMIN.getRole())
                .antMatchers(HttpMethod.GET,"/albums/**")
                .hasAnyRole(Roles.USER.getRole(), Roles.ADMIN.getRole())
                .anyRequest().authenticated()
                .and().httpBasic() //basic http --> receive the authentication in header
    }

    @Bean
    fun passwordEncoder() : PasswordEncoder{
        return BCryptPasswordEncoder()
    }
}