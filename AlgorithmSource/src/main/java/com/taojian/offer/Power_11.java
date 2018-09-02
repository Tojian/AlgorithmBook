package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-02 14:39
 **/
public class Power_11 {

    public double powerWithUnsingedExponent(double base, int exponent) {

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = powerWithUnsingedExponent(base, exponent >> 1);
        result *= result;
        if (exponent % 2 == 1) {
            result *= base;
        }
        return result;
    }

}
