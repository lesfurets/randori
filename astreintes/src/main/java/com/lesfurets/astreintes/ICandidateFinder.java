/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.astreintes;

import java.util.Map;

public interface ICandidateFinder {

    /**
     * @param candidates
     * @return the candidate who had the oldest astreinte in history
     */
    ECandidate findOldestCandidate(ECandidate... candidates);

    /**
     * @param candidatures
     * @return the selected candidate by week
     */
    Map<Integer, ECandidate> findCandidateByWeek(Candidature... candidatures);
}
