package com.music.api.model

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "tbl_music")
data class Music(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(name = "mus_number", nullable = false)
        val number: Int,
        @Column(name = "mus_name", nullable = false)
        val name: String,
        @JsonBackReference //bidirectional dependencies need this annotation in the ManyToOneSide
        @ManyToOne
        @JoinColumn(name = "alb_id", nullable = false)
        var album: Album?,
        @JsonProperty(value = "album_name")
        var albumName : String?
        )