import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationIterator2 {

    /**
     * @param chars             候选字符数组
     * @param start             候选字符数组的起始索引
     * @param currentLen        当前得到的字符串的长度
     * @param combinationLength 一共需要多少字符
     * @param len               候选字符数组的长度
     * @param stringBuilder     当做一个栈使用
     * @param permutations      得到的所有结果集
     */
    private void dfs(char[] chars,
                     int start,
                     int currentLen,
                     int combinationLength,
                     int len,
                     StringBuilder stringBuilder,
                     List<String> permutations) {
        if (currentLen == combinationLength) {
            permutations.add(stringBuilder.toString());
            return;
        }
        for (int i = start; i < len; i++) {
            stringBuilder.append(chars[i]);
            dfs(chars, i + 1, currentLen + 1, combinationLength, len, stringBuilder, permutations);
            stringBuilder.deleteCharAt(currentLen);
        }
    }

    /**
     * 下一个排列的索引
     */
    private int index = 0;
    /**
     * 结果集的长度
     */
    private int size;
    /**
     * 保存结果集的对象
     */
    private List<String> permutations;

    public CombinationIterator2(String characters, int combinationLength) {
        int len = characters.length();
        char[] chars = characters.toCharArray();

        // 为了保证字典序正确，需先排序
        Arrays.sort(chars);

        permutations = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        dfs(chars, 0, 0, combinationLength, len, stringBuilder, permutations);

        size = permutations.size();
    }

    public String next() {
        String nextStr = permutations.get(index);
        index++;
        return nextStr;
    }

    public boolean hasNext() {
        return index < size;
    }
}