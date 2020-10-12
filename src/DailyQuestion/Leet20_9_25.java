package DailyQuestion;

/**
 * @author:Scout
 * @data:2020/9/25
 * @description: 根据一棵树的中序遍历与后序遍历构造二叉树。老数据结构题目了。
 * @URL:https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Leet20_9_25 {
    private int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length;
        TreeNode root = buildTree(inorder,postorder,0,postorder.length-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder,int start,int end){
        if(index<0||start>end)
            return null;
        TreeNode root = new TreeNode(postorder[--index]);
        int i;
        for(i = start; i<=end;i++ ){
            if (inorder[i] == postorder[index])
                break;
        }
        root.right = buildTree(inorder,postorder,i+1,end);
        root.left = buildTree(inorder,postorder,start,i-1);
        return root;
    }

}
