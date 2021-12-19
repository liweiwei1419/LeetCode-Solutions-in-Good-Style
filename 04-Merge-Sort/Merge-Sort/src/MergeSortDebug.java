import java.util.Arrays;

/**
 * 用于理解归并排序的代码
 */
public class MergeSortDebug {

    private int[] temp;

    public void sort(int[] arr) {
        int len = arr.length;
        temp = new int[len];
        mergeSort(arr, 0, len - 1, 1);
    }

    private void mergeSort(int[] arr, int left, int right, int depthForDebug) {
        System.out.println(printDepth(depthForDebug) + "sort:" + left + " " + right);
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, depthForDebug + 1);
        mergeSort(arr, mid + 1, right, depthForDebug + 1);
        if (arr[mid] <= arr[mid + 1]) {
            return;
        }
        mergeOfTwoSortArray(arr, left, mid, right);
        System.out.println(printDepth(depthForDebug) + "merge: " + left + " " + right);
    }

    private String printDepth(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }


    private void mergeOfTwoSortArray(int[] arr, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > right) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] < temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {8, 4, 3, 6, 5, 1, 7, 2};
        MergeSortDebug mergeSortDebug = new MergeSortDebug();
        mergeSortDebug.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
