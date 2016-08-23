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
		String[] address = { "�ɶ�", "����", "����" };
		Random random = new Random();
		List<Artist> artists = new ArrayList<Artist>();
		Artist artist;
		for (int i = 0; i < 50; i++) {
			artist = new Artist();
			artist.setName("��" + (i + 1) + "������");
			artist.setOrigin(address[random.nextInt(address.length)]);

			artists.add(artist);
			artist = null;
		}
		// ��ȡ��
		long count = artists.stream().filter(a -> {
			System.out.println(a.getName());
			return a.isForm("�ɶ�");
		}).count();
		System.out.println(count);
	}

	public static void convertor() {
		List<String> collected = Stream.of("a", "b", "HelloH").map(str -> str.toUpperCase())
				.collect(Collectors.toList());
	}

	/**
	 * �ҳ�ר������Ŀ���ȴ���1���ӵ���Ŀ����
	 * 
	 * @return
	 */
	public static Set<String> findLongTracks(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getStreamTracks())// �õ����е���Ŀstream
				.filter(track -> track.getLength() > 60)// �õ�������Ŀ���ȴ���60����Ŀstream
				.map(track -> track.getName())// �õ����е���Ŀ������stream
				.collect(Collectors.toSet());
	}

	/**
	 * �ҳ�ר���������ֶӵĹ���
	 * 
	 * @param album
	 * @return
	 */
	public static Set<String> getNationality(Album album) {
		return album.getStreamMusicans().filter(artist -> artist.getName().startsWith("The"))// �ҳ����е��ֶ�
				.map(artist -> artist.getNationality())// ��ȡ������stream
				.collect(Collectors.toSet());// ��streamת��Ϊset����
	}

	/**
	 * ���
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
	 * ͳ��Сд��ĸ�ĸ���
	 * 
	 * @param src
	 * @return
	 */
	public static long countUpcase(String src) {
		return src.chars().filter(c -> c >= 'a' && c <= 'z').count();
	}

	/**
	 * ͳ����Ŀ�ĳ���
	 * 
	 * @param album
	 */
	public static void printTrackLengthStatistics(Album album) {
		LongSummaryStatistics statistics = album.getStreamTracks().mapToLong(Track::getLength)// .mapToLong(track->track.getLength())//
				.summaryStatistics();
		statistics.getAverage();// ��ȡƽ��ֵ
	}

	/**
	 * �ҳ���Ա�����ֶ�
	 * 
	 * @param artist
	 * @return
	 */
	public static Optional<Artist> biggestGroup(Stream<Artist> artists) {
		artists.collect(Collectors.toCollection(TreeSet::new));
		// ����һ������
		Function<Artist, Integer> getCount = artist -> artist.getMembers().size();
		return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
	}

	/**
	 * �ֿ�
	 * 
	 * @param artists
	 * @return
	 */
	public static Map<Boolean, List<Artist>> bandsAndSoloRef(Stream<Artist> artists) {
		return artists.collect(Collectors.partitioningBy(artist -> artist.getName().startsWith("The")));
	}

	/**
	 * ����
	 * 
	 * @param artists
	 * @return
	 */
	public static Map<Boolean, List<Artist>> albumsByArtist(Stream<Artist> artists) {
		return artists.collect(Collectors.groupingBy(artist -> artist.getName().startsWith("The")));
	}

	/**
	 * ����ÿ�������ҵ�ר����
	 * 
	 * @return
	 */
	public static Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
		return albums.collect(Collectors.groupingBy(Album::getMainMusician, Collectors.counting()));
	}

}
