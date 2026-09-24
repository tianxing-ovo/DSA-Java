package leetcode.hash;

import java.util.*;

/**
 * 49.字母异位词分组
 */
public class 字母异位词分组 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    /**
     * @param strs 字符串数组(仅包含小写字母)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars), key -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
