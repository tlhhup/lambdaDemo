package com.lambdaDemo.entity;

import java.util.List;
import java.util.stream.Stream;

/**
 * 专辑，由若干曲目组成。
 * 
 * @author ping
 */
public class Album {
	private String name;// 专辑名（例如《左轮手枪》）。
	private List<Track> tracks;// 专辑上所有曲目的列表。
	private List<Artist> musicians;// 参与创作本专辑的艺术家列表。
	private Artist mainMusician;//主唱
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	/**
	 * 获取流式的结果
	 * @return
	 */
	public Stream<Track> getStreamTracks() {
		return this.tracks.stream();
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public List<Artist> getMusicians() {
		return musicians;
	}
	
	/**
	 * 获取流式的结果
	 * @return
	 */
	public Stream<Artist> getStreamMusicans(){
		return this.musicians.stream();
	}

	public void setMusicians(List<Artist> musicians) {
		this.musicians = musicians;
	}

	public Artist getMainMusician() {
		return mainMusician;
	}

	public void setMainMusician(Artist mainMusician) {
		this.mainMusician = mainMusician;
	}
}
