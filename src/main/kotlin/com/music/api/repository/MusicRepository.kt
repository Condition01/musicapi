package com.music.api.repository

import com.music.api.model.Music
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MusicRepository : JpaRepository<Music, Long>