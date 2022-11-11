import java.util.HashMap;

public class P0013RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
       int num=0;
        for(int i=0;i<s.length();i++){
            if(i+1<s.length()&&s.charAt(i+1)>s.charAt(i)){
                num-=map.get(s.charAt(i));
            }
            else{
                num+=map.get(s.charAt(i));
            }
        }
        return num;
    }
    public int romanToInt1(String s) {
        HashMap<Character,Integer>map=new HashMap<>();//O(1)的space
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int num=0;
         for(int i=0;i<s.length();i++){
             if(i+1<s.length()&&map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                 num+=(map.get(s.charAt(i+1))-map.get(s.charAt(i)));
                 i+=1;
             }
             else{
                 num+=map.get(s.charAt(i));
             }
         }
        return num;
    }

    public int romanToInt2(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
         map.put('I',1);
         map.put('V',5);
         map.put('X',10);
         map.put('L',50);
         map.put('C',100);
         map.put('D',500);
         map.put('M',1000);
         int ans = 0;
         for(int i = 0;i<s.length();i++){
             if(i<s.length()-1){
                //以下的if,else if,else if,else不能用if,if,if,else代替。这样会导致最后一对if,else 必须进入一个
                 if(s.charAt(i)=='I'&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')){
                     ans+=(map.get(s.charAt(i+1))-map.get(s.charAt(i)));
                      i++;
                 }
                 else if(s.charAt(i)=='X'&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')){
                     ans+=(map.get(s.charAt(i+1))-map.get(s.charAt(i)));
                      i++;
                 }
                 else if(s.charAt(i)=='C'&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')){
                     ans+=(map.get(s.charAt(i+1))-map.get(s.charAt(i)));
                       i++;
                 }
                 else{
                     ans+=(map.get(s.charAt(i)));
                 }
             }
             else if (i==s.length()-1){
                 ans+=(map.get(s.charAt(i)));
             }
         }
         return ans;
     }
}
//P0013RomanToInt p13=new P0013RomanToInt();
//System.out.println(p13.romanToInt("MCMXCIV"));