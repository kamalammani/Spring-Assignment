package com.example.demo.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "songs")

public class Song {
	
	//Required fields are below
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int song_num;
	
	@Column(name = "songname")
	private String song_name;
	
	@Column(name = "lyricist")
	private String lyricist;
	
	@Column(name = "singer")
	private String singer;
	
	@Column(name = "playlist")
	private String playlist;
	
	@CreationTimestamp
	private Date createdAt;
	
	
	//Getters and setters for the required fields
	public int getSong_num() {
		return song_num;
	}
	public void setSong_num(int song_num) {
		this.song_num = song_num;
	}
	public String getSong_name() {
		return song_name;
	}
	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}
	public String getLyricist() {
		return lyricist;
	}
	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getPlaylist() {
		return playlist;
	}
	public void setPlaylist(String playlist) {
		this.playlist = playlist;
	}
}
