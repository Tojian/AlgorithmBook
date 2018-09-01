package com.taojian.interview.huawei;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-29 20:28
 **/

import java.util.HashMap;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Complex[] an = new Complex[5];

        for (int i = 5; i > 0; i--) {
            double real = sc.nextDouble();
            double image;
            if (sc.hasNext()) {
                image = sc.nextDouble();
            } else {
                image = 0;
            }
            an[i] = new Complex(real, image);
        }

        Complex[] bn = new Complex[5];
        for (int i = 5; i > 0; i--) {
            double real = sc.nextDouble();
            double image;
            if (sc.hasNext()) {
                image = sc.nextDouble();
            } else {
                image = 0;
            }
            bn[i] = new Complex(real, image);
        }

        Complex[] cn = new Complex[9];
        for (int i = 9; i > 0; i--) {
            cn[i] = new Complex();
            for (int j = 5; j > 0; j--) {
                for (int m = 5; m > 0; m--) {
                    if (j + m - 1 == i) {
                        Complex c = Complex.mul(an[i], bn[j]);
                        double r = c.getReal();
                        double s = c.getImage();
                        double newR = cn[i].getReal() + r;
                        double newS = cn[i].getImage() + s;
                        cn[i] = new Complex(newR, newS);
                    }
                }
            }
        }
    }
}

class Complex {
    double real;  // 实部
    double image; // 虚部

    Complex() {  // 不带参数的构造方法
        Scanner input = new Scanner(System.in);
        double real = input.nextDouble();
        double image = input.nextDouble();
        Complex(real, image);
    }

    private void Complex(double real, double image) { // 供不带参数的构造方法调用
        // TODO Auto-generated method stub
        this.real = real;
        this.image = image;
    }

    Complex(double real, double image) { // 带参数的构造方法
        this.real = real;
        this.image = image;
    }

    static Complex mul(Complex a, Complex b) { // 复数相乘
        double real = a.getReal();
        double image = a.getImage();
        double real2 = b.getReal();
        double image2 = b.getImage();
        double newReal = real * real2 - image * image2;
        double newImage = image * real2 + real * image2;
        Complex result = new Complex(newReal, newImage);
        return result;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImage() {
        return image;
    }

    public void setImage(double image) {
        this.image = image;
    }

}

