package com.music.api.service

import com.music.api.model.Album
import com.music.api.repository.AlbumRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*

@Service
class AlbumService(private val albumRepository: AlbumRepository) : IAlbumService {
    override fun <S : Album?> save(entity: S): S {
//        entity!!.listMusics.map { it.album = entity }
        return albumRepository.save(entity)
    }

    override fun findAll(): MutableList<Album> {
        return albumRepository.findAll()
    }

    override fun findAllWithSort(sort: Sort): MutableList<Album> {
        return albumRepository.findAll(sort)
    }

    override fun <S : Album?> saveAndFlush(entity: S): S {
        return albumRepository.saveAndFlush(entity)
    }

    override fun deleteAllEntities(entities: MutableIterable<Album>) {
        albumRepository.deleteAll(entities)
    }

    override fun deleteAll() {
        albumRepository.deleteAll()
    }

    override fun <S : Album?> saveAllEntities(entities: MutableIterable<S>): MutableList<S> {
//        entities.forEach { album ->
//            run {
//                album!!.listMusics.map { it.album = album }
//            }
//        }
        return albumRepository.saveAll(entities)
    }

    override fun <S : Album?> findOne(example: Example<S>): Optional<S> {
        return albumRepository.findOne(example)
    }

    override fun count(): Long {
        return albumRepository.count()
    }

    override fun findAllById(ids: MutableIterable<Long>): MutableList<Album> {
        return albumRepository.findAllById(ids)
    }

    override fun <S : Album?> exists(example: Example<S>): Boolean {
        return albumRepository.exists(example)
    }

    override fun delete(entity: Album) {
        albumRepository.delete(entity)
    }

    override fun findById(id: Long): Optional<Album> {
        return albumRepository.findById(id)
    }

    override fun existsById(id: Long): Boolean {
        return existsById(id)
    }

    override fun getOne(id: Long): Album {
        return getOne(id)
    }

    override fun deleteById(id: Long) {
        albumRepository.deleteById(id)
    }
}