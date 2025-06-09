package custom_datastructures;

public class MyStack<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public void push(T item){
        Node<T> node = new Node<>(item);
        node.next = top;
        top = node;
    }

    public T pop(){
        if(isEmpty()) return null;
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek(){
        return isEmpty()  ? null : top.data;
    }


    public boolean isEmpty(){
        return top == null;
    }

    public void clear(){
        top = null;
    }

}
