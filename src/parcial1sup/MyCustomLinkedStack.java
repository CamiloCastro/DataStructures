/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1sup;

/**
 *
 * @author juan.castro
 */
public class MyCustomLinkedStack<T> {

    StackNode<T> top;
    int size;
    
    public MyCustomLinkedStack()
    {
        top = null;
        size = 0;
    }    
    
    public void push(T element, boolean isLast) {
        if(!isLast || top == null)
        {
            StackNode<T> newNode = new StackNode<>(element, top);
            top = newNode;            
        }
        else
        {
            StackNode<T> newNode = new StackNode<>(element, null);
            StackNode<T> iterNode = top;
            while(iterNode.getNextNode() != null)
            {
                iterNode = iterNode.getNextNode();
            }
            iterNode.setNextNode(newNode);
        }
        size++;
    }

    
    public T pop() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        T poppedElement = top.getElement();
        top = top.getNextNode();
        size--;
        return poppedElement;
    }

    
    public T top() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        return top.getElement();
    }
    
    public void clear() {
        top = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void print() {
        StackNode<T> n = top;
        while(n != null)        
        {
            System.out.println(n.getElement());
            n = n.getNextNode();
        }
    }
    
}
