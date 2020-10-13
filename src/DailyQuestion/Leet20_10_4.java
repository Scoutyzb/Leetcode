package DailyQuestion;

public class Leet_10_4 {
    public ListNode addTwoNumbers_rec(ListNode l1, ListNode l2) {
        return addTwoNumbers_rec(l1,l2,0);
    }
    public ListNode addTwoNumbers_rec(ListNode l1, ListNode l2,int addOne){
        if(l1==null&&l2==null&&addOne==0)
                return null;
        int sum = (l1==null?0:l1.val)+(l2==null?0:l2.val)+addOne;
        addOne = sum/10;
        sum -= addOne*10;
        return new ListNode(sum,addTwoNumbers_rec(l1==null?null:l1.next,l2==null?null:l2.next,addOne));
    }
    


    public ListNode addTwoNumbers_iter(ListNode l1, ListNode l2){
        ListNode head = l1;
        ListNode p = l1;
        int addOne = 0;
        while(addOne!=0||l1!=null||l2!=null) {
            if (l1 == null && l2 == null) {
                p.next = new ListNode(1);
                break;
            }
            if(l1==null){
                l1 = l2;
                p.next = l1;
                l2 = null;
            }
            if(l2!=null) {
                l1.val += (l2.val + addOne);
                l2 = l2.next;
            }
            else
                l1.val += addOne;
            addOne = l1.val/10;
            l1.val -= addOne*10;
            p = l1;
            l1 = l1.next;
        }
        return head;
    }

}
