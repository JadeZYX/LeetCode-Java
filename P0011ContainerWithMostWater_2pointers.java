public class P0011ContainerWithMostWater_2pointers {
    public int maxArea(int[]height){
        if(height.length==0)return 0;
        int left=0,right=height.length-1;
        int maxarea=Integer.MIN_VALUE;
        while(left<right){
            int width=Math.abs(left-right);
            int dep=Math.min(height[left], height[right]);
            int area=width*dep;
            if(area>maxarea){
                maxarea=area;
            }
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxarea;
    }
}
