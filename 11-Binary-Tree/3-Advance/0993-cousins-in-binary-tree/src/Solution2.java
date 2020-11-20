import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution2 {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // key：当前层结点值，value：当前层结点输出的下标
        // 这个 currentLevel 每次使用完都得清空
        Map<Integer, Integer> currentLevel = new HashMap<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head != null) {
                    currentLevel.put(head.val, i);
                    queue.add(head.left);
                    queue.add(head.right);
                }
            }

            if (currentLevel.containsKey(x) && currentLevel.containsKey(y)) {
                int index1 = currentLevel.get(x);
                int index2 = currentLevel.get(y);
                if (index1 > index2) {
                    int temp = index1;
                    index1 = index2;
                    index2 = temp;
                }

                return index1 + 1 != index2 || (index1 % 2) != 0;
            }

            if (currentLevel.containsKey(x) || currentLevel.containsKey(y)) {
                return false;
            }
            currentLevel.clear();
        }
        return false;
    }
}