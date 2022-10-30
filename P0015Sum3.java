import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class P0015Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(nums.length<3){
            return ans;
        }
        Arrays.sort(nums);//O(n*logN)
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(i>0&&nums[i]==nums[i-1])continue;//题目中要求的去重,比如已经查找过的不需要再查找
            int target=0-nums[i];
            int j=i+1,k=len-1;//双向指针
            while(j!=k){//双向指针循环条件，内部的while循环都是在去重复
                //List<Integer>list=new ArrayList<>();
                if(nums[j]+nums[k]==target){
                ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    // list.add(nums[i]);
                    // list.add(nums[j]);
                    // list.add(nums[k]);
                    // ans.add(list);//因为array是复杂类型，所以这里是引用，不能这样写
                    j++;
                    k--;
                    while(j!=k&&nums[j]==nums[j-1]) j++;
                    while(j!=k&&nums[k]==nums[k+1]) k--;
                }
                else if(nums[j]+nums[k]>target){
                    k--;
                    while(j!=k&&nums[k]==nums[k+1]) k--;
                }
                else{
                    j++;
                    while(j!=k&&nums[j]==nums[j-1]) j++;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>>threeSum1(int[]nums){
        List<List<Integer>>list=new ArrayList<>();
        Arrays.sort(nums);
        for(int a=0;a<nums.length-2;a++){
            if (a > 0 && nums[a] == nums[a-1]) continue;
            for(int b=a+1;b<nums.length-1;b++){
                if (b > a+1 && nums[b] == nums[b-1]) continue;
                int c=(nums[a]+nums[b])*-1;
                if (binarysearch(nums,b+1,nums.length,c)){
                   list.add(Arrays.asList(nums[a], nums[b], c));
                }
            }
        }
        return list;
    }
    public boolean binarysearch(int[]nums,int left,int right,int target){
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]>target){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return false;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        //内部排序+双向指针
        if(nums.length<3)return null;
       List<List<Integer>>list = new ArrayList<>();
       Arrays.sort(nums);//n*logn
        for(int i = 0; i<=nums.length-3;i++){
            //[-4,-1,-1,0,1,2] 第一遍循环查过了-1，所以第二个-1跳过，避免重复
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]==(0-nums[i])){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    //添加当前符合要求的结果后还要继续查找，否则会无限循环
                    while(left<right && nums[left]==nums[left-1]){
                        left++;//避免重复 [-1,-1,-1,2,2]
                    }
                }
                else if(nums[left]+nums[right]<(0-nums[i])){
                    left++;
                    while(left<right &&nums[left]==nums[left-1]){
                        left++;
                    }
                }
                else{
                    right--;
                }
            }
        }
        return list;
    }
}
/*
P0015Sum3 p15=new P0015Sum3();
List<List<Integer>>res=new ArrayList<>();
res=p15.threeSum(new int[]{-1,0,1,2,-1,-4});
for(List<Integer> list:res){
    for(int num:list){
        System.out.print(num);
    }
}
*/