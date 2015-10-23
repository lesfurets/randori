package com.lesfurets.anagram;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.junit.Ignore;
import org.junit.Test;

public class AnagramJava7Test {

    Anagram anagram = new AnagramJava7();

    @Test
    public void should_return_nothing_when_no_anagram_in_candidates() throws Exception {
        // Given
        String word = "diaper";
        Set<String> candidates = new HashSet<>(asList("helloo", "world", "zombies", "pants"));

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).isEmpty();
    }

    @Test
    public void should_detect_simple_anagram_with_no_repeated_letters() {
        // Given
        String word = "listen";
        Set<String> candidates = Collections.singleton("inlets");

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).containsOnly("inlets");
    }

    @Test
    public void should_not_return_itself() {
        // Given
        String word = "hello";
        Set<String> candidates = Collections.singleton("hello");

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).isEmpty();
    }

    @Test
    public void should_return_nothing_when_same_letters_different_repetition() throws Exception {
        // Given
        String word = "helllo";
        Set<String> candidates = new HashSet<>(Collections.singletonList("helloo"));

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).isEmpty();
    }

}