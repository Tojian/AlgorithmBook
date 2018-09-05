package com.taojian.offer;

/**
 * 替换字符串
 * <p>
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

public class ReplaceBlank {

    public static void main(String[] args) {
        System.out.println(replaceSubStringForJava("We Are Happy"));
        System.out.println(replaceSubStringForSimpleMethod("We Are Happy").toString());

    }

    public static String replaceSubStringForJava(String mainString) {
        String replaceString = mainString.replaceAll(" ", "%20");
        return replaceString;
    }

    public static String replaceSubStringForSimpleMethod(String mainString) {
        char[] mainChar = mainString.toCharArray();

        // 判断有多少空格
        int hasBlank = 0;
        for (char i : mainChar) {
            if (i == ' ') {
                hasBlank++;
            }
        }

        // 计算新的数组的长度

        int newLength = hasBlank * 2 + mainChar.length;

        char[] newChar = new char[newLength];

        int index_of_original = mainChar.length - 1;
        int index_of_new = newChar.length - 1;

        while (index_of_original >= 0 && index_of_new >= index_of_original) {
            if (mainChar[index_of_original] == ' ') {
                newChar[index_of_new--] = '0';
                newChar[index_of_new--] = '2';
                newChar[index_of_new--] = '%';
            } else {
                newChar[index_of_new--] = mainChar[index_of_original];
            }
            --index_of_original;
        }
        String replaceString = String.copyValueOf(newChar);
        return replaceString;
    }
}
