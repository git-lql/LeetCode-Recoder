package org.lql.leetcode.partone;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2020/12/25 14:00
 * @description: 26.删除排序数组中的重复项
 */
public class RemoveDuplicates {

    private static Logger logger = Logger.getLogger("RemoveDuplicates");

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        logger.debug("Origin： " + Arrays.toString(nums));

        int len = removeDuplicates(nums);
        logger.debug("removeDuplicates: " + len);
        logger.debug("removeDuplicates： " + Arrays.toString(nums));

        nums = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5};
        len = pointRemoveDuplicates(nums);
        logger.debug("pointRemoveDuplicates: " + len);
        logger.debug("pointRemoveDuplicates： " + Arrays.toString(nums));

        nums = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5};
        len = pointsRemoveDuplicates(nums);
        logger.debug("pointsRemoveDuplicates: " + len);
        logger.debug("pointsRemoveDuplicates： " + Arrays.toString(nums));
    }

    /**
     * 官方
     *
     * @param nums 数组
     * @return 去除重复元素后的数组长度
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 双指针
     *
     * @param nums 原数组
     * @return 去重后的数组
     */
    private static int pointRemoveDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    /**
     * 优化后的双指针
     *
     * @param nums 原数组
     * @return 去重后的数组
     */
    private static int pointsRemoveDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
