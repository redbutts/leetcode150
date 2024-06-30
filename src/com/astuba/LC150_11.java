package com.astuba;

import java.util.Arrays;

/**
 * H 指数
 *
 * 给你一个整数数组citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * 根据维基百科上h指数的定义：h代表“高引用次数” ，一名科研人员的h指数是指他（她）至少发表了h篇论文，并且至少有h篇论文被引用次数大于等于h。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 *
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 */
public class LC150_11 {



    public static void main(String[] args) {
        int[] citations = new int[]{3,0,2,1,1};
        System.out.println(hIndex(citations));
    }


    /**
     * 方法1：先排序，然后从后往前（因为排序是从小到大），12345， 5：至少1篇引用1次-->4：至少2篇引用2次-->3：至少3篇引用3次
     */
//    public static int hIndex(int[] citations) {
//        Arrays.sort(citations);
//        int h = 0, i = citations.length - 1;
//        while (i > 0 && citations[i] > h)
//        {
//            h++;
//            i--;
//        }
//        return h;
//    }

    /**
     * 方法2：二分法，数组长度为l，则h范围为[0,l]，我们取中点，然后遍历数组并计数，验证是否有至少h个数大于等于h，
     * 若没有，则h的范围调整为[0,h/2]
     * 否则h的范围调整为[h/2,l]
     * 然后继续遍历计数验证，不断缩小h的取值范围，最终确定h
     */
    public static int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        int mid = 0, count = 0;
        while(left < right)
        {
            mid = (left + right + 1) / 2;
            for(int c : citations)
            {
                if(c >= mid)
                {
                    count++;
                }
            }
            if(count >= mid)
            {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

}
