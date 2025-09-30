// Problem: Best Time to Buy and Sell Stock
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Time complexity: O(n)
// Space complexity: O(1)
// Idea: Track minimum price so far and compute max profit for each day.


class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // Time complexity: O(n)
        int minPrice = INT_MAX;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
};
