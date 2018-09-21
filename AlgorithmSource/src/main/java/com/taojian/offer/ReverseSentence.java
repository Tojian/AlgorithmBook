package com.taojian.offer;

/**
 * @description:
 * @author: taojian
 * @create: 2018-09-08 19:59
 * <p>
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * <p>
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 **/
public class ReverseSentence {

    public static void main(String[] args) {
        ReverseSentence reverseSentence = new ReverseSentence();
        System.out.println(reverseSentence.ReverseSentence(" "));
    }

    public String ReverseSentence(String str) {

        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }

        String[] temp = str.split(" ");

        int left = 0;

        int right = temp.length - 1;

        while (left < right) {

            swap(temp, left, right);

            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i] + " ");

        }
        return sb.toString().trim();
    }

    private void swap(String[] temp, int left, int right) {

        String change = temp[left];
        temp[left] = temp[right];
        temp[right] = change;

    }

}
