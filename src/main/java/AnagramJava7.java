/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */

import static java.util.Collections.emptySet;

import java.util.*;

public class AnagramJava7 implements Anagram {

    @Override
    public Set<String> anagrams(String word, Set<String> candidates) {
        if (word == null || candidates == null) {
            return emptySet();
        }

        Set<String> result = new HashSet<>();
        for (String candidate : candidates) {
            if (isAnagram(word, candidate)) {
                result.add(candidate);
            }
        }
        return result;
    }

    private boolean isAnagram(String word, String candidate) {
         return word.length()==candidate.length();
    }
}