/**
 * 自下而上使用循环建立线段树
 * https://leetcode-cn.com/problems/range-sum-query-mutable/description/
 *
 * @author liwei
 */
public class NumArray2 {

    private int[] tree;
    private int len;

    public NumArray2(int[] nums) {
        len = nums.length;
        tree = new int[2 * len];
        // tree[0] 不使用
        // 给线段树的叶子结点赋值
        for (int i = len; i < 2 * len; i++) {
            tree[i] = nums[i - len];
        }
        // 给线段树的非叶子结点赋值
        for (int i = len - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int i, int val) {
        i += len;
        tree[i] = val;
        // 下面挨个更新父亲结点的值
        while (i > 0) {
            i /= 2;
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public int sumRange(int i, int j) {
        i += len;
        j += len;
        int sum = 0;
        while (i <= j) {

            if (i % 2 == 1) {
                sum += tree[i];
                i++;
            }
            if (j % 2 == 0) {
                sum += tree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        NumArray2 numArray2 = new NumArray2(nums);
        int sumRange = numArray2.sumRange(2, 4);
        System.out.println(sumRange);
        numArray2.update(2, 0);
        int sumRange2 = numArray2.sumRange(2, 4);
        System.out.println(sumRange2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */