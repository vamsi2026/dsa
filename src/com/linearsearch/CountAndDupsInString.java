package com.linearsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountAndDupsInString {

	static void finCountAndDupsInStr(String name) {

		HashMap<Character, Integer> map = new HashMap<>();
		if (name == null) {
			System.out.println("Given string is null");
		} else {
			name = name.toLowerCase();

			for (char ch : name.toCharArray()) {
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}
			
			System.out.println("map:"+map);

			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue() > 1) {
					System.out.println(entry.getKey() + " : " + entry.getValue());
				}
			}

		}
	}

	public static void main(String[] args) {

		String name = "vamsikrishna";

		// Converts the string to lowercase to ensure case-sensitive counting.
		name.trim().toLowerCase()
				// Converts string into an intStream of Unicode values.
				.chars()
				// Converts each Unicode value (integer) into a Character object, making it
				// compatible with Collectors.groupingBy
				.mapToObj(c -> (char) c)
				// Group Characters (Function.identity() means use the character itself as the
				// key).
				// Count occurrences using collectors.counting().
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				// Converts the map into a stream of key-value pairs.
				.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

		System.out.println();

		IntStream.range(0, name.length()) // Generate Indices
				.mapToObj(i -> name.trim().toLowerCase().charAt(i)) // Convert index to actual character
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Counts occurrences of
																							// each character.
				.entrySet().stream() // convert a Map into a Stream of key-value pairs.
				.filter(e -> e.getValue() > 1) // Filters only duplicate characters.
				.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue())); // Prints the duplicate characters
																						// and their counts.

		System.out.println();
		finCountAndDupsInStr(name);

	}

}
