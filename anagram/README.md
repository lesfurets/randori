# Anagram

## TL;DR;

Given `"listen"` and a list of candidates like `"enlists" "google" "inlets" "banana"` the program should return a list containing `"inlets"`.

## Long version

Anagram : A word formed from another by rearranging its letters: `"Angel"` is an anagram of `"glean"`.

* A word is not an anagram of itself
* Anagrams are case insensitive
* Program should return nothing when any candidate is an anagram of the given word.
* Program should detect simple anagram, i.e. `"listen"` is an anagram of `"inlets"`.
* Program should detect complex anagram with characters duplication, i.e. `"gallery"` is an anagram of `"allergy"`.
* Program should detect all anagrams of a given word, i.e. given word `"master"` and candidates `"stream" "pigeon" "maters"`, the result should be `"maters" "stream"`.

Open questions :

* How manage invalid inputs ? (null inputs or empty word)
