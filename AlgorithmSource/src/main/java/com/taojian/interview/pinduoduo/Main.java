package com.taojian.interview.pinduoduo;

import java.util.Scanner;

/**
 * @description:
 * @author: taojian
 * @create: 2018-08-30 19:06
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hp = Integer.valueOf(sc.nextLine());
        int normal = Integer.valueOf(sc.nextLine());
        int attack = Integer.valueOf(sc.nextLine());
        int result = solution(hp, normal, attack);
        System.out.println(result);

    }

    public int getMinNumber(int sum, int normalAttack, int bufferedAttack) {
        if (sum < normalAttack) {
            return 1;
        }

        int result = Math.min(getMinNumber(sum - normalAttack, normalAttack, bufferedAttack), getMinNumber(sum -
                bufferedAttack, normalAttack, bufferedAttack));
        return 0;
    }

    public static int solution(int hp, int normal, int attack) {
        int result = 0;
        if (normal * 2 >= attack) {
            if (hp % normal == 0) {
                return hp / normal;
            } else {
                return hp / normal + 1;
            }
        } else {
            while (hp > attack) {
                hp -= attack;
                result += 2;
            }
            if (hp <= normal) {
                result++;
            } else {
                result += 2;
            }
        }
        return result;
    }

}
