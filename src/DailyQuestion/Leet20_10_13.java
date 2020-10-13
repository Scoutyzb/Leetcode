package DailyQuestion;

public class Leet20_10_13 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode r = q.next;
        q.next = p;
        p.next=swapPairs(r);
        return q;
    }
}
