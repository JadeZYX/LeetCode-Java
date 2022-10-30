
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P0071SimplifyPath {
  public String simplifyPath(String path){
    //corner case
    if(path == null || path.length() == 0)return "";
    //trim empty space before and after 去掉两头的空格
    String[] copyPath = path.trim().split("/");//去掉所有的slash，现在array里仅有.,..,letters,empty string.
    //这里要存储string类型，因为用slash做为delimiter
    Stack<String>stackPath = new Stack<>();//把结果先存到stack里再转成string
    for(String a: copyPath){ //类似于 for (int i = 0;i<copyPath.length;i++)
      if(a.equals(".")|| a.length()==0){ //多个slash之间会有空字符串的情况.
        continue;
      }
      else if(a.equals("..")){ //==是引用地址比较，equals是值内容比较
        if(!stackPath.isEmpty()){
          stackPath.pop();//去掉最top的路径，返回到上一层
        }
        //continue;
      }
      else{
        stackPath.push(a);//直接push字母到stack里
      }
    }
    // String res = "";
    // while(!stackPath.isEmpty()){
    //   String popE = stackPath.pop();//取栈顶那项，从后往前
    //   res = "/"+popE+res;
    // }
    // return res.length()==0?"/":res;//特殊例子"/../""
    List<String>list = new ArrayList<>(stackPath);
    return "/"+String.join("/",list);
  }
}
/*
        P0071SimplifyPath p71 = new P0071SimplifyPath();
        String test = "/a/./b/../../c/";
        System.out.println(p71.simplifyPath(test));

 * Examples:

"/a/./" --> means stay at the current directory 'a'
"/a/b/.." --> means jump to the parent directory from 'b' to 'a'
"////" --> consecutive multiple '/' are a valid path, they are equivalent to single "/".
any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'

Input : /home/
Output : /home

Input : /a/./b/../../c/
Output : /c

Input : /a/..
Output : /

Input : /a/../
Ouput : /

Input : /../../../../../a
Ouput : /a

Input : /a/./b/./c/./d/
Ouput : /a/b/c/d

Input : /a/../.././../../.
Ouput : /

Input : /a//b//c//////d    split 操作的时候 多个slash之间会有empty string
Ouput : /a/b/c/d
 */