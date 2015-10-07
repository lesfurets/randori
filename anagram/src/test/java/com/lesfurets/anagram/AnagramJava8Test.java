package com.lesfurets.anagram;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AnagramJava8Test {

    Anagram anagram = new AnagramJava8();

    @Test
    public void should_return_nothing_when_no_anagram_in_candidates() throws Exception {
        // Given
        String word = "diaper";
        Set<String> candidates = new HashSet<>(asList("hello", "world", "zombies", "pants"));

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).isEmpty();
    }
}