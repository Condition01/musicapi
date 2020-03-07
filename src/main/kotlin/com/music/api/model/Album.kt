package com.music.api.model

import javax.persistence.*

@Entity
@Table(name = "tbl_album")
data class Album (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "alb_id", nullable = false)
        val id: Long,
        @Column(name = "alb_name", nullable = false, length = 100)
        val name: String,
        @Column(name = "alb_year", nullable = false)
        val year: Int,
        @OneToMany(mappedBy = "album")
//        @Column(name = "alb_music_id", nullable = false)
        val listMusics: MutableList<Music>
        )