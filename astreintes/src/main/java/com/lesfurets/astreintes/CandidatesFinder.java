/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.astreintes;

import java.time.LocalDate;
import java.util.Map;

public class CandidatesFinder implements ICandidateFinder {

    final Map<LocalDate, ECandidate> history;

    public CandidatesFinder(Map<LocalDate, ECandidate> history) {
        this.history = history;
    }

    @Override
    public ECandidate findOldestCandidate(ECandidate... candidates) {
        return null;
    }

    @Override
    public Map<Integer, ECandidate> findCandidateByWeek(Candidature... candidatures) {
        return null;
    }
}
