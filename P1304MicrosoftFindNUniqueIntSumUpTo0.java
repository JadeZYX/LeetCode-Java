public class P1304MicrosoftFindNUniqueIntSumUpTo0 {
  public int[]sumZero(int n){
    int[]res = new int[n];
    int start = 1;
    int index = 0;
    if(n%2==0){//even n=4 middle=4/2 [1,2,-2,-1]
      while(start<=n/2){
        res[index]=start;
        res[n-index-1]=start*(-1);
        index++;
        start++;
      }
    }
    if(n%2==1){//n is odd, n=5 middle = 5/2 [1,2,0,-2,-1]
      while(start<=n/2){
        res[index]=start;
        res[n-index-1]=start*(-1);
        index++;
        start++;
      }
      res[n/2]=0;
    }
    return res;
  }

  public int[] sumZero1(int n) {
    int[]res=new int[n];
    int index = 0;
    int division = n/2;
    while(division>0){
        res[index]=division;
        res[index+1]=(-1)*division;
        index=index+2;//因为上一步我们已经更新了index和index+1位置上的值，所以这里是加2
        division--;
    }
    if(n%2==1){//如果是偶数，上面的while循环就处理完毕。
        res[index]=0;
    }
    return res;
}

}
/*
 *  需要通过例子来讲解题思路。取双数偶数
 */
