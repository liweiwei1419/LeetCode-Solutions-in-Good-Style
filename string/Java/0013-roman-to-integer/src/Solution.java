import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int romanToInt(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = map.get(s.charAt(0));
        for (int i = 1; i < len; i++) {
            int pre = map.get(s.charAt(i - 1));
            int cur = map.get(s.charAt(i));

            if (pre < cur) {
                // 这是唯一的一种需要注意的特殊情况，当前面的数字比当前数字要小的时候
                // 要用：当前数字 - 前面数字，因为前面数字加过了，所以要减去 2 倍
                res += (cur - 2 * pre);
            } else {
                res += cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "III";
        int romanToInt = solution.romanToInt(s);
        System.out.println(romanToInt);

        s = "LVIII";
        romanToInt = solution.romanToInt(s);
        System.out.println(romanToInt);

        s = "MCMXCIV";
        romanToInt = solution.romanToInt(s);
        System.out.println(romanToInt);
    }
}