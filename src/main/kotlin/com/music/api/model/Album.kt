package com.music.api.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "tbl_album")
class Album (
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "alb_id", nullable = false)
        val id: Long = 0L,
        @Column(name = "alb_name", nullable = false, length = 100)
        val name: String,
        @Column(name = "alb_year", nullable = false)
        val year: Int,
        @JsonManagedReference //bidirectional dependencies need this annotation in the OneToMany
        @OneToMany(mappedBy = "album", cascade = [CascadeType.PERSIST])
        @JsonProperty(value = "musics")
        @Column(name = "alb_music_id", nullable = false)
        val listMusics: MutableList<Music> = mutableListOf()
        ){
        init {
                if(listMusics.isNotEmpty()){
                        listMusics.map { it.album = this; it.albumName = this.name }
                }
        }
        override fun toString(): String = this.name
}