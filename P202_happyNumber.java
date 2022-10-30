import java.util.HashSet;

public class P202_happyNumber {
    public boolean isHappy(int n){
        HashSet<Integer>set = new HashSet<>();
        while(n != 1){
            int m = getSum(n);
            if(set.contains(m)){
                return false;
            }
            set.add(m);
            n = m;
        }
        return true;
    }
    public int getSum(int n){
        int sum = 0;
        while(n != 0){
            int remainer = n%10;
            sum += remainer*remainer;
            n /= 10;
        }
        return sum;
    }


    public boolean isHappy0(int n){
        HashSet<Integer> sites=new HashSet<Integer>();//区别于hashmap
        while(n>0){
            if(n==1){
                return true;
            }
            int sum=0;
            while(n!=0){ //不断的取余数的过程，当n/10==0终止
                int i=n%10;
                n/=10;
                sum=sum+i*i;//求和
            }
            n=sum;//把求出的数赋值给n，判定是否存在，是否需要继续循环
            if(sites.contains(n)){
                return false;
            }
            else{
                sites.add(n);
            }
        }
        return false;//默认
    }

    public boolean isHappy2(int n){//O(logn)+O(1)
       //快慢指针同时在n起点
       int slow = n;
       int fast = n;
       slow = getSum(n);//慢指针向前到下一个数的和
       fast = getSum(getSum(n));//快指针到下一个数的对应数的和的下一个数
       while(fast != slow){//如果二者相遇，说明进入了死循环
           if(fast == 1){//如果快指针先得到1的结果，则是happy number
               return true;
           }
           slow = getSum(slow);
           fast = getSum(getSum(fast));
       }
       return fast == 1;//结束调节，因为如果是n是1或者10，则fast直接是1.所以这里不能简单粗暴的写false
    }
}
/*
        P202_happyNumber p202=new P202_happyNumber();
        System.out.println(p202.isHappy(19));
        System.out.println(p202.isHappy(2));
*/