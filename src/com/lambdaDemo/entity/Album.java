package com.lambdaDemo.entity;

import java.util.List;

/**
 * 专辑，由若干曲目组成。
 * @author ping
 */
public class Album {
	private String name;// 专辑名（例如《左轮手枪》）。
	private List<Track> tracks;// 专辑上所有曲目的列表。
	private List<Artist> musicians;// 参与创作本专辑的艺术家列表。

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public List<Artist> getMusicians() {
		return musicians;
	}

	public void setMusicians(List<Artist> musicians) {
		this.musicians = musicians;
	}
}
