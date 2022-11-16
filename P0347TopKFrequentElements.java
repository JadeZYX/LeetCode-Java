import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    //naive solution
    /*
     1)count the frequency of each word using a hash map
     2)flatten the hash map to an list of word counts
     3)sort the list by descending frequency (b-a)
     4)output the first K words
     */
    public int[]topKFrequent1(int[]nums,int k){
        //K是几，结果array的长度就是几
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer>list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->(map.get(b)-map.get(a)));
        int index = 0;
        int[]res = new int[k];
        for(Integer key:list){
            if(index<k){
                res[index]=key;
                index++;
            }
            else{
                break;
            }
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        int[]res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        //定义优先队列的标准，初始化
        PriorityQueue<Map.Entry<Integer,Integer>>queue = new PriorityQueue<>((a,b)->(b.getValue()-  a.getValue()));
        //往优先队列里添加map的key- value pairs，自动按照定义的顺序标准来
        for(Map.Entry<Integer,Integer>pair:map.entrySet()){
             queue.offer(pair);
        }
        for(int i = 0;i<k;i++){
            Map.Entry<Integer,Integer>popE = queue.poll();
            res[i]=popE.getKey();
        }
        return res;
    }
}
/*
  P0347TopKFrequentElements p347 = new P0347TopKFrequentElements();
  System.out.println(p347.topKFrequent2(new int[]{1,1,1,2,2,3}, 2));
  map里需要的： Map.Entry<>, map.keySet(),map.values(),map.entrySet()
  优先队列与普通队列的相同之处是先进先出，都有offer(add),poll(remove),peek()
  不同之处是可以定义怎么来排序，使用(a,b)->(b.getValue()-a.getValue())按照从大到小的顺序排
 */