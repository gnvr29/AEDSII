package org.example.linkedlist;

public class DoublyLinkedList<T> {

    private static class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private class DoublyLinkedListIterator /*implements java.util.Iterator<T>*/ {
        private Node<T> current = head.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
    }

    private int size;
    private int modCount = 0;
    private Node<T> head;
    private Node<T> tail;

    DoublyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear (){
        this.head = new Node<T>(null, null, null);
        this.tail = new Node<T>(null, head, null);
        this.head.next = this.tail;

        this.size = 0;
        this.modCount++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    /**
     * Adds an item to this collection, at the specified position p.
     * It slides elements before and after p by one position.
     * p is replaced by the new node, and becomes its "next"
     * @param p Node to add before
     * @param data
     * @throws
     */
    public void addBefore(Node<T> p, T data) {
        //Step 1: creates the new node and sets its prev and next node
        Node<T> newNode = new Node<T>(data, p.prev, p);

        //Step 2: changes the "next" node of the previousNode to the new node
        p.prev = newNode;

        //Step 3: changes the "prev" node of the previousNode.next to the new node
        p.prev.next = newNode;

        this.size++;
        this.modCount++;
    }

    /**
     * Removes the object contained in node p
     * @param p the Node containing the object
     * @return the object removed from the collection
     */
    public T remove(Node<T> p) {
        //Changes the "next" node of the prev of p to the "next" of p
        p.prev.next = p.next;

        //Changes the "prev" node of the next of p to the "prev" of p
        p.next.prev = p.prev;
        
        this.size--;
        this.modCount++;

        return p.data;
    }


    /**
     * Gets the node at position index, which must range from size 0 
     * to this.size - 1
     * @param index
     * @return the node at the specified index
     */
    public Node<T> getNode(int index) {
        return getNode(index, 0, this.size - 1);
    }


    /**
     * Gets node at position index, which must range from lower to upper
     * @param index index to search at
     * @param lower lowest valid index
     * @param upper highest valid index
     * @return  internal node corresponding to index
     */
    private Node<T> getNode(int index, int lower, int upper) {
        Node<T> p;

        //Checks if the index is smaller than 0 or bigger than the size
        if(index < lower || index > upper)
            throw new IndexOutOfBoundsException();


        /*
        if index is smaller than half the size, start from the beginning. Else,
        start from the end
        */
        if(index < this.size() / 2){
            p = this.head.next;
            for(int i = 0; i < index; i++) 
                p = p.next;
        } else {
            p = this.tail.prev;
            for(int i = this.size; i > index; i--)
                p = p.prev;
        }
        return p;
    }
}
