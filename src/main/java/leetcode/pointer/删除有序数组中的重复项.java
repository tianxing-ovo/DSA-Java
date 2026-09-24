package leetcode.pointer;

/**
 * 26.删除有序数组中重复项
 */
public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * @param nums 有序整数数组
     * @return int 不含重复元素的新数组的长度
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
