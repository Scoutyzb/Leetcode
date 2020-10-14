package DailyQuestion;

import java.util.Stack;

/**
 * @author:Scout
 * @data:2020/10/12
 * @description:给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * @URL:https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class Leet20_10_12 {
    //递归
    private int pre;
    private int minNum;
    public int getMinimumDifference(TreeNode root) {
        pre = Integer.MIN_VALUE/2;
        minNum = Integer.MAX_VALUE;
        inorderTravel(root);
        return minNum;
    }
    public void inorderTravel(TreeNode root){
        if(root == null)
            return;
        inorderTravel(root.left);
        if(root.val-pre<minNum)
            minNum=root.val-pre;
        pre = root.val;
        inorderTravel(root.right);
        return;
    }
    //非递归
    public int getMinimumDifference2(TreeNode root) {
        pre = Integer.MIN_VALUE/2;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()){

        }
        return 0;
    }
}
