package com.lambdaDemo.entity;

import java.util.List;

/**
 * ר������������Ŀ��ɡ�
 * @author ping
 */
public class Album {
	private String name;// ר���������硶������ǹ������
	private List<Track> tracks;// ר����������Ŀ���б�
	private List<Artist> musicians;// ���봴����ר�����������б�

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
