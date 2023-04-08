package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {

	public static void main(String[] args) {

		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = groupAnagrams(strs);
		System.out.println(result);

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] sArray = s.toCharArray();
			Arrays.sort(sArray);
			String sorted = new String(sArray);
			map.putIfAbsent(sorted, new ArrayList<String>());
			map.get(sorted).add(s);
		}
		result.addAll(map.values());
		return result;
	}

}
