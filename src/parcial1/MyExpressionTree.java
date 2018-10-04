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
        return "";
    }
    
    public String preOrder()
    {
        //Your code here
        return "";
    }
    
    public String posOrder()
    {
        //Your code here
        return "";
    }
    
    public int solve()
    {
        //Your code here
        return 0;
    }

    public MyBinaryNode<String> getRoot() {
        return root;
    }

    public void setRoot(MyBinaryNode<String> root) {
        this.root = root;
    }
    
}
