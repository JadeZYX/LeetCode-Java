import java.util.ArrayList;
import java.util.List;

public class P0797AllPathsFromSourceToTarget {
  public List<List<Integer>>allPathsSourceTarget(int[][]graph){
    //initialize list to store result
    List<List<Integer>>result = new ArrayList<>();
    //edge case
    if(graph.length == 0) return result;
    //initialize list path, this is for each path from start to destination
    List<Integer>path = new ArrayList<>();
    //push start point into path list
    path.add(0);
    //backtracking, dfs,parameters should be graph,current node,result,path
    backtracking(graph,0,path,result);
    //return result collection
    return result;
  }
  public void backtracking(int[][]graph,int n, List<Integer>path,List<List<Integer>>res){
    //base case, condition to stop dfs
    if(n == graph.length -1){
      //down to the end point, so add this avaliable path into result collection
      res.add(new ArrayList<>(path));//should using new keyword, because list this is address reference
      return;//using gloable varaiable store result, no specific return is needed
    }
    for(int element: graph[n]){ //iterate neighbours of this current point
      //add neighbours to the path
      path.add(element);
      backtracking(graph, element, path, res);//check neighbours's neighbours
      path.remove(path.size()-1);//remove current point to spread to other path from  固定的 stable start point to the end point
    }
    return;
  }
}
