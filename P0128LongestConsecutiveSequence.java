import java.util.HashMap;

public class P0128LongestConsecutiveSequence {
  public int longestConsecutive0(int[]nums){//bruce force O(n*n*n) Time limit exceeded
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

  public int longestConsecutive(int[]nums){//O(n)time + o(n) space
    if(nums.length==0)return 0;
    int maxlen = Integer.MIN_VALUE;
    //create hashmap for each element in array and marked as 1 as the value for key in map
    HashMap<Integer,Integer>map = new HashMap<>();
    for(int n:nums){
      if(!map.containsKey(n)){
        map.put(n,1);
      }
      //if encounter duplicate element, then just skip
    }
    for(int i = 0;i<nums.length;i++){//O(n)
      int currentNum = nums[i];
      if(map.get(currentNum)!=0){//如果已经便利过的，map的value是0，则直接跳过
        int len = 1;
        int rightNum = currentNum+1;
        while(map.containsKey(rightNum)){
          map.put(rightNum,map.get(rightNum)-1);//访问过的元素标记成0
          len++;
         rightNum+=1;
        }
        int leftNum = currentNum-1;
        while(map.containsKey(leftNum)){
          map.put(leftNum,map.get(leftNum)-1);
          len++;
          leftNum-=1;
        }
        maxlen = Math.max(maxlen, len);
      }
    }
    return maxlen;
  }
}
