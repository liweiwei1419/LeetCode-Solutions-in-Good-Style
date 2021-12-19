import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        int size = 1 << len;

        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();

        // 枚举所有的子集下标
        for (int i = 0; i < size; ++i) {
            // i 是掩码 => 子序列
            List<Integer> subsequence = findSubsequences(i, len, nums);

            if (ifOrder(subsequence)) {
                int hashValue = getHash(subsequence, 263, (int) 1E9 + 7);
                // 计算子序列的哈希值
                if (!set.contains(hashValue)) {
                    res.add(new ArrayList<>(subsequence));
                    set.add(hashValue);
                }
            }
        }
        return res;
    }

    /**
     * 根据给定数组的长度不会超过 15，可以使用一个整数表示一个布尔数组
     *
     * @param mask
     * @param nums
     * @return
     */
    public List<Integer> findSubsequences(int mask, int len, int[] nums) {
        List<Integer> subsequences = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            if ((mask & 1) != 0) {
                subsequences.add(nums[i]);
            }
            mask >>= 1;
        }
        return subsequences;
    }

    public int getHash(List<Integer> subsequence, int base, int mod) {
        int hashValue = 0;
        for (int x : subsequence) {
            // 题目给出的数组中的整数范围是 [-100,100]，所以每一个数字要加上 101，使得每一位都是正数
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    public boolean ifOrder(List<Integer> subsets) {
        int size = subsets.size();
        for (int i = 1; i < size; ++i) {
            if (subsets.get(i) < subsets.get(i - 1)) {
                return false;
            }
        }
        return size >= 2;
    }
}