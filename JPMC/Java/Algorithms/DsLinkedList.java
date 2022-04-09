
//import java.util.LinkedList;

public class DsLinkedList {
    public static void main(String[] args) {
        /*
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        
        // add & remove
        numbers.add(5);
        numbers.add(6);
        numbers.addFirst(1);
        numbers.addLast(7);
        numbers.add(1, 2);

        System.out.println(numbers);

        numbers.remove(1);
        numbers.removeFirst();
        numbers.removeLast();
        numbers.removeFirstOccurrence(1);
        System.out.println(numbers);

        // set
        numbers.set(1, 0);
        */

        // example
        // Delete Nth Node from End (LeetCode #19)
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        head.next = n2;
        head.next.next = n3;
        n3.next = n4;

        head = deleteNthFromEnd(head, 2);

        // print linkedlist
        Node on = head;
        while (on != null) {
            System.out.println(on.data);
            on = on.next;
        }

    }

    private static Node deleteNthFromEnd(Node head, int n) {
        // 1 measure the length
        int count = 1;  // assume it is atleast 1
        Node on = head;
        while (on != null) {
            count++;
            on = on.next;
        }
        int leftIndex = count - n - 1;
        // 1.5
        if (leftIndex == 0) return head.next;
        // 2 point around the node n
        on = head;
        while (leftIndex > 1) {
            leftIndex--;
            on = on.next;
        }
        on.next = on.next.next;
        // 3 handle head deletion
        return head;
    }
}
class Node {
    int data;
    Node next = null;

    Node(int d) {
        data = d;
    }
}

// in insertion and deletion, better than array
// dynamic