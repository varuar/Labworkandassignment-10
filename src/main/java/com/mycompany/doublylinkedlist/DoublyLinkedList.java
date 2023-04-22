package com.mycompany.doublylinkedlist;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Node class
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Method to add a new node at the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Method to convert the list to an array
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<T> curr = head;
        int index = 0;
        while (curr != null) {
            arr[index++] = curr.data;
            curr = curr.next;
        }
        return arr;
    }

    // Method to find the index of a given object in the list
    public int indexOf(T obj) {
        Node<T> curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data.equals(obj)) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    // Method to find the sum of the last m elements of list n
    public int sumOfLastM(int m) {
        if (m > size) {
            return -1; // Return -1 if m is greater than the size of the list
        }
        Node<T> curr = tail;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += (Integer) curr.data; // Assuming that the data is of type Integer
            curr = curr.prev;
        }
        return sum;
    }

}
