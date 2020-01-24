import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 思想：使用类似子集的做法

    private int res;

    public int maxLength(List<String> arr) {
        int len = arr.size();
        dfs(arr, 0, len, 0, "");
        return res;
    }

    private void dfs(List<String> arr, int index, int len, int hash, String curString) {
        // 在结点处记录最长值
        res = Math.max(res, curString.length());

        for (int i = index; i < len; i++) {
            if (!add(arr.get(i), hash)) {
                continue;
            }

            for (char c : arr.get(i).toCharArray()) {
                hash ^= (1 << (c - 'a'));
            }

            dfs(arr, i + 1, len, hash, curString + arr.get(i));

            // 状态重置
            for (char c : arr.get(i).toCharArray()) {
                hash ^= (1 << (c - 'a'));
            }
        }
    }

    private boolean add(String string, int hash) {
        // 编写的时候须注意，如果这个单词有重复元素，也不能添加
        for (char c : string.toCharArray()) {
            if ((hash & (1 << (c - 'a'))) != 0) {
                return false;
            }
            hash ^= (1 << (c - 'a'));
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("yy");
        arr.add("bkhwmpbiisbldzknpm");
        Solution solution = new Solution();
        int res = solution.maxLength(arr);
        System.out.println(res);
    }
}
