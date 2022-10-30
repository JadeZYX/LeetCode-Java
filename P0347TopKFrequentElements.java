import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class P0347TopKFrequentElements {
    public int[]topKFrequent(int[]nums,int k){
        HashMap<Integer,Integer>frequence=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            frequence.put(num, frequence.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Entry<Integer, Integer>>qp=new PriorityQueue<>((a,b)->(b.getValue() - a.getValue()));
        for(Entry<Integer, Integer> value:frequence.entrySet()){
            qp.offer(value);
        }
        int[] res=new int[k];
        int j=0;
        for(int i=0;i<k;i++){
            Entry<Integer,Integer> popE=qp.poll();
            res[j]=popE.getKey();
            j++;
        }
        return res;   
    }
}
