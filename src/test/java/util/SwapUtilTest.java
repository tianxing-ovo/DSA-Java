package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 交换工具类测试
 *
 * @author tianxing
 */
class SwapUtilTest {

    private final int[] nums = {1, 2};
    private final int[] expected = {2, 1};

    @Test
    @DisplayName("中间变量法交换测试")
    void swap() {
        SwapUtil.swap(nums, 0, 1);
        System.out.println("nums = " + Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("数学计算法交换测试")
    void swapIntegerMath() {
        SwapUtil.swapIntegerMath(nums, 0, 1);
        System.out.println("nums = " + Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("异或运算法交换测试")
    void swapIntegerXOR() {
        SwapUtil.swapIntegerXOR(nums, 0, 1);
        System.out.println("nums = " + Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }
}

