import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liwei
 * @date 2019/8/22 8:07 PM
 */
public class Solution3 {


    // author:labuladong

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (Character c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int sLen = s.length();
        int left = 0;
        int right = 0;
        int match = 0;

        // 只要在 need 中的，右边划过都增加
        // 左边划过都减少

        while (right < sLen) {
            Character curChar = s.charAt(right);
            if (need.containsKey(curChar)) {
                window.put(curChar, window.getOrDefault(curChar, 0) + 1);
                if (window.get(curChar).equals(need.get(curChar))) {
                    match++;
                }
            }

            // 此时 right 已经出了滑窗
            right++;

            while (match == need.size()) {
                if (right - left == p.length()) {
                    // 因为 right 超过了 1 位，因此这里不用 + 1
                    res.add(left);
                }
                Character leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    int count = window.get(leftChar);
                    count--;
                    window.put(leftChar, count);
                    if (count < need.get(leftChar)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }

    // 注意到只有小写字母，counter 数组的长度可以设置为 32 个

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();

        // 特判
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }

        // 这个 need 表记录了每个字母出现的频率，即计数值
        // ASCII 的长度是 256 位
        int[] need = new int[32];

        // 滑动窗口的左边界
        int left = 0;
        // 滑动窗口的右边界
        int right = 0;
        // 滑动窗口的长度，这里表示差距，为 0 表示和 p 对应的 need 值完全一致
        int distance = p.length();
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }

        int sLen = s.length();
        while (right < sLen) {

            // 窗口右移，相应的 need 值减小；
            // 如果这个位置的 need 值是正的，表示当前遍历到的字符在字符串中，
            // 所以 distance 做减法
            if (need[s.charAt(right) - 'a'] > 0) {
                // 吸纳进来以后，说明差距减少 1
                distance--;
            }
            // 如果是等于 0 的就说明没有出现在 p 中，也 --，以后左边界扫到它的时候，就知道它不在 p 指定的范围中了
            // 不管当前字符在不在 need 表中，都适用于这个逻辑（听下来想想为什么）
            // 因为左边窗口滑出的时候，这个值会加回来
            need[s.charAt(right) - 'a']--;
            right++;
            if (distance == 0) {
                // 差距为 0 了，就表示是一个结果，左端点加入结果集
                res.add(left);
            }
            if (right - left == p.length()) {

                // 如果当窗口大小一定的时候，即窗口大小和需要比较的字符串大小一致的时候，
                // 将窗口左边的指针向右边移动，移动的同时左边的字符计数因为在第一个 if 的地方 need 值减小过，
                // 所以需要执行对应恢复操作，即：need 值增加，distance 计数值增加。

                // 大于等于 0 的，说明字符在 p 中，那些是负的字符说明不在 p 中
                if (need[s.charAt(left) - 'a'] >= 0) {
                    // 差距又拉大了 1
                    // 左端点离开滑动窗口，差距加大 1
                    distance++;
                }
                // 左端点离开滑动窗口
                // 不管 字符 在不在 p 中，都适用于这个逻辑
                need[s.charAt(left) - 'a']++;
                left++;
            }
        }
        // System.out.println(Arrays.toString(need));
        return res;
    }

    // 同 Solution，只是突出的滑动窗口的模板写法

    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 因为题目中说，只有 26 个英文小写字母
        int[] chars = new int[26];
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        for (char c : p.toCharArray()) {
            chars[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int distance = p.length();
        while (right < s.length()) {
            // 1、右边界滑入的逻辑
            if (chars[s.charAt(right) - 'a'] > 0) {
                distance--;
            }
            chars[s.charAt(right) - 'a']--;
            right++;

            // 2、结算
            if (distance == 0) {
                res.add(left);
            }

            // 3、左边界滑出的逻辑
            if (right - left == p.length()) {
                if (chars[s.charAt(left) - 'a'] >= 0) {
                    distance++;
                }
                chars[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        Solution3 solution3 = new Solution3();
        List<Integer> res = solution3.findAnagrams(s, p);
        System.out.println(res);
    }
}
