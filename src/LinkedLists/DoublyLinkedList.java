package LinkedLists;

public class DoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node constructLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            newNode.prev = prev;
            prev.next = newNode;
            prev = newNode;
        }
        return head;
    }


    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        Node head = constructLL(arr);
    }

}
