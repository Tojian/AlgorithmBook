package com.taojian.interview.ali;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-02 19:38
 **/
public class Test {


    public static void main(String[] args) {
        //字符串实现
        for (int i = 1; i < 100; i++) {
            if ((i + "").indexOf("7") < 0 && (i + "").indexOf("4") < 0) {
                System.out.print(i + "\t");
            }
        }
        //非字符串实现
        for (int i = 1; i < 100; i++) {
            if ((i%10!=7 &&(i/10)%10!=7) && (i%10!=4 &&(i/10)%10!=4) ){
                System.out.print(i + "\t");
            }
        }
    }
}
