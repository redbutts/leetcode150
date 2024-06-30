package com.astuba;

/**
 * 跳跃游戏 II
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 返回跳到数组末尾的最小跳跃次数，假设总能跳到最后
 */
public class LC150_10 {


    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }


    /**
     * 顺序：从左往右，找到第1步范围内，跳的最远的那个位置，将其作为第2步，然后找到第2步范围内跳的最远的点，以此类推
     */
    public static int jump(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return 0;
        }

        int step = 0, maxPosition = 0, end = 0;
        for (int i = 0; i < l - 1; i++) {
            maxPosition = Math.max(nums[i] + i, maxPosition);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    /**
     * 时间复杂度为 O(n^2)
     * 倒序：从右往左，找到最左的可以1步跳到终点的坐标，计1步，然后目标更新为这个坐标，继续寻找可以1步跳到新目标的最左坐标
     */
//    public static int jump(int[] nums) {
//        int position = nums.length - 1;
//        int steps = 0;
//        while (position > 0) {
//            for (int i = 0; i < position; i++) {
//                if (i + nums[i] >= position) {
//                    position = i;
//                    steps++;
//                    break;
//                }
//            }
//        }
//        return steps;
//    }


}
