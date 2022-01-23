package org.azhell.leecode;

import org.azhell.tool.Utils;

import java.util.*;

/**
 * 2034. 股票价格波动
 */
public class StockPriceFluctuation {
    public static void main(String[] args) {
        StockPrice s = new StockPrice();
        s.update(1, 10);
        s.update(2, 5);
        Utils.print(s.current());
        Utils.print(s.maximum());
        s.update(1, 3);
        Utils.print(s.maximum());
        s.update(4, 2);
        Utils.print(s.minimum());
    }

    static class StockPrice {

        int maxTimestamp;
        // 存储价格和出现次数的对应关系
        TreeMap<Integer, Integer> treeMap;
        // 存储时间和价格的对应关系
        HashMap<Integer, Integer> hashMap;

        public StockPrice() {
            this.treeMap = new TreeMap<>();
            this.hashMap = new HashMap<>();
        }

        public void update(int timestamp, int price) {
            maxTimestamp = Math.max(timestamp, maxTimestamp);
            // 获取之前这个时间对应的价格
            Integer prePrice = hashMap.getOrDefault(timestamp, 0);
            hashMap.put(timestamp, price);
            // 下面的一段代码是为了避免股票价格重复值的情况
            // 如果一个价格在多次update以后，已经没有这个价位对应的时间点，那么就可以remove
            if (prePrice > 0) {
                // 说明不是第一次加入
                treeMap.put(prePrice, treeMap.get(prePrice) - 1);
                if (treeMap.get(prePrice) == 0) {
                    treeMap.remove(prePrice);
                }
            }
            // 新的价格加入
            treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
        }

        public int current() {
            return hashMap.get(maxTimestamp);
        }

        public int maximum() {
            return treeMap.lastKey();
        }

        public int minimum() {
            return treeMap.firstKey();
        }
    }

}
