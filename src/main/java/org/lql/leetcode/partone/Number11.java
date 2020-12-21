package org.lql.leetcode.partone;

import org.apache.log4j.Logger;

/**
 * @author: lql
 * @date: 2020/12/20 21:03
 * @description: 盛最多水的容器
 */
public class Number11 {

    private static Logger logger = Logger.getLogger("盛最多水的容器");

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     */
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = violenceMaxArea(height);
        logger.debug("暴力枚举： " + area);
        area = pointerMaxArea(height);
        logger.debug("双指针： " + area);
    }

    /**
     * 暴力枚举
     *
     * @param height 容器高度数组
     * @return 最大面积
     */
    private static int violenceMaxArea(int[] height) {
        int area = 0;
        int length = height.length;
        int head = 0;
        int tail = length - 1;
        for (int i = 0; i < length; i++) {
            for (int j = tail; j > head; j--) {
                int temp = Math.min(height[i], height[j]) * (j - i);
                area = Math.max(area, temp);
            }
        }
        return area;
    }

    /**
     * 双指针向内收敛
     *
     * @param height 容器数组
     * @return 最大面积
     */
    private static int pointerMaxArea(int[] height) {
        int area = 0;
        int length = height.length;
        int head = 0;
        int tail = length - 1;
        while (head < tail) {
            int temp = Math.min(height[head], height[tail]) * (tail - head);
            area = Math.max(area, temp);
            if (height[head] < height[tail]) {
                ++head;
            } else {
                --tail;
            }
        }
        return area;
    }
}
