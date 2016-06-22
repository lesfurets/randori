/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package extremecarpaccio;

import static java.util.function.Function.identity;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum ECountryTax {

    GERMANY("DE", 1.20),
    UNITED_KINGDOM("UK", 1.21),
    FRANCE("FR", 1.20),
    ITALY("IT", 1.25),
    SPAIN("ES", 1.19),
    POLAND("PL", 1.21),
    ROMANIA("RO", 1.20),
    NETHERLANDS("NL", 1.20),
    BELGIUM("BE", 1.24),
    GREECE("EL", 1.20),
    CZECH_REPUBLIC("CZ", 1.19),
    PORTUGAL("PT", 1.23),
    HUNGARY("HU", 1.27),
    SWEDEN("SE", 1.23),
    AUSTRIA("AT", 1.22),
    BULGARIA("BG", 1.21),
    DENMARK("DK", 1.21),
    FINLAND("FI", 1.17),
    SLOVAKIA("SK", 1.18),
    IRELAND("IE", 1.21),
    CROATIA("HR", 1.23),
    LITHUANIA("LT", 1.23),
    SLOVENIA("SI", 1.24),
    LATVIA("LV", 1.20),
    ESTONIA("EE", 1.22),
    CYPRUS("CY", 1.21),
    LUXEMBOURG("LU", 1.25),
    MALTA("MT", 1.20);

    private final static Map<String, ECountryTax> COUNTRY_TAX_BY_COUNTRY_CODE = Arrays.stream(ECountryTax.values()) //
                        .collect(Collectors.toMap(ECountryTax::getCountryCode, identity()));

    private final String countryCode;
    private final double taxFactor;

    ECountryTax(String countryCode, double taxFactor) {
        this.countryCode = countryCode;
        this.taxFactor = taxFactor;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public double getTaxFactor() {
        return taxFactor;
    }

    public static ECountryTax fromCountryCode(String countryCode) {
        return COUNTRY_TAX_BY_COUNTRY_CODE.get(countryCode);
    }
}
