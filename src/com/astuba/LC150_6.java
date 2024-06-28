package com.astuba;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class LC150_6 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate2(nums, 10);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 方法一：用新数组来存放
     */
    public static void rotate1(int[] nums, int k) {
        int length = nums.length;
        int m = k % length;
        int[] copy = new int[length];
        System.arraycopy(nums, 0, copy, 0, length);
        for(int i = 0; i < length; i++)
        {
            nums[(i + m) % length] = copy[i];
        }
    }

    /**
     * 方法二：翻转数组
     * 原数组：1234567  k = 3
     * 首次反转：7654321
     * 第二次反转:5674321
     * 第三次反转：5671234
     */
    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        int m = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, m - 1);
        reverse(nums, m, length - 1);
    }

    /**
     * 反转数组辅助方法
     * @param nums 整体数组
     * @param start 开始位置
     * @param end 结束位置
     */
    static void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    /**
     * 方法三：环状替换
     * length=7, k=2
     * 0->2, 2->4, 4->6, 6->1, 1->3, 3->5, 5->0
     */
}
//1234567
//5671234