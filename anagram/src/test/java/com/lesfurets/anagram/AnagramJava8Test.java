package com.lesfurets.anagram;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.catchThrowable;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class AnagramJava8Test {

    Anagram anagram = new AnagramJava8();

    @Test
    public void should_return_nothing_when_no_anagram_in_candidates() throws Exception {
        // Given
        String word = "diaper";
        Set<String> candidates = setOf("hello", "world", "zombies", "pants");

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).isEmpty();
    }

    private static HashSet<String> setOf(String... strings) {
        return new HashSet<>(asList(strings));
    }

    @Test
    public void should_detect_anagram_in_candidate() {
        // Given
        String word = "listen";
        Set<String> candidates =
            setOf("google", "inlets", "banana");

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).containsOnly("inlets");
    }

    @Test
    public void should_not_detect_itself() {
        // Given
        String word = "diaper";
        Set<String> candidates = setOf("diaper");

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).isEmpty();
    }

    @Test
    public void should_not_be_case_sensitive() {
        // Given
        String word = "liSteN";
        Set<String> candidates =
            setOf("google", "inLets", "banana");

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).containsOnly("inlets");
    }

    @Test
    public void should_not_detect_word_with_same_letters_but_different_frequencies() {
        // Given
        String word = "listen";
        Set<String> candidates =
            setOf("google", "enlists", "banana");

        // When
        Set<String> anagrams = anagram.anagrams(word, candidates);

        // Then
        assertThat(anagrams).isEmpty();
    }

    @Test
    public void should_raise_exception_when_null_is_passed() {
        // When
        Throwable exception = catchThrowable(() -> anagram.anagrams(null, new HashSet<>()));

        // Then
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }
}
