import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P0448DisappearedNumInArray {
    public List<Integer>findDisappearedNumbers(int[]nums){//O(1)T + O(1)S follow up question, in-place
        List<Integer>ans = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int n = Math.abs(nums[i]);//record element as index for the next step
            nums[n-1]=Math.abs(nums[n-1])*(-1);//mark the element at that positon n-1 as negative. because array's length is n, and from 1 to n, index is from 0, so here need to n-1 to get the right position
        }
        for(int j = 0;j<nums.length;j++){//看每个索引位置上的数是否被标记过，若被标记成负数，则代表出现过
            if(nums[j]>0){
                ans.add(j+1);//1~N, index j is from 0, so plus 1.
            }
        }
        return ans;
    }


    public List<Integer> findDisappearedNumbers0(int[]nums){
        ArrayList<Integer>res=new ArrayList<>(nums.length);
        HashSet<Integer>set=new HashSet<>(nums.length);//创建hashset将应该出现的数从1到N逐个传入
        int i=1;
        while(i<=nums.length){
            set.add(i);
            i++;
        }
        for(int j=0;j<nums.length;++j){
            if(set.contains(nums[j])){
               set.remove(nums[j]);//若hashset里包含数组里的数，则删除，这样hashset里保留下来的数就是答案
            }
        }
       for(int k:set){//将hashset里的数传入要求返回的list里
           res.add(k);
       }
       return res;
    }
    public List<Integer> findDisappearedIntegers2(int[]nums){
        ArrayList<Integer> res=new ArrayList<>();
        int[]copynums=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            copynums[nums[i]]++;//copy数组里的初始值都是0，这里将原数组里的元素以下标形式传入copy数组里。
        }  //比如原数组第一个数字是3，则copy数组下标为3的位置就传入1.所以如果不存在，返回i即可
        for(int i=1;i<copynums.length;i++){
            if(copynums[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
/*
或者是将array里面的元素放入set里，然后再for循环，从1到n看是否存在，如果不存在，则添加到结果里
        P0448DisappearedNumInArray p448=new P0448DisappearedNumInArray();
        List<Integer>res=p448.findDisappearedIntegers1(new int[]{4,3,2,7,8,2,3,1});
        for(int num:res){
            System.out.print(num+" ");
        }

因为数组长度是N，且元素是从1-N，让找出这个区间范围内没有出现在数组里的元素
遍历原来的元素。如果全部出现应该是[1,2,3,4,5,6,7,8],但是现在是[4,3,2,7,8,2,3,1]
第一个位置上的元素4，我们可以把它当作下标，也就是3（因为下标是0开头），所以将原数组index=3的
位置上的值变成负数，也就是7变成-7，也就是说数字3出现了。依次类推
再一次进行for循环，当所在位置上的数是正数的时候，表示其index i 没有出现过。记住是添加索引，而不是对应位置上的值。
从而实现了follow-up 的要求
*/
