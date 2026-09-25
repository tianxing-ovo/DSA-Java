package sort.simple;

/**
 * 插入排序: 将未排序的元素插入到已排序的部分中
 *
 * @author tianxing
 */
public class InsertionSort {

    /**
     * 插入排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        int n = nums.length;
        // i表示待插入元素的索引(默认索引0为已排序元素)
        for (int i = 1; i < n; i++) {
            // 暂存待插入元素
            int num = nums[i];
            // j表示已排序区域的末尾索引(从右向左扫描查找插入位置)
            int j = i - 1;
            while (j >= 0 && nums[j] > num) {
                // 将较大元素向后移动一位
                nums[j + 1] = nums[j];
                j--;
            }
            // 将待插入元素写入目标位置
            nums[j + 1] = num;
        }
    }
}
