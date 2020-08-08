public class Leet_99 {
    class Solution {
        private int pre;
        private TreeNode treePre;
        private TreeNode firstChange;
        private TreeNode secondChange;
        private byte changeNum;
        public Solution(){
            this.pre = Integer.MIN_VALUE;
            this.treePre = null;
            this.changeNum = 0;
        }
        public void recoverTree(TreeNode root) {
            if(changeNum==3)
                return;
            if(changeNum==2)
            {
                int temp = firstChange.val;
                firstChange.val = secondChange.val;
                secondChange.val = temp;
                changeNum++;
            }
            if(root==null)
                return;
            if(root.left==null&&root.right==null)
                return;
            recoverTree(root.left);
            visit(root);
            recoverTree(root.right);
        }
        public void visit(TreeNode root){

            if(this.pre<root.val){
                if(this.changeNum==0)
                    firstChange = treePre;
                if(this.changeNum==1)
                    secondChange = root;
            }
            this.pre = root.val;
            this.treePre = root;
        }
    }
}
