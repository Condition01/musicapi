package com.music.api.controller

import com.music.api.model.Album
import com.music.api.model.Music
import com.music.api.model.Roles
import com.music.api.service.IMusicService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/musics"])
class MusicController(private val musicService : IMusicService) {

    @GetMapping(value = ["getAllMusics"])
    fun getAllMusic(): ResponseEntity<*> {
        return try {
            ResponseEntity.ok(musicService.findAll())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body(ex.message)
        }
    }

    @PostMapping(value = ["/save"])
    fun save(@RequestBody music: Music) : ResponseEntity<*> {
        return try {
            ResponseEntity.ok(musicService.save(music))
        }catch (ex: java.lang.Exception){
            ResponseEntity.badRequest().body(ex.message)
        }
    }

}