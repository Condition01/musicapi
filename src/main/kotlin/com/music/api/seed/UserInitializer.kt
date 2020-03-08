package com.music.api.seed

import com.music.api.model.Roles
import com.music.api.model.User
import com.music.api.repository.UserRepository
import org.omg.CORBA.Object
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Bean
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

@Component
class UserInitializer(
        private val userRepository: UserRepository,
        private val yml: YMLConfig) : ApplicationListener<ContextRefreshedEvent> {

    var bCripty = BCryptPasswordEncoder()

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        generateSeeds()
    }

    fun generateSeeds(){
       val user1 = buildUser(yml.seedUser1)
       val user2 = buildUser(yml.seedUser2)
       userRepository.save(user1)
       userRepository.save(user2)
    }

    //calling an reflection method to handle the object properties uwknow by the compiler
    fun buildUser(obj: Any): User{
        val login: String = yml.readInstanceProperty<String>(obj, "login") as String
        var password: String = yml.readInstanceProperty<String>(obj, "password") as String
        password =  bCripty.encode(password)
        val fullName: String = yml.readInstanceProperty<String>(obj, "fullName") as String
        val role: String = yml.readInstanceProperty<String>(obj, "role") as String
        return User(login = login, passWord = password, fullName = fullName, role = Roles.valueOf(role))
    }
}