package DailyQuestion;

/**
 * @author:Scout
 * @data:2020/9/24
 * @description:
 * @URL:
 */
public class test {
    public static void main(String[] args) {
        Leet20_9_25 solution = new Leet20_9_25();
        int[] inorder = {2,1};
        int[] postorder = {2,1};
        solution.buildTree(inorder,postorder);
    }
}
