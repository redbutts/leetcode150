package com.astuba;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class LC150_13 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,0,-3,3};
        int[] answer = productExceptSelf(nums);
        System.out.println(Arrays.toString(answer));
    }

    /**
     * 方法一：构造两个辅助数组L和R,L表示nums中每个下标左边的所有数字的乘积，R表示nums中每个下标右边的所有数字的乘积
     * 时间复杂度：O(n),空间复杂度：O(n)
     */
//    public static int[] productExceptSelf(int[] nums)
//    {
//        int[] L = new int[nums.length];
//        int[] R = new int[nums.length];
//        int[] answer = new int[nums.length];
//        L[0] = 1;
//        for(int i = 1; i < L.length; i++)
//        {
//            L[i] = L[i-1] * nums[i-1];
//        }
//        R[R.length-1] = 1;
//        for(int i = R.length-2; i >= 0; i--)
//        {
//            R[i] = R[i+1] * nums[i+1];
//        }
//        for(int i = 0; i < answer.length; i++)
//        {
//            answer[i] = L[i] * R[i];
//        }
//        return answer;
//    }

    /**
     * 方法二：方法一的进阶版，考虑重复利用answer空间以避免开辟内存
     * 先用answer存放L，用变量存放R，然后从右往左，边计算L*R，边更新R
     */
    public static int[] productExceptSelf(int[] nums)
    {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for(int i = 1; i < length; i++)
        {
            answer[i] = answer[i-1] * nums[i-1];
        }
        int R = 1;
        for(int i = length-1; i >= 0; i--)
        {
            answer[i] = answer[i] * R;
            R = R * nums[i];
        }
        return answer;
    }
}
