package com.lesfurets.anagram;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class AnagramJava7Test {

    Anagram anagram = new AnagramJava7();

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


    @Test(expected = IllegalArgumentException.class)
    public void should_return_error_when_word_is_null() {
        // Given
        String word = null;
        Set<String> candidates = new HashSet<>(asList("hello", "world", "zombies", "pants"));

        // When
       anagram.anagrams(word, candidates);

    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_error_when_word_is_empty() {
        // Given
        String word = "";
        Set<String> candidates = new HashSet<>(asList("hello", "world", "zombies", "pants"));

        // When
         anagram.anagrams(word, candidates);
    }

    @Test
    public void should_return_anagram_when_anagram_present() throws Exception {
        // Given
        String word = "diaper";
        Set<String> candidates = new HashSet<>(asList("hello","perdia", "world", "zombies", "pants"));

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).containsOnly("perdia");
    }

    @Test
    public void should_not_return_the_word_itself() throws Exception {
        String word = "diaper";
        Set<String> candidates = new HashSet<>(asList("hello","diaper", "world", "zombies", "pants"));

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).isEmpty();
    }
}
