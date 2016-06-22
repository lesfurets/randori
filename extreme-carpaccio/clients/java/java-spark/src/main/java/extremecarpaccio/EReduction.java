/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package extremecarpaccio;

import static java.util.function.Function.identity;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum EReduction {

    STANDARD("STANDARD") {
        @Override
        public double getReductionFactor(double sumWithTax) {
            double reductionFactor;
            if (sumWithTax >= 50000) {
                reductionFactor = 0.85;
            } else if (sumWithTax >= 10000) {
                reductionFactor = 0.90;
            } else if (sumWithTax >= 70000) {
                reductionFactor = 0.93;
            } else if (sumWithTax >= 5000) {
                reductionFactor = 0.95;
            } else if (sumWithTax >= 1000) {
                reductionFactor = 0.97;
            } else {
                reductionFactor = 1;
            }
            return reductionFactor;
        }
    },
    HALF_PRICE("HALF PRICE") {
        @Override
        public double getReductionFactor(double sumWithTax) {
            return 0.5;
        }
    };

    private final static Map<String, EReduction> REDUCTION_BY_NAME = Arrays.stream(EReduction.values()) //
                    .collect(Collectors.toMap(EReduction::getName, identity()));

    private final String name;

    EReduction(String name) {
        this.name = name;
    }

    public abstract double getReductionFactor(double sumWithTax);

    public String getName() {
        return name;
    }

    public static EReduction fromName(String name) {
        return REDUCTION_BY_NAME.get(name);
    }
}
