package com.astuba;


import java.util.Arrays;

/**
 * 移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 */
public class LC150_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int r = removeElement(nums, 2);
        System.out.println(r);
        System.out.println(Arrays.toString(nums));
    }


    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for(int right = 0; right < n; right++)
        {
            if(nums[right] == val)
            {
                continue;
            }
            nums[left] = nums[right];
            left++;
        }
        return left;
    }
}
