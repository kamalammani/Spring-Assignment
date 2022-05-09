package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Song;
import com.example.demo.service.SongService;

@RestController
public class SongController {
	
	@Autowired
	private SongService songService;
	
	// Here all the required mappings are done with the help of SongService object
	
	@PostMapping("/newsong")
	//Creating a new song
	public String createNewSong(@RequestBody Song song){
		ResponseEntity.ok().body(this.songService.createSong(song));
		String playlist = song.getPlaylist();
		
		if(playlist!=null)
			//song created in PlayList
			return "New song is created and added in playlist - "+playlist;
		else
			//song created without PlayList
			return "New song is crearted";
	}
	
	
	@GetMapping("/songs/{songName}")
	//Search a song
	public ResponseEntity<Song> getSongByName(@PathVariable String songName){
		return ResponseEntity.ok().body(songService.getSongByName(songName));
	}
	
	@GetMapping("/songs")
	//View songs list
	public ResponseEntity<List<Song>> getAllSongs(){
		return ResponseEntity.ok().body(songService.getAllSongs());
	}
	
	
	@PutMapping("/songs/{id}")
	//Updating the song
	public ResponseEntity<Song> updateSong(@PathVariable int id,@RequestBody Song song){
		song.setSong_num(id);
		return ResponseEntity.ok().body(this.songService.updateSong(song)); 
	}
	
	@DeleteMapping("/songs/{id}")
	//Deleting the song
	public String deleteSong(@PathVariable int id){
		this.songService.deleteSong(id);
		return "song deleted";
	}
	
}
