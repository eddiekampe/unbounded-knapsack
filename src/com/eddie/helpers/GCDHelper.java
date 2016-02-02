package com.eddie.helpers;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

public class GCDHelper {
    /***
     * Helper class that can calculate a greatest common divisor
     * Credits: http://rosettacode.org/wiki/Greatest_common_divisor
     */
    public static int calculate(Integer value, List<Integer> values) {

        Stream<Integer> divisors = values.stream().map(v ->
            BigInteger.valueOf(v).gcd(BigInteger.valueOf(value)).intValue()
        );

        // Make sure to run GCD between the divisors as well
        return divisors.reduce(value, (a, b) -> BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue());
    }
}
