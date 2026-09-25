package sort.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 冒泡排序单元测试
 *
 * @author tianxing
 */
class BubbleSortTest {

    private final int[] expected = {1, 2, 3, 4, 5, 7, 8, 9};

    @Test
    @DisplayName("基础冒泡排序测试")
    void sort() {
        int[] nums = {5, 3, 7, 2, 9, 8, 1, 4};
        BubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("优化1: 提前终止标记冒泡排序测试")
    void sort_v1() {
        int[] nums = {5, 3, 7, 2, 9, 8, 1, 4};
        BubbleSort.sort_v1(nums);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("优化2: 记录最后交换边界冒泡排序测试")
    void sort_v2() {
        int[] nums = {5, 3, 7, 2, 9, 8, 1, 4};
        BubbleSort.sort_v2(nums);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }
}
