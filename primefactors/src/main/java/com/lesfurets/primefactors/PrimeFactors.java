/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package com.lesfurets.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public List<Integer> compute(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> res = new ArrayList<>();

        for (int j = 2; j < i-1 ; j++) {
            if(i%j==0){
                res.add(j);
            }else{
                continue;
            }
        }
        return res;
    }
}
