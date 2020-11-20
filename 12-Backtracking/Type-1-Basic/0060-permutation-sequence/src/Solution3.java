import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    // 方法二：双链表模拟

    public String getPermutation(int n, int k) {
        // 先算出所有的阶乘值
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            nums.add(i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            // 确定每一位应该是剩余数字中的第几个
            int index = (k - 1) / factorial[i];
            // 每次实际使用的数字是集合中的第 index 个数字
            stringBuilder.append(nums.remove(index));
            k -= index * factorial[i];
        }
        return stringBuilder.toString();
    }
}