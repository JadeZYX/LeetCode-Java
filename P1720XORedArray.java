public class P1720XORedArray {
    public int[]decode(int[]encoded,int first){
       int[]arr=new int[encoded.length+1];
       arr[0]=first;
       for(int i=0;i<encoded.length;i++){
           //arr[i]^arr[i+1]^arr[i]=encoded[i]^arr[i];
           arr[i+1]=encoded[i]^arr[i];
       }
       return arr;
    }
}//a^a=0  a^0=a;
