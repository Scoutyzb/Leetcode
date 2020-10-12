package DailyQuestion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:Scout
 * @data:2020/9/23
 * @description:给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *  你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * @URL:https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @diary:Today I ate hotpot in tanyaxue，which leads to my gastric acid upwelling into my throat, I never eat sichuan hotpot again.
 */
public class Leet20_9_23 {
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        return travel(t1,t2);
    }
    public TreeNode travel(TreeNode t1, TreeNode t2){
        if(t1==null){
            t2.left = travel(null,t2.left);
            t2.right = travel(null,t2.right);
            return t2;
        }
        else{
            t1.left = travel(t1.left,t2==null?null:t2.left);
            t1.right = travel(t1.right,t2==null?null:t2.right);
            t1.val += t2==null?0:t2.val;
            return t1;
        }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {//四种状态
        if(t1==null&&t2!=null) //t1 False && t2 True
            return t2;
        if(t2==null) // t2 False && t1 False | t2 False && t1 True
            return t1; //由于以后已经不需要合并，T1以下就是T1
        // t1 True && t2 True
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
