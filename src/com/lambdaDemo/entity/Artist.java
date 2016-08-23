package com.lambdaDemo.entity;

import java.util.List;

/**
 * �������ֵĸ��˻��Ŷ�
 * @author ping
 */
public class Artist {
	private String name;// �����ҵ����֣����硰�׿ǳ��ֶӡ�����
	private List<Artist> members;// �ֶӳ�Ա�����硰Լ�� �� ��ٯ���������ֶο�Ϊ�ա�
	private String origin;// �ֶ�����������硰�����֡�����
	private String nationality;

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
	
	/**
	 * �жϹ���
	 * @param address
	 * @return
	 */
	public boolean isForm(String address){
		return this.origin.equals(address);
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}
