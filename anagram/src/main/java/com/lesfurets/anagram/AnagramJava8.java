/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.anagram;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class AnagramJava8 implements Anagram {
    private final Map<String, Map<Character, Long>> memo = new HashMap<>();

    @Override
    public Set<String> anagrams(String word, Set<String> candidates) {
        checkNotNull(word);

        String normalizedWord = word.toLowerCase();

        return candidates.stream()
            .map(String::toLowerCase)
            .filter(candidate -> notEquals(normalizedWord, candidate))
            .filter(candidate -> areAnagrams(normalizedWord, candidate))
            .collect(toSet());
    }

    private void checkNotNull(String word) {
        if(word == null) {
            throw new IllegalArgumentException();
        }
    }

    private boolean notEquals(String word, String candidate) {
        return !Objects.equals(word, candidate);
    }

    private boolean areAnagrams(String word, String candidate) {
        return Objects.equals(toCharFrequencies(word), toCharFrequencies(candidate));
    }

    private Map<Character, Long> toCharFrequencies(String candidate) {
        return memo.computeIfAbsent(candidate, word -> word.chars()
            .mapToObj(c -> (char) c)
            .collect(groupingBy(identity(), counting())));
    }
}
