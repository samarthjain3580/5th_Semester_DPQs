package Heap;
import java.util.*;

public class merge_K_lists {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) pq.add(node.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // number of lists
        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt(); // size of current list
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            for (int j = 0; j < n; j++) {
                tail.next = new ListNode(sc.nextInt());
                tail = tail.next;
            }
            lists[i] = dummy.next;
        }
        merge_K_lists merger = new merge_K_lists();
        ListNode merged = merger.mergeKLists(lists);
        // Print merged list
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        sc.close();
    }
}