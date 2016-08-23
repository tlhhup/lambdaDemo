package com.lambdaDemo.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lambdaDemo.entity.Album;
import com.lambdaDemo.entity.Artist;
import com.lambdaDemo.entity.Track;

public class FileterAndCount {

	public static void main(String[] args) {
		// filterCountry();
		String src = "hHHHJHfasdHJHH";
		System.out.println(countUpcase(src));
	}

	public static void filterCountry() {
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

	public static void convertor() {
		List<String> collected = Stream.of("a", "b", "HelloH").map(str -> str.toUpperCase())
				.collect(Collectors.toList());
	}

	/**
	 * 找出专辑中曲目长度大于1分钟的曲目名称
	 * 
	 * @return
	 */
	public static Set<String> findLongTracks(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getStreamTracks())// 得到所有的曲目stream
				.filter(track -> track.getLength() > 60)// 得到所有曲目长度大于60的曲目stream
				.map(track -> track.getName())// 得到所有的曲目的名称stream
				.collect(Collectors.toSet());
	}

	/**
	 * 找出专辑中所有乐队的国籍
	 * 
	 * @param album
	 * @return
	 */
	public static Set<String> getNationality(Album album) {
		return album.getStreamMusicans().filter(artist -> artist.getName().startsWith("The"))// 找出所有的乐队
				.map(artist -> artist.getNationality())// 获取国籍的stream
				.collect(Collectors.toSet());// 将stream转化为set集合
	}

	/**
	 * 求和
	 * 
	 * @param numbers
	 * @return
	 */
	public static int addUp(Stream<Integer> numbers) {
		return numbers.reduce(0, (acc, element) -> {
			return acc + element;
		});
	}

	/**
	 * 统计小写字母的个数
	 * 
	 * @param src
	 * @return
	 */
	public static long countUpcase(String src) {
		return src.chars().filter(c -> c >= 'a' && c <= 'z').count();
	}

	/**
	 * 统计曲目的长度
	 * 
	 * @param album
	 */
	public static void printTrackLengthStatistics(Album album) {
		LongSummaryStatistics statistics = album.getStreamTracks().mapToLong(Track::getLength)// .mapToLong(track->track.getLength())//
				.summaryStatistics();
		statistics.getAverage();// 获取平均值
	}

	/**
	 * 找出成员最多的乐队
	 * 
	 * @param artist
	 * @return
	 */
	public static Optional<Artist> biggestGroup(Stream<Artist> artists) {
		artists.collect(Collectors.toCollection(TreeSet::new));
		// 定义一个方法
		Function<Artist, Integer> getCount = artist -> artist.getMembers().size();
		return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
	}

	/**
	 * 分块
	 * 
	 * @param artists
	 * @return
	 */
	public static Map<Boolean, List<Artist>> bandsAndSoloRef(Stream<Artist> artists) {
		return artists.collect(Collectors.partitioningBy(artist -> artist.getName().startsWith("The")));
	}

	/**
	 * 分组
	 * 
	 * @param artists
	 * @return
	 */
	public static Map<Boolean, List<Artist>> albumsByArtist(Stream<Artist> artists) {
		return artists.collect(Collectors.groupingBy(artist -> artist.getName().startsWith("The")));
	}

	/**
	 * 计算每个艺术家的专辑数
	 * 
	 * @return
	 */
	public static Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
		return albums.collect(Collectors.groupingBy(Album::getMainMusician, Collectors.counting()));
	}

}
