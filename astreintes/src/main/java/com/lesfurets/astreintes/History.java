/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.astreintes;

import static com.lesfurets.astreintes.ECandidate.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class History {

    /**
     * This is a randomly generated history
     */
    static Map<LocalDate, ECandidate> HISTORY = new HashMap<LocalDate, ECandidate>() {
        {
            put(LocalDate.of(2016, 10, 3), MBO);
            put(LocalDate.of(2016, 10, 10), SPI);
            put(LocalDate.of(2016, 10, 17), AAR);
            put(LocalDate.of(2016, 10, 24), ADU);
            put(LocalDate.of(2016, 10, 31), MBE);
            put(LocalDate.of(2016, 11, 7), HVI);
            put(LocalDate.of(2016, 11, 14), SDI);
            put(LocalDate.of(2016, 11, 21), TDB);
            put(LocalDate.of(2016, 11, 28), SCO);
            put(LocalDate.of(2016, 12, 5), CMI);
            put(LocalDate.of(2016, 12, 12), MBO);
            put(LocalDate.of(2016, 12, 19), ADU);
            put(LocalDate.of(2016, 12, 26), SDI);
            put(LocalDate.of(2017, 1, 2), HVI);
            put(LocalDate.of(2017, 1, 9), SCO);
            put(LocalDate.of(2017, 1, 16), AAR);
            put(LocalDate.of(2017, 1, 23), SPI);
            put(LocalDate.of(2017, 1, 30), MBE);
            put(LocalDate.of(2017, 2, 6), SDI);
            put(LocalDate.of(2017, 2, 13), JMA);
            put(LocalDate.of(2017, 2, 20), AAR);
            put(LocalDate.of(2017, 2, 27), SPI);
            put(LocalDate.of(2017, 3, 6), ADU);
            put(LocalDate.of(2017, 3, 13), HVI);
            put(LocalDate.of(2017, 3, 20), CMI);
            put(LocalDate.of(2017, 3, 27), SCO);
            put(LocalDate.of(2017, 4, 3), TDB);
            put(LocalDate.of(2017, 4, 10), CMI);
            put(LocalDate.of(2017, 4, 17), SCO);
            put(LocalDate.of(2017, 4, 24), JMA);
            put(LocalDate.of(2017, 5, 1), HVI);
            put(LocalDate.of(2017, 5, 8), TDB);
            put(LocalDate.of(2017, 5, 15), AAR);
            put(LocalDate.of(2017, 5, 22), MBO);
            put(LocalDate.of(2017, 5, 29), SDI);
            put(LocalDate.of(2017, 6, 5), ADU);
            put(LocalDate.of(2017, 6, 12), SPI);
            put(LocalDate.of(2017, 6, 19), CMI);
            put(LocalDate.of(2017, 6, 26), MBE);
            put(LocalDate.of(2017, 7, 3), SDI);
            put(LocalDate.of(2017, 7, 10), MBO);
            put(LocalDate.of(2017, 7, 17), ADU);
            put(LocalDate.of(2017, 7, 24), AAR);
            put(LocalDate.of(2017, 7, 31), HVI);
            put(LocalDate.of(2017, 8, 7), SCO);
            put(LocalDate.of(2017, 8, 14), MBO);
            put(LocalDate.of(2017, 8, 21), AAR);
            put(LocalDate.of(2017, 8, 28), CMI);
            put(LocalDate.of(2017, 9, 4), TDB);
            put(LocalDate.of(2017, 9, 11), HVI);
            put(LocalDate.of(2017, 9, 18), SDI);
            put(LocalDate.of(2017, 9, 25), SCO);
        }
    };
}
