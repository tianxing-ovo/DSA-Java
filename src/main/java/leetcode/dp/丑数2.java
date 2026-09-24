package leetcode.dp;

import java.util.PriorityQueue;

/**
 * 264.丑数2
 */
public class 丑数2 {
    /**
     * 1
     * 2 3 5
     * 3 4 5 6 10
     * 4 5 6 6 9 10 15
     * 5 6 6 8 9 10 12 15 20
     * 6 6 8 9 10 10 12 15 15 20 25
     */
    public static void main(String[] args) {
        System.out.println(nthUglyNumber1(10));
        System.out.println(nthUglyNumber2(10));
    }

    /**
     * 优先队列
     */
    public static int nthUglyNumber1(int n) {
        Long ugly = 1L;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(ugly);
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty()) {
                ugly = queue.poll();
            }
            // 去重
            while (!queue.isEmpty() && queue.peek().equals(ugly)) {
                queue.poll();
            }
            queue.add(ugly * 2);
            queue.add(ugly * 3);
            queue.add(ugly * 5);
        }
        return ugly.intValue();
    }

    /**
     * 动态规划/三指针
     */
    public static int nthUglyNumber2(int n) {
        // 表示下一个丑数是当前指针指向的丑数乘以对应的质因数
        int p2 = 1, p3 = 1, p5 = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n];
    }
}
