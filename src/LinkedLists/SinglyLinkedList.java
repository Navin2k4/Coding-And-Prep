package LinkedLists;

public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node constructLL(int arr[]) {
        if (arr == null || arr.length == 0)
            return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    // Function to count nodes of a linked list.
    static int getCount(Node head) {
        if (head == null)
            return 0;
        // code here
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    static boolean search(Node head, int key) {
        while (head != null) {
            if (head.data == key) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    static void printLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    static Node addTwoNumbers(Node head1, Node head2) {
        // since the number is given in the reverse order the head is at the unit place
        // of the number
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummy = new Node(-1);
        Node current = dummy;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int sum = carry;
            if (temp1 != null)
                sum = sum + temp1.data;
            if (temp2 != null)
                sum = sum + temp2.data;
            Node newNode = new Node(sum % 10);
            carry = sum / 10;
            current.next = newNode;
            current = current.next;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        if (carry > 0) {
            Node newNode = new Node(carry);
            current.next = newNode;
        }
        return dummy.next;
    }

    static Node oddEvenList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    static Node removeNthFromEnd(Node head, int n) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count == n) {
            return head.next;
        }
        temp = head;
        for (int i = 1; i < count - n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    static Node reverseList(Node head) {
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    static Node reverseListRec(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newHead = reverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = reverseList(slow.next);
        Node first = head;
        Node second = newHead;
        while (second != null) {
            if (first.data != second.data) {
                reverseList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(newHead);
        return true;
    }

    static Node middleNode(Node head) {
        // Normal approach is to find the count and count/2 + 1 is the middle but it
        // takes O(n) + O(n/2) iterations
        // using two pointers approach
        // Odd => last dataue Even => Null pointer
        Node slow = head; // 1 step
        Node fast = head; // 2 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node detectCycleStartPoint(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return findLength(slow, fast);
        }
        return 0;
    }

    static int findLength(Node slow, Node fast) {
        int counter = 1;
        fast = fast.next;
        while (fast != slow) {
            counter++;
            fast = fast.next;
        }
        return counter;
    }

    static Node deleteandJoinByNode(Node node, Node head) {
        if (head == null || head.next == null)
            return null;
        // Make the changes in The tortoise and Hare and we can track of the slow's prev
        // node and remove the linkage;
        Node slow = head;
        Node fast = head;
        Node prev = null;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
        // Node middle = findMiddle(head);
        // return deleteandJoinByNode(middle,head);
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);
        return merge(left, right);
    }

    private static Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;

        Node result;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    public Node sortList(Node head) {
        return mergeSort(head);
    }

    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 30, 40, 50 };
        int[] arr2 = { 5, 15, 25, 35, 45 };
        int[] palindromeArr = { 1, 2, 3, 2, 1 };
        int[] reverseArr = { 1, 2, 3, 4, 5 };

        Node head1 = constructLL(arr1);
        Node head2 = constructLL(arr2);
        Node palindromeHead = constructLL(palindromeArr);
        Node reverseHead = constructLL(reverseArr);

        System.out.println("Original List 1:");
        printLL(head1);

        System.out.println("Original List 2:");
        printLL(head2);

        // Count nodes
        System.out.println("Count: " + getCount(head1));

        // Search
        System.out.println("Search for 30: " + search(head1, 30));
        System.out.println("Search for 99: " + search(head1, 99));

        // Add two numbers
        System.out.println("Add two numbers:");
        printLL(addTwoNumbers(head1, head2));

        // Odd-Even Reorder
        System.out.println("Odd-Even Reordered List:");
        printLL(oddEvenList(constructLL(arr1))); // create new to avoid pointer corruption

        // Remove N-th Node from End
        System.out.println("Remove 2nd node from end:");
        printLL(removeNthFromEnd(constructLL(arr1), 2));

        // Reverse Iterative
        System.out.println("Reversed List (Iterative):");
        printLL(reverseList(constructLL(reverseArr)));

        // Reverse Recursive
        System.out.println("Reversed List (Recursive):");
        printLL(reverseListRec(constructLL(reverseArr)));

        // Check Palindrome
        System.out.println("Is Palindrome: " + isPalindrome(palindromeHead));

        // Find Middle Node
        Node middle = middleNode(head1);
        System.out.println("Middle Node of List1: " + (middle != null ? middle.data : "null"));

        // Merge Sort
        System.out.println("Sorted List (Merge Sort):");
        printLL(mergeSort(constructLL(new int[] { 4, 2, 1, 3, 5 })));

        // Cycle Detection (Manual loop creation)
        Node cycleHead = constructLL(new int[] { 1, 2, 3, 4 });
        cycleHead.next.next.next.next = cycleHead.next; // create cycle at node 2
        System.out.println("Has Cycle: " + new SinglyLinkedList().hasCycle(cycleHead));
        System.out.println("Start of Cycle: " + new SinglyLinkedList().detectCycleStartPoint(cycleHead).data);
        System.out.println("Count of nodes in cycle: " + new SinglyLinkedList().countNodesinLoop(cycleHead));

        // Delete and Join Middle Node
        System.out.println("Delete and Join by Middle Node:");
        printLL(deleteandJoinByNode(null, constructLL(arr1)));
    }

}
