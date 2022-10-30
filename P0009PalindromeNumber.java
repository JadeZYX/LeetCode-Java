public class P0009PalindromeNumber {
    public boolean isPalindrome(int x){
        if(x<0)return false;
        if(x==0)return true;
        int res=0;
        int y=x;
        while(y!=0){
            int remain=y%10;
            res=res*10+remain;
            y/=10;
        }
        return res==x;
    }
    public boolean isPalindrome1(int x) {
        if(x<0)return false;
        int y=palindrome(x);
         return x==y;
     }
     int palindrome(int x){
         int res=0;
         while(x!=0){
            //提前防止溢出，因为下一步是✖️10，所以如果当前的数比最大最小值/10还要大或小，则下一步的✖️10肯定会溢出
            if(res>Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10){
                return 0;
            }
            else{
                int remain=x%10;
                res=res*10+remain;
                x/=10;
            }
         }
         return res;
     }
//需要考虑溢出情况，所以转成string的做法不可取，会有溢出错误
     public boolean isPalindrome2(int x) {
        if(x<0)return false;
        String stringX = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for(int i = stringX.length() -1;i>=0;i--){
            sb.append(stringX.charAt(i));
        }
        return Integer.parseInt(sb.toString()) == x;
    }

     /*
     P0009PalindromeNumber p9=new P0009PalindromeNumber();
     System.out.println(p9.isPalindrome(121));
     */
}
