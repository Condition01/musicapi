package com.music.api.seed

import com.music.api.model.Roles
import com.music.api.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Role
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

@Configuration
@EnableConfigurationProperties //enable using external configs in the configuration properties annotation
@ConfigurationProperties //enable to extract the config information
data class YMLConfig (
    val seedUser1: Any =  object {
        lateinit var login: String
        lateinit var password: String
        lateinit var fullName: String
        lateinit var role: String
    },

    val seedUser2: Any = object {
        lateinit var login: String
        lateinit var password: String
        lateinit var fullName: String
        lateinit var role: String
    }
){

    @Suppress("UNCHECKED_CAST")
    fun <R> readInstanceProperty(instance: Any, propertyName: String): R {
        val property = instance::class.memberProperties
                // don't cast here to <Any, R>, it would succeed silently
                .first { it.name == propertyName } as KProperty1<Any, *>
        // force a invalid cast exception if incorrect type here
        return property.get(instance) as R
    }
}