import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P0094TreeInorderTraversal {
    public List<Integer> result;//类下的成员变量，全局变量，整个类下都可以使用
    public List<Integer> inorderTraversal(TreeNode root){
        result=new ArrayList<>();//这里的result就是全局变量，但是array list要初始化后才能使用
        Traversal(root);
        return result;
    }
    private void Traversal(TreeNode root){
        if(root==null) return;
        Traversal(root.left);
        result.add(root.val);
        Traversal(root.right);
    }

    public List<Integer> inorderTraversal1(TreeNode root) { //O(n)+o(n)
        List<Integer>list = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        //corner case
        if(root == null) return list;
        TreeNode current = root;
        stack.push(current);//将root入栈
        while(!stack.isEmpty()){
            while(current != null&&current.left != null){
                stack.push(current.left);
                current = current.left;
            }
            TreeNode popE = stack.pop();
            list.add(popE.val);
            current = popE.right;
          if(current != null){
              stack.push(current);
          }
        }
        return list;
    }

}
//中序遍历，结果存储在list里，所以需要初始化一个全局变量。这个全局变量需要返回，所以可以借助于辅助函数。
//如果跟节点为空，直接返回空的list。否则进入递归函数。我们需要按照先遍历当前节点的左节点，将当前节点值添加
//到list里，再遍历右节点的顺序。 递归结束条件是当节点为空。