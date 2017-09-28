/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.astreintes;

public enum ECandidate {

    AAR("aar"),
    ADU("adu"),
    CMI("cmi"),
    DBA("dba"),
    HVI("hvi"),
    GDU("gdu"),
    @Deprecated
    JMA("jma"),
    MBE("mbe"),
    MBO("mbo"),
    SCO("sco"),
    SDI("sdi"),
    SPI("spi"),
    @Deprecated
    TDB("tdb"),;

    final String code;

    ECandidate(String code) {
        this.code = code;
    }
}
