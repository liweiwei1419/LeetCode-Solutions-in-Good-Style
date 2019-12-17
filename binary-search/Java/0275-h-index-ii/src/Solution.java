public class Solution {

    // 思路：看 nums[mid] 和区间 [mid, len - 1] 的长度，即 len - mid - 1 + 1 = len - mid
    // 要返回的是 nums 中的值
    // [0,1,2,5,6]，
    // 以下的代码注释是 coder_hezi 帮助添加的，在此表示感谢

    public int hIndex(int[] citations) {
        int len = citations.length;
        // 特判
        if (len == 0 || citations[len - 1] == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // 比长度小，就得去掉该值
            if (citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                // 比长度大是满足的，我们应该继续让 mid 往左走去尝试看有没有更小的 mid 值
                // 可以满足 mid 对应的值大于等于从 [mid, length - 1] 的长度
                right = mid;
            }
        }
        return len - left;
    }

    public static void main(String[] args) {
        int[] citations = {0, 1, 2, 5, 6};
        Solution solution = new Solution();
        int hIndex = solution.hIndex(citations);
        System.out.println(hIndex);
    }
}
