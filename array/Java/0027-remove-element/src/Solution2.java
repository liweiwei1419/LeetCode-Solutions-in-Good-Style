public class Solution2 {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int next = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[next] = nums[i];
                next++;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.removeElement(new int[]{3, 2, 2, 3}, 2);
        System.out.println(result);
    }
}
