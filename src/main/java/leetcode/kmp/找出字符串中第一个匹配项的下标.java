package leetcode.kmp;

/**
 * 28.找出字符串中第一个匹配项的下标
 *
 * @author tianxing
 */
public class 找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        // 文本串
        String haystack = "aabaabaaf";
        // 模式串
        String needle = "aabaaf";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 前缀: 包含首字母,不包含尾字母的所有子串
     * 后缀: 包含尾字母,不包含首字母的所有子串
     */
    public static int strStr(String haystack, String needle) {
        int n = needle.length();
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        // 前缀表,计算最长相等前后缀
        int[] next = new int[n];
        // i: 前缀末尾指针/最长相等前后缀  j: 后缀末尾指针
        for (int i = 0, j = 1; j < n; j++) {
            // 遇到冲突,回退到i的前一位的next值
            while (i > 0 && needleArray[i] != needleArray[j]) {
                i = next[i - 1];
            }
            if (needleArray[i] == needleArray[j]) {
                i++;
                next[j] = i;
            }
        }
        // i: haystack指针 j: needle指针
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            // 遇到冲突,回退到j的前一位的next值
            while (j > 0 && haystackArray[i] != needleArray[j]) {
                j = next[j - 1];
            }
            if (haystackArray[i] == needleArray[j]) {
                j++;
            }
            if (j == n) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
