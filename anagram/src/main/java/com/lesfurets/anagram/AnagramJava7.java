/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.anagram;

import java.util.*;

public class AnagramJava7 implements Anagram {

    @Override
    public Set<String> anagrams(String word, Set<String> candidates) {
        Set<String> results = new HashSet<>();
        for (String candidate : candidates) {
            if (isAnagram(word, candidate)) {
                results.add(candidate);
            }
        }
        return results;
    }

    private boolean isAnagram(String word, String candidate) {
        if (word.equals(candidate)) {
            return false;
        }
        char[] wordChars = word.toCharArray();
        char[] candidateChars = candidate.toCharArray();
        Arrays.sort(wordChars);
        Arrays.sort(candidateChars);
        return Arrays.equals(wordChars, candidateChars);
    }

}
