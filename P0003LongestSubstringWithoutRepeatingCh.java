import java.util.HashMap;

public class P0003LongestSubstringWithoutRepeatingCh {

    public int lengthOfLongestSubstring(String s){//O（N）
        //使用sliding window + hashmap或者是array ASC code
        //corner case
        if(s.length()==0 || s ==null) return 0;
        int maxLen = 0;
        int start = 0;
        int end = 0;
        //int[]letters = new int[256];
        HashMap<Character,Integer>window = new HashMap<>();
        while(end<s.length()){
            //expand window
            char a = s.charAt(end);
            end++;
            //letters[a]++;
            window.put(a, window.getOrDefault(a,0)+1);
            //shrink window
            while(window.get(a)>1){ //while(letters[a]>1)
                char b = s.charAt(start);
                start++;
                //letters[b]--;
                window.put(b,window.get(b)-1);
            }
            //after shrink window, no duplicate element, so update max length
            maxLen = Math.max(maxLen, end-start);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring1(String s){
        int slow=0,fast=0, maxLen=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(fast<s.length()){
            if(map.containsKey(s.charAt(fast))){
                if(slow<=map.get(s.charAt(fast))){
                    slow=1+map.get(s.charAt(fast));
                }
                else{//slow>map.get(s.charAt(fast))
                    maxLen=Math.max(maxLen, fast-slow+1);
                }
            }
            else {
               maxLen=Math.max(maxLen, fast-slow+1);
            }
            map.put(s.charAt(fast), fast);
            fast++;
        }
        return maxLen;
    }
    public int lengthOfLongestSubstring2(String s){ //time O(n*n)+O(1)space
        if(s.length()==0 || s == null) return 0;
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0; i<s.length();i++){
            int count = 0;
            //HashMap<Character,Integer>map = new HashMap<>();
            int[]letterFreq = new int[128];//s consists of English letters, digits, symbols and spaces. 所以不能是26
            for(int j = i;j<s.length();j++){
                char c = s.charAt(j);
                if(letterFreq[c]>0){
                    break;//go to the next loop
                }
                /*
                * if(map.containsKey(c)){
                    maxSub = Math.max(maxSub,count);
                    break;
                }
                map.put(c,1);
                count++;
                */
                letterFreq[c]++;
                count++;
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
}
       //P0003LongestSubstringWithoutRepeatingCh p3=new P0003LongestSubstringWithoutRepeatingCh();
       //System.out.println(p3.lengthOfLongestSubstring("tmmzuxt"));
//使用快慢指针。保证快慢指针之间的元素是不重复的。所以当遇到重复的元素，慢指针要移动hashmap里get到的此元素所在位置的下一个。
//若快慢指针所在的元素不重复，则更新最大值。  快指针每次都要前进且更新记录hashmap里的信息。
