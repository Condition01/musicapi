package com.music.api.model

import javax.persistence.*

@Entity
@Table(name = "tbl_music")
data class Music(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "mus_id", nullable = false)
        val id: Long,
        @Column(name = "mus_name", nullable = false)
        val name: String,
        @Column(name = "mus_number", nullable = false)
        val number: Int,
        @ManyToOne
        @JoinColumn(name = "alb_id", nullable = false)
//        @Column(name = "mus_album_id", nullable = false)
        val album: Album)