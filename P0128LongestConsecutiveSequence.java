public class P0128LongestConsecutiveSequence {
  public int longestConsecutive(int[]nums){//bruce force O(n*n*n) Time limit exceeded
    if(nums.length==0)return 0;
    int maxlen = Integer.MIN_VALUE;
    for(int i = 0;i<nums.length;i++){//O(n)
      int len = 1;
      int target = nums[i]+1;
      while(checkNumberExist(nums,target)){
        len++;
        target++;
      }
      maxlen=Math.max(maxlen, len);
    }
    return maxlen;
  }

  public boolean checkNumberExist(int[]nums,int target){
    for(int n:nums){
      if(n==target){
        return true;
      }
    }
    return false;
  }
}
