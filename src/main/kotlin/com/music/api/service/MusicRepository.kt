package com.music.api.service

import com.music.api.model.Music
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MusicRepository : JpaRepository<Music, Long>