public class P0075SortColors {
    public void sortColors(int[]nums){//单向指针 记录
        if(nums.length == 0) return;
        int currentPosition0 = 0;
        //sort 0
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                swap(nums,currentPosition0,i);
                currentPosition0++;
            }
        }
        //sort 1
        int currentPosition1=currentPosition0;
        for(int j = currentPosition1;j<nums.length;j++){
            if(nums[j]==1){
                swap(nums,currentPosition1,j);
                currentPosition1++;
            }
        }
        return;
    }
    public void swap(int[]nums,int position1,int position2){
        int temp = nums[position1];
        nums[position1]=nums[position2];
        nums[position2]=temp;
    }


    public void sortColors1(int[]nums){//双向指针，以0和2为主要操作对象
        int ptr1=0, ptr2=nums.length-1;
        int index=0;
        while(index<=ptr2){//循环条件不能是ptr1<ptr2
            if(nums[index]==0){
                nums[index]=nums[ptr1];
                nums[ptr1]=0;
                ptr1++;
            }
            if(nums[index]==2){
                nums[index]=nums[ptr2];
                nums[ptr2]=2;
                ptr2--;
                index--;//！！上面index所代表的数与末尾指针交换后需要重新check
            }
            index++;//如果为1，也要++；
        }
    }
    public void sortColors2(int[] nums) {//bubble sort
        for(int i=nums.length-1;i>0;i--){
             for(int j=0;j<i;j++){
                 if(nums[j]>nums[j+1]){
                     int temp=nums[j];
                     nums[j]=nums[j+1];
                     nums[j+1]=temp;
                 }
             }
        }
     }
}
/*
P0075SortColors p75 = new P0075SortColors();
int[]arr = new int[]{2,0,2,1,1,0};
p75.sortColors1(arr);
for(int i:arr){
System.out.print(i);
}
 *
 */
//题目需要对0，1，2进行有序排序，因为0代表红色，1代表白，2代表蓝色。所以可以先把所有的0先提取出放到最前面，然后提取1. 限定条件是array里面的元素只有三种，我们可以用这种调整位置+记录当前已经有序调整到哪个位置的方式
 //get 0 at i, then put 0 at position index, and index++, so that next time when get 0 again, it should be inserted to that position
        //and then do the same time to push number 1 forward after number 0, start from index