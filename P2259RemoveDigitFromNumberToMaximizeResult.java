public class P2259RemoveDigitFromNumberToMaximizeResult {
  public String removeDigit(String number,char digit){
    if(number.length()==0)return "";
    int pos = -1;
    for(int i = 0; i<number.length();i++){//冲头到尾遍历，一定能找到位置
      if(number.charAt(i)== digit){
        pos = i;
        if(i<number.length()-2 && number.charAt(i)<number.charAt(i+1)){
          break;//如果满足此条件，不必继续循环
        }
      }
    }
    return number.substring(0, pos)+ number.substring(pos+1);
    //总的来说要不删除后一位大于当前digit的位置，要么删除最后一次出现的位置
  }

  public String removeDigit1(String number,char digit){
    int pos = -1;
    char[]chars = number.toCharArray();
    for(int i = 0;i<chars.length-1;i++){//exlude the last element
      if(chars[i]== digit){
        pos = i;
        if(chars[i]<chars[i+1]){//check right neighbour
          return number.substring(0, i)+number.substring(i+1);
        }
      }
    }
    if(pos == -1){//haven't found the digit element, then means the last element is the digit
      return number.substring(0, number.length()-1);

    }
    if(chars[chars.length-1]== digit){//循环的时候剔除了最后一项，所以这里要加判定
      pos = chars.length-1;//“73317” 应该删除最后一位，而非第一位
    }
    return number.substring(0, pos)+number.substring(pos+1);
  }
}
