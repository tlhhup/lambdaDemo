package com.lambdaDemo.entity;

/**
 * 专辑中的一支曲目。
 * 
 * @author ping
 */
public class Track {

	private String name;// 曲目名称（例如《黄色潜水艇》）。
	private long length;// 曲目长度

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

}
