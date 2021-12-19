import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        // 为了避免重复多次的情况，这里使用 Set 去除重复
        Set<String> repeated = new HashSet<>();

        int len = s.length();
        int begin = 0;
        int end = 10;

        StringBuilder stringBuilder = new StringBuilder(s);
        // 注意这里是等于号，因为 substring 方法的第 2 个参数是开区间的右端点，取不到
        while (end <= len) {
            String segment = stringBuilder.substring(begin, end);
            if (seen.contains(segment)) {
                repeated.add(segment);
            } else {
                seen.add(segment);
            }
            begin++;
            end++;
        }
        return new ArrayList<>(repeated);
    }
}