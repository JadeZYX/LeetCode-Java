import java.util.LinkedList;
import java.util.Queue;

public class P1161maxLevelSumOfABT {
    public int maxLevelSum(TreeNode root){
        int minlevel=Integer.MAX_VALUE;
        int sum=Integer.MIN_VALUE;
        int level=0;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            level++;
           int size=queue.size();
           int levSum=0;
           while(size!=0){
               TreeNode node=queue.poll();
                levSum+=node.val;
                size--;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
           }
           if(levSum>sum){
               sum=levSum;
               minlevel=level;
           }
        }
        return minlevel;
    }
}
// BinaryTree t = new BinaryTree(new Integer[] {1,7,0,7,-8,null,null});
        // P1161maxLevelSumOfABT s = new P1161maxLevelSumOfABT();
        // s.maxLevelSum(t.root);
