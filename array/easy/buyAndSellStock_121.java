public class buyAndSellStock_121 {
    static int profit(int prices[]) {
/*
---------------------------------------------------------
Approach : Brute Force
---------------------------------------------------------

Idea:
1. Try every possible buying day.
2. For each buying day, check every possible selling day
   after it.
3. Calculate the profit for every valid pair.
4. Keep track of the maximum profit found.

Why it works?
- It examines every possible buy and sell combination.
- Since every valid transaction is checked, the maximum
  profit is guaranteed to be found.

Time Complexity:
O(n²)

Space Complexity:
O(1)
*/
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
/*
---------------------------------------------------------
Approach : Optimal (Greedy / One Pass)
---------------------------------------------------------

Idea:
1. Traverse the array only once.
2. Keep track of the minimum stock price seen so far.
3. For every price, calculate the profit if the stock is
   sold on the current day.
4. Update the maximum profit whenever a larger profit is found.

Why it works?
- The best buying day for any selling day is simply the
  minimum price encountered before that day.
- Instead of checking every previous day (O(n²)),
  we remember only the minimum price, reducing the
  complexity to O(n).

Time Complexity:
O(n)

Space Complexity:
O(1)
*/

    static int optimalProfit(int prices[]) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3 };
        System.out.println("maxprofit by brute force = " + profit(prices));
        System.out.println("maxprofit by optimal technique = " + optimalProfit(prices));

    }
}
