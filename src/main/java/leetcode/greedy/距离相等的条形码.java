package leetcode.greedy;

import java.util.Arrays;

/**
 * 1054.距离相等的条形码
 */
public class 距离相等的条形码 {
    public static void main(String[] args) {
        int[] barcodes = {1, 1, 1, 1, 2, 2, 3, 3};
        System.out.println(Arrays.toString(rearrangeBarcodes(barcodes)));
    }

    /**
     * 1 <= barcodes[i] <= 10000
     * 1.将出现频率最高的元素排在0,2,4...等索引
     * 2.将其他元素按顺序插入,如果超出最大索引,从索引1开始插入
     */
    public static int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int max = 1; // 出现频率最高的元素
        int[] count = new int[10001]; // 计数数组
        int index = 0;
        // 找出出现频率最高的元素
        for (int barcode : barcodes) {
            if (++count[barcode] > count[max]) {
                max = barcode;
            }
        }
        for (int i = 0; i < 10001; i++) {
            // 先填充出现频率最高的元素
            int barcode = (i == 0 ? max : i);
            while (count[barcode]-- > 0) {
                if (index >= n) {
                    index = 1;
                }
                barcodes[index] = barcode;
                index += 2;
            }
        }
        return barcodes;
    }
}
