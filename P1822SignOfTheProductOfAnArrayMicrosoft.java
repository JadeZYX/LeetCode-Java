public class P1822SignOfTheProductOfAnArrayMicrosoft {
  public int arraySign(int[]nums){
    int negative = 0;
    for(int n: nums){
      if(n==0)return 0;
      if(n<0) {
        negative++;
      }
    }
    return negative%2==0?1:-1;
  }

  public int arraySign1(int[]nums){
    boolean isNegative=false;
    for(int n:nums){
      if(n==0)return 0;
      if(n<0){
        isNegative=!isNegative;
      }
    }
    return isNegative?-1:1;
  }
}
/*
 * 这道题是查看array里的每一项的乘积是否是0，是则返回0；若product大于0
 * 若product小于0，则返回-1
 * 不能简单粗暴的去求乘积，因为会出现溢出的报错。所以要用求负数个数的思路来解题
 */