package com.lesfurets.primefactors;

import org.junit.Test;

public class PrimeFactorsTest {

    private PrimeFactors primeFactors = new PrimeFactors();

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgument_if_given_negative_number() throws Exception {
        primeFactors.compute(-1);
    }
}