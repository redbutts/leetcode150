package com.astuba;


import java.util.Arrays;

/**
 * 找出数组中的多数元素
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于  n/2 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class LC150_5 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int r = majorityElement(nums);
        System.out.println(r);
        System.out.println(Arrays.toString(nums));
    }


//    public static int majorityElement(int[] nums) {
//        int length = nums.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            Integer count = map.get(num);
//            if (count == null) {
//                count = 1;
//            } else {
//                count = count + 1;
//            }
//            if (count > length / 2) {
//                return num;
//            }
//            map.put(num, count);
//        }
//        return 0;
//    }

    public static int majorityElement(int[] nums) {
        int mostNum = -1, mostCount = 0;
        for (int num : nums) {
            if (mostCount == 0) {
                mostNum = num;
                mostCount++;
                continue;
            }
            if (num == mostNum) {
                mostCount++;
            } else {
                mostCount--;
            }
            if (mostCount == 0) {
                mostNum = -1;
            }
        }
        return mostNum;
    }
}
