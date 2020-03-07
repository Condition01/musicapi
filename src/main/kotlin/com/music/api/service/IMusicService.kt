package com.music.api.service

import com.music.api.model.Music
import org.springframework.data.domain.Example
import org.springframework.data.domain.Sort
import java.util.*
interface IMusicService {
    fun <S : Music?> save(entity: S): S
    fun findAll(): MutableList<Music>
    fun findAllWithSort(sort: Sort): MutableList<Music>
    fun <S : Music?> saveAndFlush(entity: S): S
    fun deleteAllEntities(entities: MutableIterable<Music>)
    fun deleteAll()
    fun <S : Music?> saveAllEntities(entities: MutableIterable<S>): MutableList<S>
    fun <S : Music?> findOne(example: Example<S>): Optional<S>
    fun count(): Long
    fun findAllById(ids: MutableIterable<Long>): MutableList<Music>
    fun <S : Music?> exists(example: Example<S>): Boolean
    fun delete(entity: Music)
    fun findById(id: Long): Optional<Music>
    fun existsById(id: Long): Boolean
    fun getOne(id: Long): Music
    fun deleteById(id: Long)
}