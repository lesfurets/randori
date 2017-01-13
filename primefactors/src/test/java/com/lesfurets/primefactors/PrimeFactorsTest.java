package com.lesfurets.primefactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PrimeFactorsTest {

    private PrimeFactors primeFactors = new PrimeFactors();

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgument_if_given_negative_number() throws Exception {
        primeFactors.compute(-1);
    }

    @Test
    public void should_return_2_3_if_given_6() throws Exception {
        assertThat(primeFactors.compute(6)).containsExactly(2, 3);
    }

    @Test
    public void should_return_2_2_if_given_8() throws Exception {
        assertThat(primeFactors.compute(8)).containsExactly(2, 2, 2);
    }

}