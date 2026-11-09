package leetcode.dp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 53. 最大子数组和测试
 *
 * @author tianxing
 */
class MaximumSubarrayTest {

    private final int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    @Test
    @DisplayName("最大子数组和测试")
    void maxSubArray() {
        int max = MaximumSubarray.maxSubArray(nums);
        assertEquals(6, max);
    }

    @Test
    @DisplayName("带索引的最大子数组和测试")
    void maxSubArrayWithIndices() {
        int[] indices = MaximumSubarray.maxSubArrayWithIndices(nums);
        // 连续子数组 [4, -1, 2, 1] 的和最大
        assertArrayEquals(new int[]{6, 3, 6}, indices);
    }
}

