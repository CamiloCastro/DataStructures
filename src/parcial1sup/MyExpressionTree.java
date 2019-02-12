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
public class MyExpressionTree {
    
    private MyBinaryNode<String> root;
    
    public MyExpressionTree()
    {
        root = null;
    }
    
    public MyExpressionTree(MyBinaryNode<String> root)
    {
        this.root = root;
    }
    
    public String inOrder()
    {
        //Your code here
        return inOrder(root).trim();
    }
    
    private String inOrder(MyBinaryNode<String> node)
    {
        if(node == null)
            return "";
        
        return inOrder(node.getLeft()) + node.getElement() + " " + inOrder(node.getRight());
    }
    
    public String preOrder()
    {
        //Your code here
        return preOrder(root).trim();
    }
    
    private String preOrder(MyBinaryNode<String> node)
    {
        if(node == null)
            return "";
        
        return node.getElement() + " " + preOrder(node.getLeft()) + preOrder(node.getRight());
    }
    
    public String posOrder()
    {
        //Your code here
        return posOrder(root).trim();
    }
    
    private String posOrder(MyBinaryNode<String> node)
    {
        if(node == null)
            return "";
        
        return posOrder(node.getLeft()) + posOrder(node.getRight()) + node.getElement() + " ";
    }
    
    public void buildExpressionTree(String postfixExpression)
    {
        MyLinkedStack<MyBinaryNode<String>> stack = new MyLinkedStack<>();
        String[] partsOfPostfixExpression = postfixExpression.split(" ");
        for (int i = 0; i < partsOfPostfixExpression.length; i++) {
            String part = partsOfPostfixExpression[i];
            switch(part)
            {
                case "+":case "-":case "*":case "/":                    
                    MyBinaryNode<String> rightChild = stack.pop();
                    MyBinaryNode<String> leftChild = stack.pop();
                    MyBinaryNode<String> newNode = new MyBinaryNode<>(part, leftChild, rightChild);
                    stack.push(newNode);                
                    break;
                default:
                    stack.push(new MyBinaryNode<>(part, null, null));
                    break;                    
            }            
        }
        root = stack.pop();        
    }

    public MyBinaryNode<String> getRoot() {
        return root;
    }

    public void setRoot(MyBinaryNode<String> root) {
        this.root = root;
    }
    
}
