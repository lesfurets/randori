/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.anagram;

import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class AnagramJava8 implements Anagram {

    @Override
    public Set<String> anagrams(String word, Set<String> candidates) {
        checkNotNull(word);

        String normalizedWord = word.toLowerCase();
        Map<Map<Character, Long>, List<String>> allAnagrams = computeLists(candidates);
        return allAnagrams.getOrDefault(toCharFrequencies(normalizedWord), emptyList())
                        .stream()
                        .filter(candidate -> notEquals(normalizedWord, candidate))
                        .collect(toSet());
    }

    private Map<Map<Character, Long>, List<String>> computeLists(Set<String> candidates) {
        return candidates.stream()
                        .map(String::toLowerCase)
                        .collect(groupingBy(this::toCharFrequencies, toList()));
    }

    private void checkNotNull(String word) {
        if(word == null) {
            throw new IllegalArgumentException();
        }
    }

    private boolean notEquals(String word, String candidate) {
        return !Objects.equals(word, candidate);
    }

    private Map<Character, Long> toCharFrequencies(String candidate) {
        return candidate.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), counting()));
    }

}
