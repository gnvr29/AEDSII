package org.example.stack;

import java.util.NoSuchElementException;

import org.example.nodes.UniNode;

public class UniStack<T> {
    private UniNode<T> bottom;
    private UniNode<T> top;

    public UniStack(){
        UniNode<T> sentinel = new UniNode<>();
        this.bottom = this.top = sentinel;
    }

    public boolean empty() {
        return this.bottom == this.top;
    }

    public T checkTop(){
        if(empty()) throw new NoSuchElementException("Empty stack");
        return this.top.getItem();
    }

    public void add(T item){
        this.top = new UniNode<T>(item, this.top);
    }

    public T pop(){
        T popped = this.top.getItem();
        this.top = this.top.getNext();
        return popped;
    }

    public void print(){
        for(UniNode<T> n = this.top; n != this.bottom; n = n.getNext()) System.out.println(String.format("%s ", n.getItem()));
    }

    public UniStack<T> reverseStack(){
        UniStack<T> reversedStack = new UniStack<>();
        for(UniNode<T> n = this.top; n != this.bottom; n = n.getNext()) reversedStack.add(n.getItem());
        return reversedStack;
    }

    public int countItems(){
        int i = 0;
        for(UniNode<T> n = this.top; n != null; n = n.getNext()) i++;
        return i;
    }

    public void reverse(){
        UniStack<T> aux1 = new UniStack<>();
        UniStack<T> aux2 = new UniStack<>();

        while(!empty()) aux1.add(this.pop());
        while(!aux1.empty()) aux2.add(aux1.pop());
        while(!aux2.empty()) this.add(aux2.pop());
    }

    public static void main(String[] args){
        UniStack<Integer> s = new UniStack<>();
        for(int i = 10; i >= 1; i--) s.add(i);
        
        System.out.println("Initial stack");
        s.print();

        s.reverse();
        System.out.println("Reversed stack");
        s.print();
    }
}
