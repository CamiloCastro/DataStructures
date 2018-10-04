/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author juan.castro
 */
public class MyLinkedBiqueue<T> {
    
    QueueNode<T> front;
    QueueNode<T> back;
    int size;
    
    public MyLinkedBiqueue()
    {
        front = null;
        back = null;
        size = 0;
    }

    
    public void enqueue(T element, boolean inBack) {   
        
        if(inBack)
        {
            QueueNode<T> newNode = new QueueNode<>(element, null);
            if (size > 0)        
                back.setNextNode(newNode);        
            else
                front = newNode;
        
            back = newNode;        
        }
        else
        {
            QueueNode<T> newNode = new QueueNode<>(element, null);
            if(front != null)
                newNode.setNextNode(front);
            else
                back = newNode;
                
            front = newNode;
        }
        
        
        size++;        
        
    }

    
    public T dequeue(boolean fromFront) {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");        
        
        if (fromFront || size == 1)
        {   
            T dequeuedElement = front.getElement();
            front = front.getNextNode();
            size--;
            return dequeuedElement;    
        }
        else
        {
            T dequeuedElement = back.getElement();
            QueueNode<T> newBackNode = front;
            for (int i = 0; i < size ; i++) {
                if(newBackNode.getNextNode() == back)
                    break;           
                newBackNode = newBackNode.getNextNode();
            }
            back = newBackNode;
            back.setNextNode(null);
            size--;
            return dequeuedElement; 
        }
    }

    
    public T getFront() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        return front.getElement();
    }

    
    public T getBack() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        return back.getElement();
    }

    
    public void print() {
        QueueNode<T> n = front;
        while(n != null)        
        {
            System.out.println(n.getElement().toString());
            n = n.getNextNode();
        }
    }

    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
    
    public String toString()
    {
        QueueNode<T> n = front;
        String result = "";
        while(n != null)        
        {
            result += n.getElement().toString();
            n = n.getNextNode();
        }
        return result;
    }
    
}
