package com.astuba;

/**
 * 跳跃游戏
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class LC150_9 {

    /**
     * t = 7
     * 70001101
     */
    public static void main(String[] args) {
        int[] nums = new int[]{6,5,0,0,1,1,0,1};
        System.out.println(canJump(nums));
    }

    /**
     * 倒逼：例如231800400201为了到达目标1， 我们找到最后一个可到达此目标的点，即2，这样我们的目标改为2，依此类推，目标变为4、8、1、3、2，
     * 只要最终目标能遍历到数组初始位置，就说明可以到达
     */
//    public static boolean canJump(int[] nums) {
//        int l = nums.length;
//        if(l == 1){
//            return true;
//        }
//        if(nums[0] == 0)
//        {
//            return false;
//        }
//        int target = l - 1; // 目标
//        for(int i = l - 2; i >=0; i--)
//        {
//            target = nums[i] + i >= target ? i : target;
//        }
//        return target == 0;
//    }

    /**
     * 正序：最远到达
     */
    public static boolean canJump(int[] nums) {
        int l = nums.length;
        if(l == 1){
            return true;
        }
        if(nums[0] == 0)
        {
            return false;
        }
        int farest = 0; // 最远到达
        for(int i = 0; i < l-1; i++)
        {
            if(i <= farest)
            {
                farest = Math.max(nums[i] + i, farest);
            }
            if(farest >= l-1)
            {
                return true;
            }
        }
        return false;
    }
}
