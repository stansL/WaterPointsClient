package com.bespoke.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class is a utility class for sorting the entries of a Java @see {@link Map}
 * Naturally, running a sort on a {@link Collection} using {@link Collections#sort(List)} would sort the 
 * collection by its natural ordering. Similarly, a map is sorted by its natural ordering on the key. However,
 * the motive of this class is to sort the supplied map based on the values and no the keys in a generic manner
 * @author Stanslaus
 *
 */
public class ValueComparator {
	/**
	 * Generic method to sort the supplied {@link Map} based on the value entries
	 * @param map The supplied map that is to be sorted
	 * @return {@link Map} object with the entries sorted by the value and not the key as it would naturally occur
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(
			Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
