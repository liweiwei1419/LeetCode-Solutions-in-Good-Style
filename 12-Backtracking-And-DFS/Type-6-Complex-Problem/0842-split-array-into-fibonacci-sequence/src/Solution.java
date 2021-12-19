import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 知识点：1、回溯；2、设计递归函数的返回值

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        int len = S.length();
        char[] charArray = S.toCharArray();
        dfs(charArray, 0, len, res);
        return res;

    }

    /**
     * @param charArray
     * @param begin
     * @param len
     * @param res       斐波拉契数列数量保存在这个列表里
     * @return 是否可以拆分为斐波拉契数列
     */
    private boolean dfs(char[] charArray, int begin, int len, List<Integer> res) {
        // 递归终止条件
        if (begin == len) {
            return res.size() > 2;
        }

        int num = 0;
        for (int i = begin; i < len; i++) {
            num = num * 10 + (charArray[i] - '0');
            // 考虑整型溢出的情况
            if (num < 0) {
                return false;
            }
            if (res.size() < 2 || res.get(res.size() - 2) + res.get(res.size() - 1) == num) {
                res.add(num);
                if (dfs(charArray, i + 1, len, res)) {
                    return true;
                }
                // 如果不能得到，撤销选择
                res.remove(res.size() - 1);
            }

            // 1011 -> [1,0,1,1]
            if (i == begin && charArray[i] == '0') {
                return false;
            }
        }
        return false;
    }
}