package com.solvd.internetShop;

public class CustomLinkedList<T> {
    private Node<T> head;
    private int size;

    public CustomLinkedList(){
        head = null;
        size = 0;
    }

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
        } else {
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    public int size(){
        return size;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data){
            this.data = data;
            next = null;
        }
    }
}
