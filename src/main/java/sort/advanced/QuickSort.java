package sort.advanced;

import java.util.concurrent.ThreadLocalRandom;

import static util.SwapUtil.swap;


/**
 * 快速排序: 选取基准值将数组分为小于和大于它的两部分并递归排序
 *
 * @author tianxing
 */
public class QuickSort {

    /**
     * 单路快排: 随机选取基准值交换至区间最右侧并通过单向扫描划分左右两部分
     *
     * @param nums  待排序数组
     * @param left  左边界
     * @param right 右边界
     */
    public static void oneWay(int[] nums, int left, int right) {
        // 递归终止条件(区间为空或仅含单个元素)
        if (left >= right) {
            return;
        }
        // 在区间[left, right]内随机选取基准值下标以防止数组有序时时间复杂度退化为O(n^2)
        int pivotIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
        int pivot = nums[pivotIndex];
        // 将随机选取的基准值交换至当前区间最右侧
        swap(nums, pivotIndex, right);
        // 小于基准值的边界
        int i = left;
        for (int j = left; j < right; j++) {
            // 找到比基准值小的元素
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        // 基准值与i交换归位(i是大于等于区的左端点)
        swap(nums, i, right);
        // 递归处理基准值左侧部分(均小于基准值)
        oneWay(nums, left, i - 1);
        // 递归处理基准值右侧部分(均大于等于基准值)
        oneWay(nums, i + 1, right);
    }

    /**
     * 双路快排: 随机选取基准值交换至区间最左侧并通过双向对撞扫描划分左右两部分
     *
     * @param nums  待排序数组
     * @param left  左边界
     * @param right 右边界
     */
    public static void twoWay(int[] nums, int left, int right) {
        // 递归终止条件(区间为空或仅含单个元素)
        if (left >= right) {
            return;
        }
        // 在区间[left, right]内随机选取基准值下标以防止数组有序时时间复杂度退化为O(n^2)
        int pivotIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
        int pivot = nums[pivotIndex];
        // 将随机选取的基准值交换至当前区间最左侧
        swap(nums, pivotIndex, left);
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= right && nums[i] < pivot) {
                i++;
            }
            while (j >= left + 1 && nums[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            // 交换后跳过已处理元素(防止等于基准值时死循环)
            i++;
            j--;
        }
        // 基准值与j交换归位(j是左半区右端点i已落入右半区)
        swap(nums, left, j);
        // 递归处理基准值左侧部分(均小于等于基准值)
        twoWay(nums, left, j - 1);
        // 递归处理基准值右侧部分(均大于等于基准值)
        twoWay(nums, j + 1, right);
    }

    /**
     * 三路快排: 随机选取基准值并通过三向切分(荷兰国旗算法)划分为小于、等于和大于三部分
     * [left, lt - 1]   < pivot
     * [lt, gt]         == pivot
     * [gt + 1, right]  > pivot
     *
     * @param nums  待排序数组
     * @param left  左边界
     * @param right 右边界
     */
    public static void threeWay(int[] nums, int left, int right) {
        // 递归终止条件(区间为空或仅含单个元素)
        if (left >= right) {
            return;
        }
        // 在区间[left, right]内随机选取基准值下标以防止数组有序时时间复杂度退化为O(n^2)
        int pivot = nums[ThreadLocalRandom.current().nextInt(left, right + 1)];
        // 小于基准值部分的右边界
        int lt = left;
        // 大于基准值部分的左边界
        int gt = right;
        // 当前探索指针从区间最左侧开始扫描
        int i = left;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, i, lt);
                lt++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        // 递归处理小于基准值部分
        threeWay(nums, left, lt - 1);
        // 递归处理大于基准值部分
        threeWay(nums, gt + 1, right);
    }
}
