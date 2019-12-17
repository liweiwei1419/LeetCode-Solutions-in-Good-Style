import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode curr = this;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val);
            s.append(" -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}


public class Solution {

    // 放在一个动态数组中，然后判断这个动态数组的回文性

    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        return judgeArrPalindrome(arr);
    }

    private boolean judgeArrPalindrome(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            if (arr.get(left).equals(arr.get(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 2, 1};
        Solution solution = new Solution();
        ListNode head = new ListNode(nums);
        boolean palindrome = solution.isPalindrome(head);
        System.out.println(palindrome);
    }
}
