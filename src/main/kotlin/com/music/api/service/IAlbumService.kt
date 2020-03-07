package com.music.api.service

import com.music.api.model.Album
import org.springframework.data.domain.Example
import org.springframework.data.domain.Sort
import java.util.*

interface IAlbumService {
    fun <S : Album?> save(entity: S): S
    fun findAll(): MutableList<Album>
    fun findAllWithSort(sort: Sort): MutableList<Album>
    fun <S : Album?> saveAndFlush(entity: S): S
    fun deleteAllEntities(entities: MutableIterable<Album>)
    fun deleteAll()
    fun <S : Album?> saveAllEntities(entities: MutableIterable<S>): MutableList<S>
    fun <S : Album?> findOne(example: Example<S>): Optional<S>
    fun count(): Long
    fun findAllById(ids: MutableIterable<Long>): MutableList<Album>
    fun <S : Album?> exists(example: Example<S>): Boolean
    fun delete(entity: Album)
    fun findById(id: Long): Optional<Album>
    fun existsById(id: Long): Boolean
    fun getOne(id: Long): Album
    fun deleteById(id: Long)
}
