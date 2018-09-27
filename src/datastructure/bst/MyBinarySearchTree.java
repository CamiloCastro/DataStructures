/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.bst;

/**
 *
 * @author jccas
 */
public class MyBinarySearchTree<T extends Comparable> {
    
    private MyBinaryNode<T> root;
    
    public MyBinarySearchTree()
    {
        root = null;
    }
    
    public void clear()
    {
        root = null;
    }
    
    public boolean isEmpty()
    {
        return root == null;
    }
    
    public boolean contains(T element)
    {
        return contains(element, root);
    }
    
    public T findMin()
    {
        if(isEmpty())
        {
            System.out.println("Tree empty");
            return null;
        }            
        else
            return findMin(root).getElement();                    
    }
    
    public T findMax()
    {
        if(isEmpty())
        {
            System.out.println("Tree empty");
            return null;
        }            
        else
            return findMax(root).getElement();                    
    }
    
    public void insert(T element)
    {
        root = insert(element, root); 
    }
    public void remove(T element)
    { 
        root = remove(element, root); 
    }
    
    private boolean contains(T element, MyBinaryNode<T> node)
    {
        if(node == null)
            return false;
        
        int compareResult = element.compareTo(node.getElement());
        
        if(compareResult < 0)
            return contains(element, node.getLeft());
        else if(compareResult > 0)
            return contains(element, node.getRight());
        else
            return true;
    }
    
    private MyBinaryNode<T> findMin(MyBinaryNode<T> node)
    {
        if(node == null)
            return null;
        else if(node.getLeft() == null)
            return node;
        else
            return findMin(node.getLeft());
    }
    
    private MyBinaryNode<T> findMax(MyBinaryNode<T> node)
    {
        if(node == null)
            return null;
        else if(node.getRight() == null)
            return node;
        else
            return findMin(node.getRight());
    }
    
    private MyBinaryNode<T> insert(T element, MyBinaryNode<T> node)
    {
        if(node == null)
            return new MyBinaryNode<>(element, null, null);
        
        int compareResult = element.compareTo(node.getElement());
        
        if(compareResult < 0)
            node.setLeft(insert(element, node.getLeft()));
        else if(compareResult > 0)
            node.setRight(insert(element, node.getRight()));
        
        return node;
    }
    
    private MyBinaryNode<T> remove(T element, MyBinaryNode<T> node)
    {
        if(node == null)
            return node;
        
        int compareResult = element.compareTo(node.getElement());
        
        if(compareResult < 0)
            node.setLeft(remove(element, node.getLeft()));
        else if(compareResult > 0)
            node.setRight(remove(element,node.getRight()));
        else if(node.getLeft() != null && node.getRight() != null)
        {
            node.setElement(findMin(node.getRight()).getElement());
            node.setRight(remove(node.getElement(), node.getRight()));
        }
        else
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        
        return node;
        
    }
    
}
