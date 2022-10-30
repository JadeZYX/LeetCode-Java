public class P0238ProductOfArrayExceptSelf {
    public int[]productExceptSelf(int[]nums){
        int[]ans=new int[nums.length];
        int tempLeft=1;
        for(int i=0;i<nums.length;i++){
            ans[i]=tempLeft;
            tempLeft*=nums[i];
        }
        int tempRight=1;
        for(int j=nums.length-1;j>=0;j--){
            ans[j]=ans[j]*tempRight;
            tempRight*=nums[j];
        }
        return ans;
    }
}
//第一轮循环先求出第i位的左边的乘积，从前往后扫，第二轮循环求出第i位右边的乘积，从后往前扫。