package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Song;

// Repository part extends JpaRepositort
public interface SongRepository extends JpaRepository<Song,Integer>{

}
