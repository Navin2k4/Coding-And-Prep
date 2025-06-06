package LinkedLists;

public class SinglyLikedList {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertFirst(3);
        list.insertFirst(5);
        list.insertFirst(1);
        list.insertFirst(8);
        list.insertLast(12);
        list.insert(44, 4);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();
        System.out.println(list.find(5));
        System.out.println(list.find(12));
        System.out.println(list.getHead());
        System.out.println(list.getTail());
    } 
}
