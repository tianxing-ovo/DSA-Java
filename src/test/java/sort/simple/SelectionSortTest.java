package sort.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 选择排序单元测试
 *
 * @author tianxing
 */
class SelectionSortTest {

    private final int[] expected = {1, 2, 3, 4, 5, 7, 8, 9};

    @Test
    @DisplayName("选择排序测试")
    void sort() {
        int[] nums = {5, 3, 7, 2, 9, 8, 1, 4};
        SelectionSort.sort(nums);
        // nums = [1, 2, 3, 4, 5, 7, 8, 9]
        System.out.println("nums = " + Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }
}
