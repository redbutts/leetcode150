package com.astuba;

/**
 * 分发糖果
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */
public class LC150_15 {
    public static void main(String[] args) {
        int[] ratings = new int[]{1,2,2};
        int res = candy(ratings);
        System.out.println(res);
    }

    /**
     * 方法一：
     * 如果x到达不了y+1，那么x--y之间的点也不可能到达y+1，因为中间任何一点的油都是拥有前面的余量的，所以下次遍历直接从y+1开始
     */
    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        for(int i = 0; i < length; i++)
        {
            if(i > 0 && ratings[i] > ratings[i-1])
            {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0;
        int ret = 0;
        for(int i = length-1; i >= 0; i--)
        {
            if(i < length-1 && ratings[i] > ratings[i+1])
            {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    /**
     * 方法二：
     * 由于题目说如果有解必是唯一解，跑一圈下来油量最少的点就是终点，终点的下一个点就是起点
     */
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int length = gas.length;
//        int sum = 0, min = Integer.MAX_VALUE, minIndex = -1;
//        for(int i = 0; i < length; i++)
//        {
//            // 遍历i之后的总油量
//            sum = sum + gas[i] - cost[i];
//            if(sum < min && sum < 0)  // 如果sum < min的同时满足 sum > 0，则不会有唯一解
//            {
//                min = sum;
//                minIndex = i;
//            }
//        }
//        // 如果总油量小于总油耗，则无论如何都跑不完一圈
//        if(sum < 0)
//        {
//            return -1;
//        }
//        return (minIndex + 1) % length;
//    }
}
