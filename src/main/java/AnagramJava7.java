/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */

import java.util.*;

public class AnagramJava7 implements Anagram {

    @Override
    public Set<String> anagrams(String word, Set<String> candidates) {
        Set<String> anagrams = new HashSet<>();
        for (String candidate : candidates) {
            if (!word.equals(candidate)
                            && containsSameLetters(word, candidate)
                            && containsSameLetters(candidate, word)) {
                anagrams.add(candidate);
            }
        }
        return anagrams;
    }

    private boolean containsSameLetters(String a, String b) {
        for (char letter : b.toCharArray()) {
            if (!a.contains(letter + "")) {
                return false;
            }
        }
        return true;
    }

}