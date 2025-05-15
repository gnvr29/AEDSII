package org.example.queue;

import java.util.NoSuchElementException;

import org.example.nodes.UniNode;

public class UniQueue<T>{
    public UniNode<T> back;
    public UniNode<T> front;

    public UniQueue(){
        UniNode<T> sentinel = new UniNode<>();
        this.back = this.front = sentinel;
    }

    public boolean empty(){
        return this.back == this.front;
    }

    public T checkFirst(){
        if(empty()) throw new NoSuchElementException("Empty queue");
        return this.front.getNext().getItem();
    }

    public void add(T item) {
        UniNode<T> newNode = new UniNode<T>(item);
        back.setNext(newNode);
        back = back.getNext();
    }

    public T remove() {
        T item = checkFirst(); UniNode<T> first = front.getNext();
        front.setNext(first.getNext());
        first.setNext(null);

        if(first == back) back = front;

        return item;
    }

    public void concat(UniQueue<T> queue){
        while(!queue.empty()) this.add(queue.remove());
    }

    public int countItems(){
        if(empty()) return 0;
        int c = 0;
        for(UniNode<T> n = this.front.getNext(); n != null; n = n.getNext()) c++;
        return c;
    }

    public void print(){
        for(UniNode<T> n = this.front.getNext(); n != null; n = n.getNext()) System.out.println(String.format("%s ", n.getItem()));
    }

    public boolean exists(T item){
        for(UniNode<T> n = this.front.getNext(); n != null; n = n.getNext()) 
            if(n.getItem().equals(item))
                return true;

        return false;
    }

    public int numbersAhead(T item){
        if(empty()) throw new IllegalStateException("Empty queue");

        int c = 0;

        for(UniNode<T> n = front.getNext(); n != null; n = n.getNext()){
            if(n.getItem().equals(item))
                return c;
            else 
                c++;
        } 
        throw new NoSuchElementException("Item not found");
    }

    public UniQueue<T> copy(){
        UniQueue<T> copy = new UniQueue<>();
        for(UniNode<T> n = this.front.getNext(); n != null; n = n.getNext())
            copy.add(n.getItem());
        return copy;
    }

    public UniQueue<T> divide(){
        if(empty()) throw new IllegalStateException("Empty queue cannot be divided");

        int size = 0;
        for(UniNode<T> n = this.front.getNext(); n != null; n = n.getNext()) size++;

        UniQueue<T> q = new UniQueue<>();

        for(int i = 0; i < size; i++){
            T item = this.remove();

            if(i % 2 == 1) this.add(item);
            else if (i % 2 == 0) q.add(item);
        }

        return q;
    }

    public static void main(String[] args){
        UniQueue<Integer> q = new UniQueue<>();
        for(int i = 0; i < 11; i++) q.add(i);
        System.out.println(String.format("The queue has %d items", q.countItems()));
        q.print();

        System.out.println("Dividing...");
        UniQueue<Integer> evenNumersQueue = q.divide();
        System.out.println("Q1");
        q.print();
        System.out.println("Q2:");
        evenNumersQueue.print();

        System.out.println(q.front.getItem());

        /*
        UniQueue<Integer> emptyQueue = new UniQueue<>();

        UniQueue<Integer> qCopy = emptyQueue.copy();
        System.out.println("Copied queue:");
        qCopy.print();

        UniQueue<Integer> q2 = new UniQueue<>();
        for(int i = 11; i < 21; i++) q2.add(i);
        System.out.println(String.format("The second queue has %d items", q2.countItems()));
        q2.print();

        q.concat(q2);
        System.out.println(String.format("The new queue now has %d items", q.countItems()));
        q.print();
        */
    }

}
