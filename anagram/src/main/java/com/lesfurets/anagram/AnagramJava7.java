/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.anagram;

import java.util.*;

public class AnagramJava7 implements Anagram {


    @Override
    public Set<String> anagrams(final String word, Set<String> candidates) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word is null or empty!");
        }

        Set<String> result = new HashSet<>();
        Map<Character, Integer> wordCharsFrequency = toCharsFrequency(word);

        for (String candidate : candidates) {
            final Map<Character, Integer> candidateCharsFrequency = toCharsFrequency(candidate);
            if (wordCharsFrequency.equals(candidateCharsFrequency) && !word.equals(candidate)) {
                result.add(candidate);
            }
        }

        return result;
    }

    private Map<Character, Integer> toCharsFrequency(String word) {
        Map<Character, Integer> charsFrequency = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (!charsFrequency.containsKey(c)) {
                charsFrequency.put(c, 0);
            }
            charsFrequency.put(c, charsFrequency.get(c) + 1);
        }
        return charsFrequency;
    }
}
