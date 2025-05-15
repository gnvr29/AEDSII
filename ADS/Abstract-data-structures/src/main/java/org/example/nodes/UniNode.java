package org.example.nodes;

public class UniNode<T> {
    private T item;
    private UniNode<T> next;

    public UniNode(){
        this.item = null;
        this.next = null;
    }

    public UniNode(T item){
        this.item = item;
        this.next = null;
    }

    public UniNode(T item, UniNode<T> next){
        this.item = item;
        this.next = next;
    }

    public T getItem(){
        return this.item;
    }

    public void setItem(T item){
        this.item = item;
    }

    public UniNode<T> getNext(){
        return this.next;
    }

    public void setNext(UniNode<T> next){
        this.next = next;
    }

}
