import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public String minWindow(String s, String t) {
        int[] cntS = new int[256];
        int[] cntT = new int[256];

        Set<Character> set = new HashSet<>();
        for (char charT : t.toCharArray()) {
            cntT[charT]++;
            set.add(charT);
        }

        int sLen = s.length();
        int tLen = t.length();
        int minLen = sLen + 1;

        String res = "";
        int left = 0;
        int right = 0;

        int count = 0;
        while (right < sLen) {
            char rightC = s.charAt(right);
            if (!set.contains(rightC)) {
                right++;
                continue;
            }
            cntS[rightC]++;
            right++;
            if (cntS[rightC] <= cntT[rightC]) {
                count++;
            }
            if (count == tLen) {
                while (true) {
                    char deleteChar = s.charAt(left);
                    if (!set.contains(deleteChar)) {
                        left++;
                        continue;
                    }
                    if (cntS[deleteChar] > cntT[deleteChar]) {
                        cntS[deleteChar]--;
                        left++;
                        continue;
                    }
                    break;
                }
                if (right - left < minLen) {
                    minLen = right - left;
                    res = s.substring(left, right);
                }
            }
        }
        if (minLen == sLen + 1) {
            return "";
        }
        return res;
    }

    // 先复习第 438 题再做这题可能会好些
    // 滑动窗口，这个问题有一些难
    public String minWindow2(String s, String t) {
        int[] cntS = new int[256];
        int[] cntT = new int[256];

        Set<Character> set = new HashSet<>();
        // cntT 赋值了以后，就成为了用于比对的对象，不更新
        for (char ct : t.toCharArray()) {
            cntT[ct]++;
            set.add(ct);
        }

        int minSub = s.length() + 1;
        String res = "";
        // 滑动窗口左边界
        int left = 0;
        // 滑动窗口右边界
        int right = 0;

        // 逻辑：右边界进来的时候，数组 s 的次数都加 1

        int count = 0;
        while (right < s.length()) {
            char rc = s.charAt(right);
            if (!set.contains(rc)) {
                // 不在字典里面，但是右边界同样要扩充，所以 right++
                right++;
                continue;
            }
            cntS[rc]++;
            right++;
            // 理解这里是关键：加上以后，小于等于，count 才 ++，
            if (cntS[rc] <= cntT[rc]) {
                // count++; 这件事情说明滑动窗口里面的有效字符，向目标字符又近了一步
                count++;
            }

            // 下面这一段可以写得更精简一些，但是为了语义上的清晰，我就写得冗长一些
            if (count == t.length()) {
                // 接下来，考虑左边界移出滑动窗口
                // 不在字典中，或者多了的时候，直接划掉就可以了
                while (true) {
                    char deleteChar = s.charAt(left);
                    if (!set.contains(deleteChar)) {
                        left++;
                        continue;
                    }
                    if (cntS[deleteChar] > cntT[deleteChar]) {
                        cntS[deleteChar]--;
                        left++;
                        continue;
                    }
                    break;
                }
                if (right - left < minSub) {
                    minSub = right - left;
                    res = s.substring(left, right);
                }
            }
        }
        if (minSub == s.length() + 1) {
            return "";
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String minWindow = solution2.minWindow(S, T);
        System.out.println(minWindow);
    }
}
