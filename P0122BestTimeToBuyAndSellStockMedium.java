public class P0122BestTimeToBuyAndSellStockMedium {
  public int maxProfit(int[]prices){
    //edge case
    if(prices.length<2)return 0;
    int profit = 0;
    for(int i = 0;i<prices.length-1;i++){
      if(prices[i]<prices[i+1]){
        profit += (prices[i+1]-prices[i]);
      }
    }
    return profit;
  }
}
/*
 * 这道题目与121的不同之处是，它可以进行多次操作，且每次只能持有一种股票。所以我们只要满足低点购入，
 * 高点抛出即可。
 * 所以查看相邻的两个位置，如果后面的值比前面的值大，则差值就纳入profit里。如果连续三个数都是前面的数小于后面的数，其实相当于把整个利润分成两部分加进去，同等于低点买入，高点卖出[1,2,3,4,5]:2-1+(3-2)+(4-3)+(5-4)=5-1=4.
[7,1,5,3,6,4]:5-1+(6-3)=7.
[5,1,3,4,3,5]:3-1+(4-3)+(5-3)=5,虽然1，3，4连续涨三天，利润是3，这里分成了1，3 和 3，4
[7,6,4,3,1]没有后一个数大于前一个数的情况，所以利润是0.
 */
