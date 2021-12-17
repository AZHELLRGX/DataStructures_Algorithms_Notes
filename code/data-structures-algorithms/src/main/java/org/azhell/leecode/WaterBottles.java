package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 1518. 换酒问题
 * 太简单的题不屑于做，太难的题做不出来，真实
 */
public class WaterBottles {
    public static void main(String[] args) {
        WaterBottles w = new WaterBottles();
        Utils.print(w.numWaterBottles(9, 3));
        Utils.print(w.numWaterBottles(15, 4));
        Utils.print(w.numWaterBottles(5, 5));
        Utils.print(w.numWaterBottles(2, 3));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int numDrink = numBottles;
        while (numBottles >= numExchange) {
            int newDrink = numBottles / numExchange;
            numDrink += newDrink;
            numBottles = newDrink + numBottles % numExchange;
        }
        return numDrink;
    }
}
