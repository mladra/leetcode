package com.code.leet.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

// 121. Best Time to Buy and Sell Stock
public class BestTimeToBuyAndSellStockLeetCodeTest {

    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int sellPrice = Integer.MIN_VALUE;
        int buyIdx = -1;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                if (buyIdx != -1 && sellPrice - buyPrice > maxProfit) {
                    maxProfit = sellPrice - buyPrice;
                }
                buyPrice = prices[i];
                buyIdx = i;
                sellPrice = buyPrice;
            }

            if (prices[i] > sellPrice) {
                sellPrice = prices[i];
            }
        }
        if (sellPrice - buyPrice > maxProfit) {
            maxProfit = sellPrice - buyPrice;
        }
        return maxProfit;
    }

    @ParameterizedTest(name = "prices={0}, expectedMaxProfit={1}")
    @MethodSource("testInput")
    void test(int[] prices, int expectedMaxProfit) {
        int profit = maxProfit(prices);
        Assertions.assertEquals(expectedMaxProfit, profit);
    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
                Arguments.of(new int[]{1, 2}, 1),
                Arguments.of(new int[]{2, 4, 1}, 2),
                Arguments.of(new int[]{3, 2, 6, 5, 0, 3}, 4),
                Arguments.of(new int[]{4, 7, 2, 1}, 3)
        );
    }

}
