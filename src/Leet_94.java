import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Leet_94 {
    List<Integer> list;
    public Leet_94(){
        super();
        this.list = new ArrayList<Integer>();
    }
    public List<Integer> inorderTraversal(TreeNode root) {
       if(root!=null) {
           inorderTraversal(root.left);
           list.add(root.val);
           inorderTraversal(root.right);
       }
       else
           return list;
       return list;
    }
    public  List<Integer> inorderTraversal2(TreeNode  root){
        //迭代法 To be completed
        return new ArrayList<Integer>();
    }
}
