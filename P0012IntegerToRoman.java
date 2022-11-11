import java.util.HashMap;

public class P0012IntegerToRoman {
    public String intToRoman(int num){
        int[]numbers=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[]romans=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numbers.length;i++){
           while(num>=numbers[i]){
               sb.append(romans[i]);
               num-=numbers[i];
           }
        }
        return sb.toString();
    }

    public String intToRoman1(int num) {
        String res="";
        HashMap<Integer,String>map = new HashMap<>();
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");
        int[]keySet = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int key:keySet){
            while(num>=key){
                res+=(map.get(key));
                num-=key;
            }
        }
        return res;
    }
    //找第一个比num小或者是相等的值。所以从大到小
}
