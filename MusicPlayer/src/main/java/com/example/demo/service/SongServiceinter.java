package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Song;

// interface of service part
public interface SongServiceinter {

	Song createSong(Song song);
	Song updateSong(Song song);
	List<Song> getAllSongs();
	Song getSongByName(String songName);
	void deleteSong(int id);
}
