import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    // 忘记贴题解出处了，不好意思

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1.length() * n1 < s2.length() * n2) {
            return 0;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int s1Count = 0;
        int s2Count = 0;


        int index = 0;

        // 遍历了s1_count个s1，此时匹配到了第s2_count个s2的index字符。
        // 如果之前遍历到的就是统一字符，说明有循环节。
        Map<Integer, int[]> map = new HashMap<>();
        while (true) {
            s1Count++;
            // 每次循环遍历一个s1，看能不能得到s2的循环
            for (char c : c1) {
                if (c == c2[index]) {
                    index++;
                    if (index == c2.length) {
                        s2Count++;
                        index = 0;
                    }
                }
            }
            // 如果s1已经用完，直接返回结果了
            if (s1Count == n1) {
                return s2Count / n2;
            }
            // 如果出现了重复的index，说明找到了循环节
            if (map.containsKey(index)) {

                break;
            }
            map.put(index, new int[]{s1Count, s2Count});
        }

        // 循环退出之后算每多少个s1就包含了多少个s2
        int[] firstCount = map.get(index);
        int[] cycleCount = new int[]{s1Count - firstCount[0], s2Count - firstCount[1]};
        // 出现循环节之前的s2的个数
        int resPre = firstCount[1];
        // 包含在循环节中的s2的个数
        int resLoop = (n1 - firstCount[0]) / cycleCount[0] * cycleCount[1];
        // 循环节结束之后s1的个数
        int s1LeftCount = (n1 - firstCount[0]) % cycleCount[0];
        int res = resLoop + resPre;
        for (int i = 0; i < s1LeftCount; i++) {
            for (char c : c1) {
                if (c == c2[index]) {
                    index++;
                    if (index == c2.length) {
                        index = 0;
                        res++;
                    }
                }
            }
        }
        return res / n2;
    }
}
