package 排序.简单排序;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static 排序.简单排序.冒泡排序.*;

/**
 * 冒泡排序单元测试
 *
 * @author tianxing
 */
public class BubbleSortTest {

    private final int[] expected = {1, 2, 3, 4, 5, 7, 8, 9};

    @Test
    @DisplayName("基础冒泡排序测试")
    public void testBubbleSort() {
        int[] nums = {5, 2, 7, 4, 1, 3, 8, 9};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("优化1: 提前终止标记冒泡排序测试")
    public void testBubbleSort_v1() {
        int[] nums = {5, 2, 7, 4, 1, 3, 8, 9};
        bubbleSort_v1(nums);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("优化2: 记录最后交换边界冒泡排序测试")
    public void testBubbleSort_v2() {
        int[] nums = {5, 2, 7, 4, 1, 3, 8, 9};
        bubbleSort_v2(nums);
        System.out.println(Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }
}
