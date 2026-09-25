package sort.advanced;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 快速排序单元测试
 *
 * @author tianxing
 */
class QuickSortTest {

    private final int[] expected = {1, 2, 3, 4, 5, 7, 8, 9};

    @Test
    @DisplayName("单路快排测试")
    void oneWay() {
        int[] nums = {5, 3, 7, 2, 9, 8, 1, 4};
        QuickSort.oneWay(nums, 0, nums.length - 1);
        System.out.println("nums = " + Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("双路快排测试")
    void twoWay() {
        int[] nums = {5, 3, 7, 2, 9, 8, 1, 4};
        QuickSort.twoWay(nums, 0, nums.length - 1);
        System.out.println("nums = " + Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("三路快排测试")
    void threeWay() {
        int[] nums = {5, 3, 7, 2, 9, 2, 1, 7};
        int[] expected = {1, 2, 2, 3, 5, 7, 7, 9};
        QuickSort.threeWay(nums, 0, nums.length - 1);
        System.out.println("nums = " + Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }
}