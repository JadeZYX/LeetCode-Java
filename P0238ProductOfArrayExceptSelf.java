public class P0238ProductOfArrayExceptSelf {
    public int[]productExceptSelf(int[]nums){//O(n)+O(1)
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

    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[]leftPart = new int[len];// 求左部分的乘机
        int[]rightPart = new int[len];//求右部分的乘机
        leftPart[0]=1;
        rightPart[len-1]=1;
        for(int i = 1;i<len;i++){
            leftPart[i]=nums[i-1]*leftPart[i-1];//当前位的左部分的乘机= 它的前一位数字*前一位数的左侧的product
        }
        for(int j = len-2;j>=0;j--){
            //当前位的右部分的乘机= 它的右侧第一位数字*右侧第一位数字之前的右侧的product
            rightPart[j]=nums[j+1]*rightPart[j+1];
        }
        int[]ans = new int[len];//合并总结果 左*右
        for(int k = 0;k<len;k++){
            ans[k]=leftPart[k]*rightPart[k];
        }
        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {//O(n)+O(n)
        //get the left, get the right , and then get the whole product
        int productL = 1;
        int[]productleft = new int[nums.length];
        productleft[0]=1;
        for(int i = 1;i<nums.length;i++){
            productleft[i]=nums[i-1]*productL;//求当前位的左部分的乘机是用当前位的前一位*（当前位的前一位的product）
            productL = productleft[i];//更新当前位的product，不包含当前位，其实就是当前位前面的所有数的product
        }
        int productR = 1;
        int[]productright = new int[nums.length];
        productright[nums.length-1]=1;
        for(int j = nums.length-2;j>=0;j--){
            productright[j]=nums[j+1]*productR;
            productR=productright[j];
        }
        int[]product = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            product[i]=productleft[i]*productright[i];
        }
        return product;
    }

    public int[] productExceptSelf3(int[] nums) {//O(n)+O(1)
        int[]ans = new int[nums.length];
        ans[0]=1;
        //get the left product for each element
        for(int i = 1;i<nums.length;i++){
            ans[i]=nums[i-1]*ans[i-1];
        }
        int productR = 1;
        for(int j = nums.length-1;j>=0;j--){
            ans[j] = ans[j]*productR;
            productR*=nums[j];
        }
        return ans;
    }
}
//第一轮循环先求出第i位的左边的乘积，从前往后扫，第二轮循环求出第i位右边的乘积，从后往前扫。
/*
P0238ProductOfArrayExceptSelf p238 = new P0238ProductOfArrayExceptSelf();
System.out.println(p238.productExceptSelf1(new int[]{1,2,3,4}));
 [1,2,3,4],这道题的要求是求出每一位上不包含自己的，其他元素的product。
比如1，应该是2*3*4,也就是1的右半部分, 2: 1*3*4也就是2的左部分+2的右部分,  3:1*2*4也就是3的左部分+3的右部分   4:1*2*3也就是4的左部分
直观做法是开出额外空间，可以求出每个数的左半部分的乘机，再求出每个数右半部分的乘机，然后相成得总乘机
由于数组的开头结尾比较特殊，一个没有左部分，一个没有右部分，我们可以设置开头结尾是1.这样不会影响结果
所以在求3的左部分就是用3的前一位*（3的前一位之前的product),
求3的右部分就是用3的右侧的第一个数*（3的右侧第一个数之前的product）
 */
