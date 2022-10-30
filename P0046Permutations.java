
import java.util.ArrayList;
import java.util.List;

public class P0046Permutations { //O(n!)
  public List<List<Integer>> permute(int[]nums){
    List<List<Integer>> lists = new ArrayList<>();
    if(nums.length == 0 || nums == null) return lists;
    backtrack(nums,lists,new ArrayList<>());
    return lists;
  }

  void backtrack(int[]nums,List<List<Integer>>lists,List<Integer>tempList){
    if(tempList.size() == nums.length){
      lists.add(new ArrayList<Integer>(tempList));
      //lists.add(tempList);这里只添加了地址所以是错的
      return;
    }
    else{
      for(int i = 0; i<nums.length;i++){
        if(tempList.contains(nums[i])) continue;
        tempList.add(nums[i]);
        backtrack(nums, lists, tempList);
        tempList.remove(tempList.size()-1);
      }
    }
  }
}

