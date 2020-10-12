package DailyQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Scout
 * @data:2020/9/24
 * @description:
 * @URL:https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class Leet20_9_24 {
    private int base; //之前连续中的数值
    private int val;  //连续的数值已经遍历了几次
    private List<Integer> maxbase; //最大连续的数值
    private int maxval; //最大的连续数值遍历了几次
    public int[] findMode(TreeNode root) {
        maxbase = new ArrayList<Integer>();
        travel(root);
        if(val!=0&&val>=maxval){
            if(val>maxval)
                maxbase.clear();
            maxbase.add(base);
            maxval = val;
        }
        return maxbase.stream().mapToInt(Integer::intValue).toArray();
    }
    public void travel(TreeNode root){
        if(root==null)
            return;
        travel(root.left);
        if(root.val==base){
            val++;
        }
        else {
            if(val!=0&&val>=maxval){
                if(val>maxval)
                    maxbase.clear();
                maxbase.add(base);
                maxval = val;
            }
            base=root.val;
            val=1;
        }
        travel(root.right);
    }
}
