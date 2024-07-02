package com.astuba;

import java.util.Arrays;

/**
 * 加油站
 *
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则它必定是唯一的。
 */
public class LC150_14 {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        int can = canCompleteCircuit(gas, cost);
        System.out.println(can);
    }

    /**
     * 方法一：
     * 如果x到达不了y+1，那么x--y之间的点也不可能到达y+1，因为中间任何一点的油都是拥有前面的余量的，所以下次遍历直接从y+1开始
     */
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int n = gas.length;
//        int i = 0;
//        while(i < n)
//        {
//            int sumOfGas = 0, sumOfCost = 0, count = 0;
//            while(count < n)
//            {
//                int j = (i + count) % n;
//                sumOfGas = sumOfGas + gas[j];
//                sumOfCost = sumOfCost + cost[j];
//                if(sumOfCost > sumOfGas)
//                {
//                    break;
//                }
//                count++;
//            }
//            if(count == n)
//            {
//                return i;
//            } else {
//                i = i + count + 1;
//            }
//        }
//        return -1;
//    }

    /**
     * 方法二：
     * 由于题目说如果有解必是唯一解，跑一圈下来油量最少的点就是终点，终点的下一个点就是起点
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int sum = 0, min = Integer.MAX_VALUE, minIndex = -1;
        for(int i = 0; i < length; i++)
        {
            // 遍历i之后的总油量
            sum = sum + gas[i] - cost[i];
            if(sum < min && sum < 0)  // 如果sum < min的同时满足 sum > 0，则不会有唯一解
            {
                min = sum;
                minIndex = i;
            }
        }
        // 如果总油量小于总油耗，则无论如何都跑不完一圈
        if(sum < 0)
        {
            return -1;
        }
        return (minIndex + 1) % length;
    }
}
