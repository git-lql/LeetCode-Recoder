package org.lql.leetcode.partone;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2020/12/20 21:17
 * @description: 移动零
 */
public class Number283 {
    private static Logger logger = Logger.getLogger("moveZero");

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{0, 1, 0, 3, 12};
        int[] nums3 = new int[]{0, 1, 0, 3, 12};
        int[] nums4 = new int[]{0, 1, 0, 3, 12};
        logger.debug("Origin：" + Arrays.toString(nums));
        onceMoveZeroes(nums1);
        logger.debug("onceMoveZeroes: " + Arrays.toString(nums1));
        forwardMoveZero(nums2);
        logger.debug("forwardMoveZero: " + Arrays.toString(nums2));
        countZeroMoveZero(nums3);
        logger.debug("countZeroMoveZero: " + Arrays.toString(nums3));
        swapMoveZero(nums4);
        logger.debug("swapMoveZero: " + Arrays.toString(nums4));
    }

    /**
     * 一次遍历
     *
     * @param nums 给定数组
     */
    private static void onceMoveZeroes(int[] nums) {
        //可行性校验
        if (nums == null || nums.length == 0) {
            return;
        }
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[current] = nums[i];
                if (current != i) {
                    nums[i] = 0;
                }
                current++;
            }
        }
    }

    /**
     * 非零元素前移
     *
     * @param nums 给定数组
     */
    private static void forwardMoveZero(int[] nums) {
        //可行性校验
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }

        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /**
     * 统计零元素
     *
     * @param nums 给定数组
     */
    private static void countZeroMoveZero(int[] nums) {
        //可行性校验
        if (nums == null || nums.length == 0) {
            return;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else if (count != 0) {
                nums[i - count] = nums[i];
                nums[i] = 0;
            }
        }
    }

    /**
     * 交换元素位置
     *
     * @param nums 给定数组
     */
    private static void swapMoveZero(int[] nums) {
        //可行性校验
        if (nums == null || nums.length == 0) {
            return;
        }
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                pos++;
            }
        }
    }
}
