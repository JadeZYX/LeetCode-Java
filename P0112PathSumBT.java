public class P0112PathSumBT {
    boolean isValid = false;//只要有一条path符合条件就形，所以这里布尔值初始值是false
    int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum=targetSum;
        sumOfTree(root, 0);
        return isValid;//返回全局变量
    }
    private void sumOfTree(TreeNode root, int sum) {
       if(root==null) return;//如果没有节点，直接返回
       sum+=root.val;//如果存在节点，则要更新sum
       if(root.left==null&&root.right==null){//当前的节点值已经在上一行添加了，还需要判定是否是叶子节点
           if(sum==targetSum){
               isValid=true;
           }
           return;//不管所得的结果是不是目标值，都要返回，因为已经到了叶子节点
       }
       sumOfTree(root.left, sum);//讲当前节点的sum传入，通过参数把自己的信息告诉子节点
       sumOfTree(root.right, sum);
    }
}
/*
 * 这道题是要从root到Leaf找到targetsum，所以是自上而下的，top to bottom. 通过参数把自己的信息告诉子节点，但是不需要给上层传递信息，所以一般会有一个全局变量。如果全局变量需要返回，则辅助函数是void类型。
 * 这里的sum是简单类型，并非复杂类型的地址引用，不需要设置成全局变量。
 */