import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P0145BinaryTreePostorderTraversal {
    ArrayList<Integer>list;
    public List<Integer>postorderTraversal(TreeNode root){
        list=new ArrayList<>();
        if(root==null){
            return list;
        }
        helper(root);
        return list;
    }
    void helper(TreeNode node){
        if(node ==null)return;
        helper(node.left);
        helper(node.right);
        list.add(node.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        //left-right-rootf
      LinkedList<Integer> res = new LinkedList<>(); // Linked List

	if (root == null)
		return res;

	Stack<TreeNode> stack = new Stack<>();
	stack.push(root);

	while (!stack.isEmpty()) {
		TreeNode curr = stack.pop();
		res.addFirst(curr.val); // Add First  把值添加到list的第一个位置

		if (curr.left != null)
			stack.push(curr.left);

		if (curr.right != null)
			stack.push(curr.right);
	}

	return res;
    }
}
/*
 * postorder是 left- right- root的顺序。我们可以用linked list的addfirst功能将值始终添加到最前面
 * 所以需要按照中右左的顺序来。在stack里，如果先要得到右，则需要先添加左。所以这里是先添加左，再添加右。
 */