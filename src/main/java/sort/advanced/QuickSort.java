package sort.advanced;

import java.util.concurrent.ThreadLocalRandom;

import static util.SwapUtil.swap;


/**
 * 快速排序: 选取基准值将数组分为小于和大于它的两部分并递归排序
 *
 * @author tianxing
 */
@SuppressWarnings("DuplicatedCode")
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
        // 在区间[left, right]内随机选取基准值并交换至当前区间最右侧
        swap(nums, right, ThreadLocalRandom.current().nextInt(left, right + 1));
        int pivot = nums[right];
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
        // 在区间[left, right]内随机选取基准值并交换至当前区间最左侧
        swap(nums, left, ThreadLocalRandom.current().nextInt(left, right + 1));
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= right && nums[i] < pivot) {
                i++;
            }
            // nums[left]处的pivot天然充当左边界哨兵以防止j越界
            while (nums[j] > pivot) {
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

    /**
     * 双轴快排: 随机选取两个基准值(pivot1 <= pivot2)将数组划分为三部分并三路递归
     * [left, lt - 1]   < pivot1
     * [lt, gt]         >= pivot1 && <= pivot2
     * [gt + 1, right]  > pivot2
     *
     * @param nums  待排序数组
     * @param left  左边界
     * @param right 右边界
     */
    public static void dualPivot(int[] nums, int left, int right) {
        // 递归终止条件(区间为空或仅含单个元素)
        if (left >= right) {
            return;
        }
        // 在区间[left, right]内随机选取两个不同位置的基准值并分别交换至首尾位置
        swap(nums, left, ThreadLocalRandom.current().nextInt(left, right + 1));
        swap(nums, right, ThreadLocalRandom.current().nextInt(left + 1, right + 1));
        // 确保左基准值小于等于右基准值(pivot1 <= pivot2)
        if (nums[left] > nums[right]) {
            swap(nums, left, right);
        }
        int pivot1 = nums[left];
        int pivot2 = nums[right];
        // 小于pivot1部分的右边界
        int lt = left + 1;
        // 大于pivot2部分的左边界
        int gt = right - 1;
        // 当前探索指针从左基准值右侧开始扫描
        int i = left + 1;
        while (i <= gt) {
            if (nums[i] < pivot1) {
                swap(nums, i, lt);
                lt++;
                i++;
            } else if (nums[i] > pivot2) {
                swap(nums, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        // lt左移回退至小于pivot1区间的末尾位置
        lt--;
        // gt右移前进至大于pivot2区间的起始位置
        gt++;
        // 将首尾暂存的pivot1与pivot2交换至分界点归位
        swap(nums, left, lt);
        swap(nums, right, gt);
        // 递归处理小于pivot1部分
        dualPivot(nums, left, lt - 1);
        // 若双轴不相等则递归处理中间部分(若相等说明中间区间元素全部相同无需递归)
        if (pivot1 < pivot2) {
            dualPivot(nums, lt + 1, gt - 1);
        }
        // 递归处理大于pivot2部分
        dualPivot(nums, gt + 1, right);
    }
}
