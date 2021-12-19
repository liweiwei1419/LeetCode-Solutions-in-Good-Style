import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    /**
     * 用一个 哈希表 判断子串是不是在集合里，然后遍历出最长的就行
     * 长度相同的用 compareTo 方法判断谁的字典顺序靠前
     * 这个题最难的感觉其实是不知道 compareTo 方法，自己实现还挺麻烦的
     *
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        // 构建 set
        Set<String> set = new HashSet<>(Arrays.asList(words));
        // 记录最大长度字符串
        String res = "";
        // 遍历判断
        for (String s : words) {
            // 两种情况值得更新，一种是长度更长，一种是长度一样但是顺序靠前
            if (s.length() > res.length() || (s.length() == res.length() && s.compareTo(res) < 0)) {
                // 判断字符串的子串在不在集合里
                boolean judge = true;
                for (int i = s.length() - 1; i > 0; i--) {
                    if (!set.contains(s.substring(0, i))) {
                        judge = false;
                        break;
                    }
                }
                if (judge) {
                    res = s;
                }
            }
        }
        return res;
    }
}