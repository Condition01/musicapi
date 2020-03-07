package com.music.api.service

import com.music.api.model.Music
import org.springframework.data.domain.Example
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*

@Service
class MusicService(private val musicRepository: MusicRepository): IMusicService {
    override fun <S : Music?> save(entity: S): S {
        return musicRepository.save(entity)
    }

    override fun findAll(): MutableList<Music> {
        return musicRepository.findAll()
    }

    override fun findAllWithSort(sort: Sort): MutableList<Music> {
        return musicRepository.findAll(sort)
    }
    override fun <S : Music?> saveAndFlush(entity: S): S {
        return musicRepository.saveAndFlush(entity)
    }

    override fun deleteAllEntities(entities: MutableIterable<Music>) {
        musicRepository.deleteAll(entities)
    }

    override fun deleteAll() {
        musicRepository.deleteAll()
    }

    override fun <S : Music?> saveAllEntities(entities: MutableIterable<S>): MutableList<S> {
        return musicRepository.saveAll(entities)
    }

    override fun <S : Music?> findOne(example: Example<S>): Optional<S> {
        return musicRepository.findOne(example)
    }

    override fun count(): Long {
        return musicRepository.count()
    }

    override fun findAllById(ids: MutableIterable<Long>): MutableList<Music> {
        return musicRepository.findAllById(ids)
    }

    override fun <S : Music?> exists(example: Example<S>): Boolean {
        return musicRepository.exists(example)
    }

    override fun delete(entity: Music) {
        musicRepository.delete(entity)
    }

    override fun findById(id: Long): Optional<Music> {
        return musicRepository.findById(id)
    }

    override fun existsById(id: Long): Boolean {
        return existsById(id)
    }

    override fun getOne(id: Long): Music {
        return getOne(id)
    }

    override fun deleteById(id: Long) {
        musicRepository.deleteById(id)
    }
}
