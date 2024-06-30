package com.astuba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * O(1) 时间插入、删除和获取随机元素
 *
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 */
public class LC150_12 {



    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean insert1 = randomizedSet.insert(0);
        boolean insert2 = randomizedSet.insert(1);
        boolean remove1 = randomizedSet.remove(0);
        boolean insert3 = randomizedSet.insert(2);
        boolean remove2 = randomizedSet.remove(1);
        int random = randomizedSet.getRandom();
        System.out.println(insert1);
        System.out.println(insert2);
        System.out.println(remove1);
        System.out.println(insert3);
        System.out.println(remove2);
        System.out.println(random);
        System.out.println(randomizedSet.list);
    }

}
class RandomizedSet {
     List<Integer> list;
     HashMap<Integer, Integer> map;
     Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val))
        {
            return false;
        }
        int index = list.size();
        list.add(index, val);
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val))
        {
            return false;
        }
        Integer index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index, last);
        map.put(last,index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

        public int getRandom() {
            int i = random.nextInt(list.size());
            return list.get(i);
        }
}
