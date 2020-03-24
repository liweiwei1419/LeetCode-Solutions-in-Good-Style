public class Solution4 {

    // 参考资料：http://www.cnblogs.com/njufl/p/6403043.html

    private class TrieNode {
        private TrieNode[] next;

        public TrieNode() {
            this.next = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        TrieNode root = new TrieNode();
        int res = 0;
        for (int num : nums) {
            int xor = 0;
            TrieNode insert = root;
            TrieNode search = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                // 1 变成 0 ，0 变成 1
                int rbit = bit ^ 1;
                if (insert.next[bit] == null) {
                    insert.next[bit] = new TrieNode();
                }
                insert = insert.next[bit];
                if (search != null) {
                    if (search.next[rbit] != null) {
                        xor += (1 << i);
                        search = search.next[rbit];
                    } else {
                        search = search.next[bit];
                    }
                }
            }
            res = Math.max(res, xor);
        }
        return res;
    }

    public static void main(String[] args) {
        // 28
        int[] nums = {3, 10, 5, 25, 2, 8};
        Solution3 solution3 = new Solution3();
        int maximumXOR = solution3.findMaximumXOR(nums);
        System.out.println(maximumXOR);
    }
}
