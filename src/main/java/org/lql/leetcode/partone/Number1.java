package org.lql.leetcode.partone;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: lql
 * @date: 2020/12/20 20:42
 * @description: 两数之和
 */
public class Number1 {

    private static Logger logger = Logger.getLogger("Number1");

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ret = violenceTwoSum(nums, target);
        logger.debug("暴力枚举： " + Arrays.toString(ret));
        ret = hashTwoSum(nums, target);
        logger.debug("Hash: " + Arrays.toString(ret));
    }

    /**
     * 暴力枚举
     *
     * @param nums   给定数组
     * @param target 目标值
     * @return 符合条件数组元素下标数组
     */
    private static int[] violenceTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * Hash
     *
     * @param nums   给定数组
     * @param target 目标值
     * @return 符合条件数组元素下标数组
     */
    private static int[] hashTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}
