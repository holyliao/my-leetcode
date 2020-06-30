package com.liao.leetcode;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
// 注意：
//
//
// num1 和num2 的长度都小于 5100.
// num1 和num2 都只包含数字 0-9.
// num1 和num2 都不包含任何前导零。
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
//
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution415 {

    public static void main(String[] args) {
        Solution415 sol = new Solution415();
        System.out.println(sol.addStrings("0", "0"));
    }

    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int i = c1.length - 1, j = c2.length - 1;
        int t = 0, x = 0, y = 0, p = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            x = i >= 0 ? c1[i--] - '0' : 0;
            y = j >= 0 ? c2[j--] - '0' : 0;
            p = x + y + t;
            t = p / 10;
            sb.append(p % 10);
        }
        if (t > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
