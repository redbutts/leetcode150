package com.astuba;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class LC150_1 {
    public static void main(String[] args) {
        int[] nums1 = new int[9];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 2;
        nums1[3] = 9;
        int[] nums2 = new int[]{3, 5, 7, 9, 12};
        int m = 4, n= 5;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int len1= m-1, len2= n-1, len = m+n-1;
        while(len1 >= 0 && len2 >= 0)
        {
            if(nums1[len1] > nums2[len2])
            {
                nums1[len] = nums1[len1];
                len1 --;
            } else {
                nums1[len] = nums2[len2];
                len2--;
            }
            len --;
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
}
