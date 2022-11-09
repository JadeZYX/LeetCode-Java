public class P121MicrosoftBestTimeToBuyAndSellStock {
  public int maxProfit(int[]prices){//O(n)+O(1)
    int maxprofit = 0;
    int minPrice = Integer.MAX_VALUE;
    for(int n:prices){
      minPrice = Math.min(minPrice,n);
      maxprofit = Math.max(maxprofit, n-minPrice);
    }
    return maxprofit;
  }
}
//买入股票要在价格的最低点，然后再高点卖出
//循环array，随时更新最低值，差价，以及最高值