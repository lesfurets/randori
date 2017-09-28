/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.astreintes;

public class Candidature {

    final int week;
    final ECandidate[] candidates;

    public Candidature(int week, ECandidate... candidates) {
        this.week = week;
        this.candidates = candidates;
    }
}
