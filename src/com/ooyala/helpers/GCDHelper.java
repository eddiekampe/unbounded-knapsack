package com.ooyala.helpers;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

public class GCDHelper {
    /***
     * Helper class that can calculate a greatest common divisor
     * Credits: http://rosettacode.org/wiki/Greatest_common_divisor
     */
    public int calculate(Integer value, List<Integer> values) {

        Stream<Integer> divisors = values.stream().map(v ->
            BigInteger.valueOf(v).gcd(BigInteger.valueOf(value)).intValue()
        );

        return divisors.reduce(value, Integer::min);
    }
}
