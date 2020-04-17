package com.liao.leetcode;

//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 数学 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution67 {
    public static void main(String[] args) {
        Solution67 s = new Solution67();
        s.addBinary("100", "110010");
    }

    public String addBinary(String a, String b) {
        if (b.length() == 0) {
            return a;
        }
        boolean one = false;
        char n, m;
        int x = a.length();
        int y = b.length();
        int l = Math.max(x, y);
        char[] ans = new char[l];
        int i = 1;
        for (; x - i >= 0 && y - i >= 0; i++) {
            n = a.charAt(x - i);
            m = b.charAt(y - i);
            if (one) {
                one = false;
                if (n != m) {
                    ans[l - i] = '0';
                    one = true;
                } else if (n == '1' && m == '1') {
                    ans[l - i] = '1';
                    one = true;
                } else {
                    ans[l - i] = '1';
                }
            } else {
                if (n != m) {
                    ans[l - i] = '1';
                } else if (n == '1' && m == '1') {
                    ans[l - i] = '0';
                    one = true;
                } else {
                    ans[l - i] = '0';
                }
            }
        }

        if (x > y) {
            for (; x - i >= 0; i++) {
                if (one) {
                    one = false;
                    n = a.charAt(x - i);
                    if (n == '0') {
                        ans[x - i] = '1';
                    } else {
                        ans[x - i] = '0';
                        one = true;
                    }
                } else {
                    n = a.charAt(x - i);
                    if (n == '0') {
                        ans[x - i] = '0';
                    } else {
                        ans[x - i] = '1';
                    }
                }
            }
        } else if (x < y) {
            for (; y - i >= 0; i++) {
                if (one) {
                    one = false;
                    m = b.charAt(y - i);
                    if (m == '0') {
                        ans[y - i] = '1';
                    } else {
                        ans[y - i] = '0';
                        one = true;
                    }
                } else {
                    m = b.charAt(y - i);
                    if (m == '0') {
                        ans[y - i] = '0';
                    } else {
                        ans[y - i] = '1';
                    }
                }
            }
        }
        if (one) {
            char[] t = new char[ans.length + 1];
            t[0] = '1';
            for (int z = 0; z < ans.length; z++) {
                t[z + 1] = ans[z];
            }
            ans = t;
        }
        return new String(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
