package bloomfilter;

import java.nio.charset.StandardCharsets;
import java.util.BitSet;

/**
 * 布隆过滤器
 *
 * @author tianxing
 */
public class BloomFilter<T> {

    private final BitSet bitSet;
    private final int bitSize;
    private final int hashFunctionCount;

    public BloomFilter() {
        this(10000, 0.01);
    }

    /**
     * 初始化布隆过滤器
     *
     * @param expectedInsertions 预期插入量
     * @param fpp                误判率
     */
    public BloomFilter(int expectedInsertions, double fpp) {
        if (expectedInsertions <= 0) {
            throw new IllegalArgumentException("预期插入量必须大于0");
        }
        if (fpp <= 0 || fpp >= 1) {
            throw new IllegalArgumentException("误判率必须在(0, 1)之间");
        }
        bitSize = optimalNumOfBits(expectedInsertions, fpp);
        hashFunctionCount = optimalNumOfHashFunctions(expectedInsertions, bitSize);
        bitSet = new BitSet(bitSize);
    }

    /**
     * 向布隆过滤器中添加一个元素
     *
     * @param element 待添加的元素
     */
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("元素不能为null");
        }
        byte[] bytes = toBytes(element);
        long hash64 = murmurHash64(bytes);
        // 拆分为高低两个32位哈希值
        int hash1 = (int) hash64;
        int hash2 = (int) (hash64 >>> 32);
        for (int i = 1; i <= hashFunctionCount; i++) {
            // 计算组合哈希值
            int combinedHash = hash1 + (i * hash2);
            // 计算位图索引
            int bitIndex = Math.abs(combinedHash % bitSize);
            // 将bitIndex位置的位设置为1
            bitSet.set(bitIndex);
        }
    }

    /**
     * 判断指定元素是否可能存在于布隆过滤器中
     *
     * @param element 待判定的元素
     * @return true(可能存在)false(绝对不存在)
     */
    public boolean mightContain(T element) {
        if (element == null) {
            return false;
        }
        byte[] bytes = toBytes(element);
        long hash64 = murmurHash64(bytes);
        int hash1 = (int) hash64;
        int hash2 = (int) (hash64 >>> 32);
        for (int i = 1; i <= hashFunctionCount; i++) {
            // 计算组合哈希值
            int combinedHash = hash1 + (i * hash2);
            // 计算位图索引
            int bitIndex = Math.abs(combinedHash % bitSize);
            // 任意1个bit位为0说明该元素绝对不存在
            if (!bitSet.get(bitIndex)) {
                return false;
            }
        }
        // 所有bit位都为1说明该元素可能存在
        return true;
    }

    /* 清空布隆过滤器 */
    public void clear() {
        bitSet.clear();
    }

    @Override
    public String toString() {
        return "BloomFilter{" +
                "bitSize=" + bitSize +
                ", hashFunctionCount=" + hashFunctionCount +
                '}';
    }

    /**
     * 计算最优位图位数
     *
     * @param n 预期插入量
     * @param p 误判率
     * @return 最优位图位数
     */
    private static int optimalNumOfBits(long n, double p) {
        // bitSize = -n * ln(p) / (ln(2) * ln(2))
        return (int) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }

    /**
     * 计算最优哈希函数个数
     *
     * @param n 预期插入量
     * @param m 位图位数
     * @return 最优哈希函数个数
     */
    private static int optimalNumOfHashFunctions(long n, long m) {
        // hashFunctionCount = (m / n) * ln(2)
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }

    /**
     * 将对象转换为字节数组
     *
     * @param element 待转换的元素
     * @return 元素的字节数组
     */
    private byte[] toBytes(T element) {
        return element.toString().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * MurmurHash64哈希算法
     *
     * @param data 待哈希的字节数组
     * @return 哈希值
     */
    private static long murmurHash64(byte[] data) {
        final long m = 0xc6a4a7935bd1e995L;
        final int r = 47;
        final long seed = 0xe17a1465L;
        long h = seed ^ (data.length * m);
        int length8 = data.length / 8;
        for (int i = 0; i < length8; i++) {
            int i8 = i * 8;
            long k = ((long) data[i8] & 0xff) | (((long) data[i8 + 1] & 0xff) << 8) | (((long) data[i8 + 2] & 0xff) << 16) | (((long) data[i8 + 3] & 0xff) << 24) | (((long) data[i8 + 4] & 0xff) << 32) | (((long) data[i8 + 5] & 0xff) << 40) | (((long) data[i8 + 6] & 0xff) << 48) | (((long) data[i8 + 7] & 0xff) << 56);
            k *= m;
            k ^= k >>> r;
            k *= m;
            h ^= k;
            h *= m;
        }
        int rem = data.length % 8;
        int offset = length8 * 8;
        if (rem > 0) {
            long k = 0;
            for (int i = rem - 1; i >= 0; i--) {
                k = (k << 8) | (data[offset + i] & 0xff);
            }
            k *= m;
            k ^= k >>> r;
            k *= m;
            h ^= k;
        }
        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;
        return h;
    }
}
