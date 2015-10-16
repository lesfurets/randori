import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.junit.Test;

public class AnagramJava7Test {

    Anagram anagram = new AnagramJava7();

    @Test
    public void should_return_emptyset_when_candidates_doesnt_contain_anagram() {
        String word = "lol";
        Set<String> candidate = new HashSet<>(Arrays.asList("ooisua"));
        assertThat(anagram.anagrams(word, candidate)).isEmpty();
    }

    @Test
    public void should_not_return_word_when_candidate_contains_word() {
        String word = "lol";
        Set<String> candidate = new HashSet<>(Arrays.asList("llo", "lol"));
        assertThat(anagram.anagrams(word, candidate)).containsExactly("llo");
    }

    @Test
    public void should_return_empty_set_when_same_length_and_different_letters() {
        String word = "lol";
        Set<String> candidate = new HashSet<>(Arrays.asList("abc"));
        assertThat(anagram.anagrams(word, candidate)).isEmpty();
    }

    @Test
    public void should_not_return_candidates_when_lengths_differ() {
        String word = "aa";
        Set<String> candidate = new HashSet<>(Arrays.asList("a"));
        assertThat(anagram.anagrams(word, candidate)).isEmpty();
    }

    @Test
    public void should_return_empty_set_when_some_letters_are_missing() {
        String word = "lol";
        Set<String> candidate = new HashSet<>(Arrays.asList("lll"));
        assertThat(anagram.anagrams(word, candidate)).isEmpty();
    }



}
