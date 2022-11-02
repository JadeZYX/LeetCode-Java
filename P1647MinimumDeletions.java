import java.util.HashMap;
import java.util.HashSet;

public class P1647MinimumDeletions {
  public int minDeletions(String s){
    int count = 0;
    //get the frequencies for each letter using array with length 26
    int[]arr = new int[26];
    //iterate string
    for(int i = 0;i<s.length();i++){
      arr[s.charAt(i)-'a']++;
    }
    //using hashset to filter out the same number
    HashSet<Integer>set = new HashSet<>();
    for(int j = 0;j<26;j++){
      if(arr[j]==0)continue;
      else{
        while(set.contains(arr[j])){
          count++;
          arr[j]--;
        }
        //we don't need to add 0 to hashset,since 0 means no such letter in string any more
        if(arr[j]!=0){
          set.add(arr[j]);
        }
      }
    }
    return count;
  }

  public int minDeletions1(String s){
    int count = 0;
    HashMap<Character,Integer>map = new HashMap<>();
    for(int i = 0; i<s.length();i++){
      char letter = s.charAt(i);
      map.put(letter,map.getOrDefault(letter,0)+1);
    }
    HashSet<Integer>set = new HashSet<>();
    for(char c:map.keySet()){
      int freq = map.get(c);
      while(set.contains(freq)&& freq !=0){
        count++;
        freq--;
      }
      if(freq>0){
        set.add(freq);
      }
    }
    return count;
  }
}
