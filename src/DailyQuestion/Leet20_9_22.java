package DailyQuestion;


/** In the day of my birthday, I set up this folder to record my Leetcode daily questions, on the purpose to inspire me solve one question per day.
 *  Besides, this is the best chance for to to strength myself, just face the challenge.
 *                                                                  2020-9-22
 *                                                                  Scout
 */

/** 给定一个二叉树，我们在树的节点上安装摄像头。
 *  节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *  计算监控树的所有节点所需的最小摄像头数量。
 *  URL:https://leetcode-cn.com/problems/binary-tree-cameras/
 *
 */
public class Leet20_9_22 {

    public int minCameraCover(TreeNode root) {
    //
        /*
        问题思考：感觉像回溯的思路，不停试错，但有无相关递归思路
         */
        /* 题解：
            根据上面的讨论，能够分析出，对于每个节点root，需要维护三种类型的状态：

                状态 a：root必须放置摄像头的情况下，覆盖整棵树需要的摄像头数目。
                状态 b：覆盖整棵树需要的摄像头数目，无论 root是否放置摄像头。
                状态 c：覆盖两棵子树需要的摄像头数目，无论节点root本身是否被监控到。
                故，对某节点，(la,lb,lc)，（ra,rb,rc）,分别是其左节点右节点的各种数值，
                那么，其本身的数值就等于
                a = lc + rc + 1 因为其right和left已经被覆盖，所以只需要计算覆盖其子树的数目+1就可了。
                b = min(a,min(la​+rb​,ra​+lb​))，a是放置，后面是不放，不放就要求其子节点覆盖其本身。
                当l或r有一方不存在时，无法通过子节点来覆盖本身，故该节点la或ra设为无穷大。
                下一步计算叶子节点的abc 当节点不存在时，节点c为0，a为无穷大，b为0
         */
        return Travel(root)[1];
    }
    public int[] Travel(TreeNode root){
        int[] result = new int[3];
        if(root==null){
            result[0] = Integer.MAX_VALUE/2;
            result[1] = 0;
            result[2] = 0;
            return result;
        }
        int[] lresult = Travel(root.left);
        int[] rresult = Travel(root.right);
        result[0] = lresult[2] + rresult[2] +1;
        result[1] = Math.min(result[0],Math.min(lresult[0]+rresult[1],lresult[1]+rresult[0]));//如果把result[0]
        result[2] = Math.min(lresult[1]+rresult[1],result[0]);
        return result;
    }
}
