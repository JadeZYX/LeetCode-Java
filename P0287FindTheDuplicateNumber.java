import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class P0287FindTheDuplicateNumber {
  public int findDuplicate(int[]nums){ //hashmap 做法，时间复杂度 O（N），空间复杂度O（N）
    HashMap<Integer,Integer>map = new HashMap<>();
    for(int i = 0;i<=nums.length-1;i++){
    // map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
      if(map.containsKey(nums[i])){
        //map.put(nums[i],map.get(nums[i])+1);
        return nums[i];
      }
      else{
        map.put(nums[i],1);
      }
    }
    // for(Map.Entry<Integer,Integer>set:map.entrySet()){
    //   if(set.getValue()>=2){ //[2,2,2,2]
    //     return set.getKey();
    //   }
    // }
    return 1;
  }

  /*
   * 还可以用hashset来做，虽然在空间复杂度O（N）上不符合要求，但是可以作为一种解题思路
   * Arrays.sort(arr) 时间复杂度是 O(logn),空间复杂度是O(logn)
   */
  public int findDuplicate1(int[]nums){//O(nlogn)+ O(logn)
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i-1])
          return nums[i];
    }
    return -1;
  }

  public int findDuplicate2(int[] nums) { //O(n) + O(n)
    HashSet<Integer> seen = new HashSet<Integer>();
    for (int num : nums) {
        if (seen.contains(num))
            return num;
        seen.add(num);
    }
    return -1;
  }
  public int findDuplicate3(int[]nums){//T:O(N)+ S: O(1)
    //find the intersection point of the two runners
    int tortoise = nums[0];
    int hare = nums[0];
    //如果没有下面两行，则因为起点都在同一个位置，所以没发进入while循环内，所以这里先要兔子跑两步，乌龟一步
    tortoise = nums[tortoise];
    hare = nums[nums[hare]];
    while(tortoise!= hare){
      tortoise = nums[tortoise];
      hare = nums[nums[hare]];
    }
    //find the 'entrance'to the cycle
    tortoise = nums[0];
    while(tortoise != hare){
      tortoise = nums[tortoise];
      hare = nums[hare];
    }
    return tortoise;
  }
}
/*
 *
 P0287FindTheDuplicateNumber p287 = new P0287FindTheDuplicateNumber();
         System.out.println(p287.findDuplicate(new int[]{1,3,4,2,2}));
 */
