package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-02 14:39
 **/
public class Power_11 {

    public static double powerWithUnsingedExponent(double base, int exponent) {

        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0){
            base = 1 /base;
        }
        if (Math.abs(exponent) == 1) {
            return base;
        }

        double result = powerWithUnsingedExponent(base, exponent >> 1);
        result *= result;
        if (Math.abs(exponent) % 2 == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        powerWithUnsingedExponent(2 , -3);
    }

}
