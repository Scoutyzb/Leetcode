import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class util {
    public  static  TreeNode vectorToTree(Integer[] treeNum){
        return vectorToTree(treeNum,0);
    }
    public static TreeNode vectorToTree(Integer[] treeNum,int index){
        TreeNode temp = null;
        if(index<treeNum.length){
            Integer value = treeNum[index];
            if(value!=null)
                temp = new TreeNode(value, vectorToTree(treeNum, 2 * index + 1), vectorToTree(treeNum, 2 * index + 2));

        }
        return temp;
    }
    public static TreeNode layervectorToTree(Integer[] treeNum){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(treeNum[0]!=null){
            TreeNode root = new TreeNode(treeNum[0]);
            queue.offer(root);
            int i = 1;
            while (i<treeNum.length){
                TreeNode node = queue.poll();
                node.left = treeNum[i]!=null?new TreeNode(treeNum[i]):null;
                i++;
                if(i<treeNum.length) {
                    node.right = treeNum[i] != null ? new TreeNode(treeNum[i]) : null;
                    i++;
                }
                else
                    node.right = null;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            return root;
        }
        return null;
    }
}
