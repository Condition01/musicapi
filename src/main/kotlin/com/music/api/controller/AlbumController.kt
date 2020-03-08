package com.music.api.controller

import com.music.api.model.Album
import com.music.api.model.Music
import com.music.api.service.IAlbumService
import com.music.api.service.IMusicService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping(value = ["/albums"])
class AlbumController(private val albumService: IAlbumService) {

    @PostMapping(value = ["/save"])
    fun save(@RequestBody album: Album) : ResponseEntity<*> {
        return try {
            ResponseEntity.ok(albumService.save(album))
        }catch (ex: Exception){
            ResponseEntity.badRequest().body(ex.message)
        }
    }

    @GetMapping(value = ["/getAllAlbums"])
    fun getAllAlbums(): ResponseEntity<*> {
        return try {
            ResponseEntity.ok(albumService.findAll())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body(ex.message)
        }
    }

    @PostMapping(value = ["/saveAllAlbums"])
    fun saveAllMusics(@RequestBody albums : MutableIterable<Album>): ResponseEntity<*> {
        return try {
//            ResponseEntity.ok(mutableListOf(albums.map { albumService.save(it) }))
            ResponseEntity.ok(albumService.saveAllEntities(albums))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body(ex.message)
        }
    }


}