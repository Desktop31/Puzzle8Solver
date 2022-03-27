package com.example.puzzle8;

import java.util.ArrayList;

public class MyQueue<E> {

    private ArrayList<E> queue;

    public MyQueue() {
        this.queue = new ArrayList<>();
    }

    public ArrayList<E> getQueue() {
        return queue;
    }

    public void add(E newValue){
        // prida prvek
        this.queue.add(newValue);
    }

    public E remove(){
        // vrati a odstrani prvni prvek
        if (this.queue.size() == 0) return null;

        E item = this.queue.get(0);
        this.queue.remove(0);

        return item;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public int size() {
        return this.queue.size();
    }

    public void empty() {
        while (!this.queue.isEmpty()) {
            remove();
        }
    }

    @Override
    public String toString() {
        return "QueueArrayList{" +
                "queue=" + queue +
                '}';
    }

}
