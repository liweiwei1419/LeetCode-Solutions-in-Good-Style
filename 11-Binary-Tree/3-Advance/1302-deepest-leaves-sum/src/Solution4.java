import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Solution4 {

    public int deepestLeavesSum(TreeNode root) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode top = queue.poll();
                if (top.left == null && top.right == null) {
                    treeMap.put(depth, top.val += treeMap.getOrDefault(depth, 0));
                }

                if (top.left != null) {
                    queue.offer(top.left);
                }

                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            depth += 1;
        }

        // System.out.println(treeMap);
        return treeMap.get(treeMap.lastKey());
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode4.left = treeNode7;

        treeNode3.right = treeNode6;
        treeNode6.right = treeNode8;

        Solution4 solution3 = new Solution4();
        int res = solution3.deepestLeavesSum(treeNode1);
        System.out.println(res);
    }
}