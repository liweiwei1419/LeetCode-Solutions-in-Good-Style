public class Solution2 {

    // 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/tong-yong-mo-ban-java-shi-xian-qian-zhui-shu-by-th/


    class Node {
        Node[] children = new Node[2];
    }

    static final int MAX_BIT = 31;
    static final int MIN_BIT = 0;

    Node root = new Node();

    public int findMaximumXOR(int[] nums) {
        if (nums == null) {
            return 0;
        }
        initTrie(nums);
        return helper(nums);
    }

    private void initTrie(int[] nums) {
        for (int num : nums) {
            Node cur = root;
            for (int i = MAX_BIT; i >= MIN_BIT; i--) {
                int bit = getBit(num, i);
                Node next = cur.children[bit];
                if (next == null) {
                    next = new Node();
                    cur.children[bit] = next;
                }
                cur = next;
            }
        }
    }

    private int helper(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            Node cur = root;
            int sum = 0;
            for (int i = MAX_BIT; i >= MIN_BIT; i--) {
                int bit = getBit(num, i);
                int xorBit = bit ^ 1;

                /*
                 * 1. 异或位为空，则该位没有可以异或的值，则从原位置继续下一次循环；
                 * 2. 异或位不为空，说明该位置可以进行异或操作，则从异或后的位置继续循环，
                 * 并将 num 对应的异或值之和 sum 相应位置加上 1；
                 */
                Node next = cur.children[xorBit];
                if (next == null) {
                    cur = cur.children[bit];
                } else {
                    sum += (1 << i);
                    cur = next;
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private int getBit(int num, int bit) {
        return (num >>> bit) & 1;
    }

}
