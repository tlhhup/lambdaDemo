package com.lambdaDemo.entity;

import java.util.List;
import java.util.stream.Stream;

/**
 * ר������������Ŀ��ɡ�
 * 
 * @author ping
 */
public class Album {
	private String name;// ר���������硶������ǹ������
	private List<Track> tracks;// ר����������Ŀ���б�
	private List<Artist> musicians;// ���봴����ר�����������б�
	private Artist mainMusician;//����
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
	 * ��ȡ��ʽ�Ľ��
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
	 * ��ȡ��ʽ�Ľ��
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
