import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Map.Entry<Integer, ListNode>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode tail = head;
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(new AbstractMap.SimpleEntry<>(list.val, list));
            }

            while(!queue.isEmpty()){
                Map.Entry<Integer, ListNode> entry = queue.remove();
                ListNode p = entry.getValue();
                tail.next = p;
                tail = p;
                p = p.next;
                tail.next = null;
                if(p != null){
                    queue.add(new AbstractMap.SimpleEntry<>(p.val, p));
                }
            }
        }
        return head.next;
    }
}
