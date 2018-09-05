package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-05 16:05
 * <p>
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 **/
public class UglyNumber_34 {

    public static void main(String[] args) {
        UglyNumber_34 uglyNumber_34 = new UglyNumber_34();
        System.out.println(uglyNumber_34.getUglyNumber_Solution2(10));
    }

    public int getUglyNumber_Solution2(int index) {
        if (index < 0) {
            return 0;
        }
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        for (int i = 1; i < index; i++) {
            int min = min(uglyArray[multiply2] * 2, uglyArray[multiply3] * 3, uglyArray[multiply5] * 5);
            uglyArray[i] = min;
            while (uglyArray[multiply2] * 2 == uglyArray[i]) {
                multiply2++;
            }
            while (uglyArray[multiply3] * 3 == uglyArray[i]) {
                multiply3++;
            }
            while (uglyArray[multiply5] * 5 == uglyArray[i]) {
                multiply5++;
            }
        }
        return uglyArray[index - 1];
    }

    public int min(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        return min < number3 ? min : number3;
    }

}
