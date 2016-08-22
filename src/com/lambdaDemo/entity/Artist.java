package com.lambdaDemo.entity;

import java.util.List;

/**
 * 创作音乐的个人或团队
 * @author ping
 */
public class Artist {
	private String name;// 艺术家的名字（例如“甲壳虫乐队”）。
	private List<Artist> members;// 乐队成员（例如“约翰 · 列侬”），该字段可为空。
	private String origin;// 乐队来自哪里（例如“利物浦”）。

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Artist> getMembers() {
		return members;
	}

	public void setMembers(List<Artist> members) {
		this.members = members;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
