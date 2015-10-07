package com.lesfurets.anagram;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void should_return_itself() {
        String word = "lol";
        Set<String> candidate = new HashSet<>(Arrays.asList(word));
        assertThat(anagram.anagrams(word, candidate)).containsExactly(word);
    }

    @Test
    public void should_return_emptyset_for_word_null() {
        assertThat(anagram.anagrams(null, new HashSet<String>())).isEmpty();
    }

    @Test
    public void should_return_emptyset_for_candidates_null() {
        assertThat(anagram.anagrams("", null)).isEmpty();
    }

    @Test
    public void should_return_emptyset_when_candidates_doesnt_contain_anagram() {
        String word = "lol";
        Set<String> candidate = new HashSet<>(Arrays.asList("ooisua"));
        assertThat(anagram.anagrams(word, candidate)).isEmpty();
    }

    @Test
    public void should_find_anagram_of_word() {
        String word = "ab";
        Set<String> candidate = new HashSet<>(Arrays.asList("ba"));
        assertThat(anagram.anagrams(word, candidate)).containsExactly("ba");
    }

}