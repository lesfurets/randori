/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.anagram;

import java.util.Set;

public interface Anagram {
    Set<String> anagrams(String word, Set<String> candidates);
}
