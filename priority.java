import java.util.PriorityQueue;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class priority {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap to store nodes based on value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Insert the head of each list into heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract the min, add next node from same list
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.add(node.next);
            }
        }

        return dummy.next;
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example: [[1,4,5], [1,3,4], [2,6]]

        // First list: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));

        // Second list: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // Third list: 2 -> 6
        ListNode l3 = new ListNode(2, new ListNode(6));

        // Array of lists
        ListNode[] lists = { l1, l2, l3 };

        priority obj = new priority();
        ListNode merged = obj.mergeKLists(lists);

        System.out.print("Merged List: ");
        printList(merged);
    }
}
