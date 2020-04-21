package com.liao.leetcode;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串

//leetcode submit region begin(Prohibit modification and deletion)
class Solution125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution125 so = new Solution125();
        System.out.println("result:" + so.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char m;
        char n;
        s = s.toLowerCase();
        while (i <= j) {
            m = s.charAt(i);
            n = s.charAt(j);
            if (!isLetter(m)) {
                i++;
                continue;
            }
            if (!isLetter(n)) {
                j--;
                continue;
            }
            if (m == n) {
                i++;
                j--;
            } else {
                break;
            }
        }
        return i > j;
    }

    private boolean isLetter(char z) {
        return (65 <= z && z <= 90) || (97 <= z && z <= 122) || (48 <= z && z <= 57);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
