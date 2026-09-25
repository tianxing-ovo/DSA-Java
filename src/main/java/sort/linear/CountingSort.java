package sort.linear;

/**
 * 计数排序: 统计每个元素出现的频次并按顺序写回原数组
 * 极差 = 最大值 (Maximum) − 最小值 (Minimum)
 *
 * @author tianxing
 */
@SuppressWarnings("DuplicatedCode")
public class CountingSort {

    /**
     * 计数排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        // 寻找数组的最大值与最小值以确定计数数组长度
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (val < min) {
                min = val;
            } else if (val > max) {
                max = val;
            }
        }
        // 根据极差创建计数数组
        int[] count = new int[max - min + 1];
        // 统计每个元素出现的频次
        for (int num : nums) {
            // 偏移映射下标以支持负数
            count[num - min]++;
        }
        // 按照统计频次依次将元素写回原数组
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            // 加上最小值还原真实元素
            int val = i + min;
            while (count[i]-- > 0) {
                nums[index++] = val;
            }
        }
    }

    /**
     * 稳定计数排序: 基于前缀和与倒序遍历保持相同元素的原始相对顺序
     *
     * @param nums 待排序数组
     */
    public static void sortStable(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        // 寻找数组的最大值与最小值以确定计数数组长度
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (val < min) {
                min = val;
            } else if (val > max) {
                max = val;
            }
        }
        // 根据极差创建计数数组
        int[] count = new int[max - min + 1];
        // 统计每个元素出现的频次
        for (int num : nums) {
            // 偏移映射下标以支持负数
            count[num - min]++;
        }
        // 累加前缀和以确定各元素在有序数组中的右边界位置
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[nums.length];
        // 倒序遍历原数组将元素放置到输出数组对应位置以保持稳定性
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            output[count[num - min] - 1] = num;
            count[num - min]--;
        }
        // 将有序元素从输出数组复制回原数组
        System.arraycopy(output, 0, nums, 0, nums.length);
    }
}
