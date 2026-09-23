package 布隆过滤器;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 布隆过滤器单元测试
 *
 * @author tianxing
 */
public class BloomFilterTest {

    @Test
    @DisplayName("添加和存在性测试")
    public void testAddAndMightContain() {
        BloomFilter<String> filter = new BloomFilter<>(1000, 0.01);
        filter.add("apple");
        filter.add("banana");
        filter.add("orange");
        // BloomFilter{bitSize=9585, hashFunctionCount=7}
        System.out.println(filter);
        // 已添加的元素绝对存在
        assertTrue(filter.mightContain("apple"));
        assertTrue(filter.mightContain("banana"));
        assertTrue(filter.mightContain("orange"));
        // 未添加的元素大概率不存在
        assertFalse(filter.mightContain("watermelon"));
        assertFalse(filter.mightContain("grape"));
    }

    @Test
    @DisplayName("清空测试")
    public void testClear() {
        BloomFilter<Integer> filter = new BloomFilter<>();
        // BloomFilter{bitSize=95850, hashFunctionCount=7}
        System.out.println(filter);
        for (int i = 0; i < 100; i++) {
            filter.add(i);
        }
        filter.clear();
        for (int i = 0; i < 100; i++) {
            // 清空后所有元素绝对不存在
            assertFalse(filter.mightContain(i));
        }
        filter.add(999);
        // 已添加的元素绝对存在
        assertTrue(filter.mightContain(999));
    }

    @Test
    @DisplayName("误判率测试")
    public void testFalsePositiveRate() {
        int expectedInsertions = 10000;
        double fpp = 0.01;
        BloomFilter<String> filter = new BloomFilter<>(expectedInsertions, fpp);
        // 插入预期插入量的元素
        for (int i = 0; i < expectedInsertions; i++) {
            filter.add("inserted_" + i);
        }
        // 验证已插入的元素绝无漏报
        for (int i = 0; i < expectedInsertions; i++) {
            assertTrue(filter.mightContain("inserted_" + i));
        }
        // 用大量未插入的元素测试误判次数
        int testCount = 50000;
        int falsePositives = 0;
        for (int i = 0; i < testCount; i++) {
            if (filter.mightContain("uninserted_" + i)) {
                falsePositives++;
            }
        }
        // 计算实际误判率
        double empiricalFpp = (double) falsePositives / testCount;
        // 实际误判率: 1.00% (误判数: 500 / 50000)
        System.out.printf("实际误判率: %.2f%% (误判数: %d / %d)%n", empiricalFpp * 100, falsePositives, testCount);
        // 验证实际误判率是否在2%内
        assertTrue(empiricalFpp < 0.02, "实际误判率偏高: " + empiricalFpp);
    }
}
