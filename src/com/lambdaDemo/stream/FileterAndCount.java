package com.lambdaDemo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lambdaDemo.entity.Artist;

public class FileterAndCount {

	public static void main(String[] args) {
		String[] address = { "成都", "贵阳", "北京" };
		Random random = new Random();
		List<Artist> artists = new ArrayList<Artist>();
		Artist artist;
		for (int i = 0; i < 50; i++) {
			artist = new Artist();
			artist.setName("第" + (i + 1) + "个数据");
			artist.setOrigin(address[random.nextInt(address.length)]);

			artists.add(artist);
			artist = null;
		}
		// 获取流
		long count = artists.stream().filter(a -> {
			System.out.println(a.getName());
			return a.isForm("成都");
		}).count();
		System.out.println(count);
	}
	
	public static void convertor(){
		List<String> collected=Stream.of("a","b","HelloH").map(str->str.toUpperCase()).collect(Collectors.toList());
	}

}
