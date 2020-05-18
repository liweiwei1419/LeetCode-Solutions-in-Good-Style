import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // 换成输入语句
        int[] arr = new int[]{1, 2, 4, 5, 8};
        int threshold = 3;


        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int len = arr.length;
        int left = 0;
        int right = len - 1;

        // 指针移动的步数，就是删除的最少数字
        int cnt = 0;
        while (left <= right) {
            if (arr[right] - arr[left] <= threshold) {
                System.out.println(cnt);
                return;
            }

            if (arr[right] - arr[left + 1] > arr[right - 1] - arr[left + 1]) {
                right--;
            } else {
                left++;
            }
            cnt++;

        }

    }
}
