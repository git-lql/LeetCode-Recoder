package org.lql.leetcode.partone;

import org.apache.log4j.Logger;

/**
 * @author: lql
 * @date: 2020/12/20 21:42
 * @description: 爬楼梯
 */
public class Number70 {

    private static Logger logger = Logger.getLogger("climbStairs");

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     */
    public static void main(String[] args) {
        int n = 5;
        int count = dynamicClimbStairs(n);
        logger.debug("dynamicClimbStairs: " + count);
        count = matrixClimbStairs(n);
        logger.debug("matrixClimbStairs: " + count);
        count = generalClimbStairs(n);
        logger.debug("generalClimbStairs: " + count);
    }

    /**
     * 动态规划
     *
     * @param n 给定楼梯阶级数
     * @return 爬楼梯方式总数
     */
    private static int dynamicClimbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 矩阵快速幂
     *
     * @param n 给定楼梯阶梯数
     * @return 爬楼梯方总和
     */
    private static int matrixClimbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];

    }

    private static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    /**
     * 通项公式
     *
     * @param n 给定楼梯阶梯数
     * @return 爬楼梯总数
     */
    private static int generalClimbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }

}
