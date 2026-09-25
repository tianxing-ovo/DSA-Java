package sort.advanced;

/**
 * 归并排序: 递归拆分数组并通过双指针合并两个有序子数组
 *
 * @author tianxing
 */
public class MergeSort {

    /**
     * 归并排序主入口
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        // 创建临时数组以复用
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
    }

    /**
     * 归并排序
     *
     * @param nums  待排序数组
     * @param left  左边界
     * @param right 右边界
     * @param temp  临时数组
     */
    private static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            // 防止整数溢出
            int mid = left + (right - left) / 2;
            // 递归对左右子数组进行归并排序
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            // 临时数组的指针(直接与当前区间左边界对齐)
            int p = left;
            // [left, mid]区间的指针
            int p1 = left;
            // [mid + 1, right]区间的指针
            int p2 = mid + 1;
            while (p1 <= mid && p2 <= right) {
                // 取较小值(相等时优先取左侧以保证稳定性)
                temp[p++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
            }
            // 将剩余的元素加入到临时数组末尾
            while (p1 <= mid) {
                temp[p++] = nums[p1++];
            }
            while (p2 <= right) {
                temp[p++] = nums[p2++];
            }
            // 将有序区间从临时数组复制回原数组
            System.arraycopy(temp, left, nums, left, right - left + 1);
        }
    }
}
