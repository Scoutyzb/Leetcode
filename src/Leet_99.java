public class Leet_99 {
    private TreeNode pre=null;
    private TreeNode first=null;
    private TreeNode second=null;
    public void recoverTree(TreeNode root) {
        traverseTree(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }
    public void traverseTree(TreeNode root){
        if(root==null)
            return;
        traverseTree(root.left);
        visit(root);
        traverseTree(root.right);
        return;
    }
    public void visit(TreeNode root){
        if(this.pre!=null&&this.pre.val>root.val){
               if(first == null)
                   first = pre;
               second = root;
        }
        this.pre = root;
        return;
    }
}
