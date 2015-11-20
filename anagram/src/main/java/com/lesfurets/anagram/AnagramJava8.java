/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.anagram;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

import java.util.*;

public class AnagramJava8 implements Anagram {

    @Override
    public Set<String> anagrams(String word, Set<String> candidates) {
        checkNotNull(word);

        String normalizedWord = word.toLowerCase();

        final Map<Map<Character, Long>, List<String>> allAnagrams = computeLists(candidates);

        return allAnagrams.getOrDefault(toCharFrequencies(normalizedWord), Collections.<String> emptyList())
                        .stream()
                        .filter(candidate -> notEquals(normalizedWord, candidate))
                        .collect(toSet());
    }

    private Map<Map<Character, Long>, List<String>> computeLists(Set<String> candidates) {

        return candidates.stream()
                        .map(String::toLowerCase)
                        .map(candidate -> new Pair<>(toCharFrequencies(candidate), candidate))
                        .collect(groupingBy(Pair::getT1,
                                        mapping(Pair::getT2, toList())));
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

    public static class Pair<T1, T2> {

        private T1 t1;
        private T2 t2;

        Pair(T1 t1, T2 t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        public T1 getT1() {
            return t1;
        }

        public T2 getT2() {
            return t2;
        }
    }
}
