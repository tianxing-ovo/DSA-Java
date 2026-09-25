package sort.advanced;

/**
 * 希尔排序(插入排序的改进版本): 通过希尔增量分组进行跨步长插入排序并逐渐减小分组间隔
 *
 * @author tianxing
 */
public class ShellSort {

    /**
     * 希尔排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        int h = 1;
        int n = nums.length;
        // 采用 Hibbard 增量计算初始最大步长
        while (h < n / 2) {
            h = 2 * h + 1;
        }
        // 逐步缩小步长直至为1
        while (h >= 1) {
            // i表示待插入元素的索引(默认前h个元素分别为各组已排序元素)
            for (int i = h; i < n; i++) {
                // 暂存待插入元素
                int num = nums[i];
                // j表示同组已排序区域的末尾索引(跨步长h从右向左扫描)
                int j = i - h;
                while (j >= 0 && nums[j] > num) {
                    // 将同组中较大元素向后移动h位
                    nums[j + h] = nums[j];
                    j -= h;
                }
                // 将待插入元素写入目标位置
                nums[j + h] = num;
            }
            h /= 2;
        }
    }
}
