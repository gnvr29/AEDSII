package org.example.linkedlist;

import java.util.NoSuchElementException;

import org.example.nodes.UniNode;

public class UniLinkedList<T> {
    private UniNode<T> first;
    private UniNode<T> last;
    private int size;

    public UniLinkedList(){
        UniNode<T> sentinel = new UniNode<>();
        first = last = sentinel;
        this.size = 0;
    }

    public boolean empty(){
        return this.first == this.last;
    }

    public void insert(T item, int position){
        if(position < 0 || position > size) throw new IndexOutOfBoundsException("Invalid position");
        
        UniNode<T> newNode = new UniNode<>(item);

        UniNode<T> prev = this.first;

        for(int i = 0; i < position; i++) prev = prev.getNext();

        UniNode<T> next = prev.getNext();

        prev.setNext(newNode);
        newNode.setNext(next);

        if(position == this.size) this.last = newNode;

        this.size++;
    }

    public void insert(T item){
        UniNode<T> n = new UniNode<>(item);
        this.last.setNext(n);
        this.last = n;
        this.size++;
    }

    public T remove(int position){
        if(empty()) throw new IllegalStateException("Cannot remove from an empty list");
        if(position < 0 || position > size) throw new IndexOutOfBoundsException("Invalid position");

        UniNode<T> prev = this.first;
        for(int i = 0; i < position; i++) prev = prev.getNext();

        UniNode<T> removed = prev.getNext();
        UniNode<T> next = removed.getNext();

        prev.setNext(next);
        removed.setNext(null);

        if(position == size - 1) this.last = prev;

        size--;
        return removed.getItem();
    }

    public T removeFirstOccurence(T item){
        if(empty()) throw new IllegalStateException("Empty list");

        UniNode<T> n = this.first;
        for(int i = 0; i < size; i++){
            if(n.getNext().getItem().equals(item)){
                UniNode<T> popped = n.getNext();
                UniNode<T> next = popped.getNext();
                n.setNext(next);
                popped.setNext(null);

                if(i == size - 1) this.last = n;

                return popped.getItem();
            }
            n = n.getNext();
        }
        throw new NoSuchElementException("Item not found");
    }

    public int countItems(){
        int n = 0;

        if(empty()) return n;

        for(UniNode<T> i = this.first.getNext(); i != null; i = i.getNext()) n++;

        return n;
    }

    public T find(int position){
        if(position < 0 || position >= size) throw new IndexOutOfBoundsException("Invalid position");

        UniNode<T> n = this.first.getNext();
        for(int i = 0; i < position; i++) n = n.getNext();
        
        return n.getItem();
    }

    public void switchItems(T itemX, T itemY){
        if(empty()) throw new IllegalStateException("Empty list");

        UniNode<T> p1 = null, p2 = null;

        UniNode<T> n = this.first;
        for(int i = 0; i < size; i++){
            if(n.getNext().getItem().equals(itemX)) p1 = n.getNext();
            else if(n.getNext().getItem().equals(itemY)) p2 = n.getNext();
            n = n.getNext();
        }

        if(p1 == null || p2 == null) throw new NoSuchElementException("Element not found");

        p1.setItem(itemY);
        p2.setItem(itemX);
    }

    public void print(){        
        UniNode<T> n = this.first;
        for(int i = 0; i < size; i++){
            System.out.println(n.getNext().getItem() + " ");
            n = n.getNext();
        }
    }

    public static void main(String[] args){
        UniLinkedList<Integer> l = new UniLinkedList<>();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.print();;

        System.out.println("Item at position 2");
        System.out.println(l.find(2));

        System.out.println("Swapping 1 and 2");
        l.switchItems(1, 2);
        l.print();
    }
}
