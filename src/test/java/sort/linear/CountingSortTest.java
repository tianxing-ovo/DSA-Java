package sort.linear;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 计数排序单元测试
 *
 * @author tianxing
 */
class CountingSortTest {

    private final int[] expected = {-2, -2, 0, 1, 3, 5, 5, 7};

    @Test
    @DisplayName("计数排序测试")
    void sort() {
        int[] nums = {5, -2, 3, 0, -2, 7, 5, 1};
        CountingSort.sort(nums);
        // nums = [-2, -2, 0, 1, 3, 5, 5, 7]
        System.out.println("nums = " + Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("稳定计数排序测试")
    void sortStable() {
        int[] nums = {5, -2, 3, 0, -2, 7, 5, 1};
        CountingSort.sortStable(nums);
        // nums = [-2, -2, 0, 1, 3, 5, 5, 7]
        System.out.println("nums = " + Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }
}
