/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.objects;

/**
 *
 * @author jccas
 * @param <T>
 */
public class Node<T> {
    
    T element;
    Node<T> next;

    public Node(T element, Node<T> nextElement) {
        this.element = element;
        this.next = nextElement;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    
}
