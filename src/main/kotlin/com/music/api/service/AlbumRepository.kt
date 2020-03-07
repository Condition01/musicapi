package com.music.api.service

import com.music.api.model.Album
import org.springframework.data.jpa.repository.JpaRepository

interface AlbumRepository: JpaRepository<Album, Long>