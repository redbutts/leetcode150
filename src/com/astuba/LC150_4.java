package com.astuba;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class LC150_4 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int r = removeDuplicates(nums);
        System.out.println(r);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int k = 2, l = nums.length;
        for(int i = 2; i < l; i++)
        {
            if(nums[i] != nums[k-2])
            {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
