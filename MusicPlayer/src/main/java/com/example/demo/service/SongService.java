package com.example.demo.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.DuplicateSongExcception;
import com.example.demo.exception.EmptyListExcception;
import com.example.demo.exception.EmptySongExcception;
import com.example.demo.exception.SongNotFoundException;
import com.example.demo.model.Song;
import com.example.demo.repository.SongRepository;

@Service
@Transactional
public class SongService implements SongServiceinter {
	
	@Autowired
	private SongRepository songrepository;
	
	//All methods are implemented from the service interface
	
	@Override
	//create a new song
	public Song createSong(Song song) {
		
		String songname = song.getSong_name();
		
		if(songname == null) {
			//throwing Exception if song is null
			throw new EmptySongExcception();
		}
		
		List<Song> list = this.songrepository.findAll();
		boolean present = false;
	    for(int i=0;i<list.size();i++)
	    {
	    	if(songname.equalsIgnoreCase(list.get(i).getSong_name()))
	    	{
	    	   present = true;	
	    	}
	    }
		
	    if(present == true)
	    {
	    	//throwing Exception if song is already present
			throw new DuplicateSongExcception();
		}
	    else
	    	return songrepository.save(song);
	}
	
	@Override
	//Search song
	public Song getSongByName(String songName) {
		
        int id = -1;
        
        List<Song> list = new ArrayList<>();
        list = this.songrepository.findAll();
        
        // Finding song ID with song name
        for(int i=0;i<list.size();i++) {
        	if(list.get(i).getSong_name().equalsIgnoreCase(songName)) {
        		id = list.get(i).getSong_num();
        		break;
        	}
        }
        
        
        if(id!=-1) {
        	Optional<Song> songDB = this.songrepository.findById(id);
        	return songDB.get();
        }
        else {
        	//throwing Exception if song is not found
			throw new SongNotFoundException();
    	}
    }

	@Override
	// Update song
	public Song updateSong(Song song) {
		
		Optional<Song> songDB = this.songrepository.findById(song.getSong_num());
		
		if(songDB.isPresent()) {
			Song songUpdate = songDB.get();
			songUpdate.setSong_num(song.getSong_num());
			songUpdate.setSong_name(song.getSong_name());
			songUpdate.setLyricist(song.getLyricist());
			songUpdate.setSinger(song.getSinger());
			songrepository.save(songUpdate);
			return songUpdate;
		}
		else {
			//throwing Exception if song is not found
			throw new SongNotFoundException();
		}
	 }

	@Override
	// View All songs
	public List<Song> getAllSongs() {
		
		if(this.songrepository.findAll().isEmpty())
		{
			//throwing Exception if songList is empty
			throw new EmptyListExcception();
		}
		
		return this.songrepository.findAll();
	}

	@Override
	// delete song
	public void deleteSong(int id) {
		
		Optional<Song> songDB = this.songrepository.findById(id);
		if(songDB.isPresent()) {
			this.songrepository.delete(songDB.get());
		}
		else {
			//throwing Exception if song is not found
			throw new SongNotFoundException();
		}
	}
	
}
