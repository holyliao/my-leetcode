package com.liao.leetcode;

//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
// 示例 1:
//
// 输入: "hello"
//输出: "holle"
//
//
// 示例 2:
//
// 输入: "leetcode"
//输出: "leotcede"
//
// 说明:
//元音字母不包含字母"y"。
// Related Topics 双指针 字符串

//leetcode submit region begin(Prohibit modification and deletion)
class Solution345 {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (isVowel(chars[i]) && isVowel(chars[j])) {
                swap(chars, i, j);
                i++;
                j--;
            }
            if (!isVowel(chars[i])) {
                i++;
            }
            if (!isVowel(chars[j])) {
                j--;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;

        }
    }

    private void swap(char[] s, int i, int j) {
        if (s[i] != s[j]) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

