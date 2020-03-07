package com.music.api.controller

import com.music.api.service.IMusicService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/"])
class MusicController(private val musicService : IMusicService) {

    @GetMapping(value = ["/getAllMusics"])
    fun getAllMusic(): ResponseEntity<*> {
        return try {
            ResponseEntity.ok(musicService.findAll())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body(ex.message)
        }
    }

}