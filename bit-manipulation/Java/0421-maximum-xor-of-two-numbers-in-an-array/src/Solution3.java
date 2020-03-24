public class Solution3 {

    // 参考资料：http://www.cnblogs.com/njufl/p/6403043.html

    private class TrieNode {
        private TrieNode[] next;

        public TrieNode() {
            next = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        TrieNode root = new TrieNode();
        // 将所有的 num 构建到 Trie 数中
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                // 看看最高位上是 1 还是 0
                int cur = (num >>> i) & 1;
                if (node.next[cur] == null) {
                    node.next[cur] = new TrieNode();
                }
                node = node.next[cur];
            }
        }
        int res = 0;
        for (int num : nums) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int cur = (num >>> i) & 1;
                if (node.next[cur ^ 1] != null) {
                    xor |= (1 << i);
                    node = node.next[cur ^ 1];
                } else {
                    node = node.next[cur];
                }
            }
            res = Math.max(res, xor);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = {3, 10, 5, 25, 2, 8};
        int maximumXOR = solution3.findMaximumXOR(nums);
        System.out.println(maximumXOR);
    }
}
