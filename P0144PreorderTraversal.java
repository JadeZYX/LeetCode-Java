import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P0144PreorderTraversal {
    ArrayList<Integer>list;
    public List<Integer>preorderTraversal(TreeNode root){
        list=new ArrayList<>();
        if(root==null){
            return list;
        }
        helper(root);
        return list;
    }
    void helper(TreeNode root){
       if(root==null)return;
        list.add(root.val);
        helper(root.left);
        helper(root.right);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        //root-left-right
        List<Integer>list1 = new ArrayList<>();
        DFS(root,list1);
        return list;
    }
    public void DFS(TreeNode node, List<Integer>listarr){
        if(node == null) return;
        list.add(node.val);
        DFS(node.left,listarr);
        DFS(node.right,listarr);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        if(root == null) return list;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode popE = stack.pop();
            list.add(popE.val);
            if(popE.right != null ){
                stack.push(popE.right);
            }
            if(popE.left != null ){
                stack.push(popE.left);
            }
        }
        return list;
     }
}
