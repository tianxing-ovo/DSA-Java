package leetcode.greedy;

import java.util.Arrays;

/**
 * 1054. 距离相等的条形码
 *
 * @author tianxing
 */
public class DistantBarcodes {
    public static void main(String[] args) {
        int[] barcodes = {1, 1, 1, 1, 2, 2, 3, 3};
        System.out.println(Arrays.toString(rearrangeBarcodes(barcodes)));
    }

    /**
     * 1 <= barcodes.length <= 10000
     * 1 <= barcodes[i] <= 10000
     *
     * @param barcodes 条形码数组
     * @return 重新排列后的条形码数组
     */
    public static int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        // 出现频率最高的条形码
        int mostFrequentBarcode = barcodes[0];
        // 计数数组
        int[] count = new int[10001];
        // 当前索引
        int index = 0;
        // 找出出现频率最高的条形码
        for (int barcode : barcodes) {
            // 统计每个条形码出现的次数
            count[barcode]++;
            // 更新出现频率最高的条形码
            if (count[barcode] > count[mostFrequentBarcode]) {
                mostFrequentBarcode = barcode;
            }
        }
        // 先把出现频率最高的条形码填充到偶数索引
        while (count[mostFrequentBarcode] > 0) {
            count[mostFrequentBarcode]--;
            barcodes[index] = mostFrequentBarcode;
            index += 2;
        }
        // 将其他元素按顺序插入
        for (int barcode = 1; barcode <= 10000; barcode++) {
            while (count[barcode] > 0) {
                // 如果当前索引超出最大索引则从索引1开始插入
                if (index >= n) {
                    index = 1;
                }
                count[barcode]--;
                barcodes[index] = barcode;
                index += 2;
            }
        }
        return barcodes;
    }
}

