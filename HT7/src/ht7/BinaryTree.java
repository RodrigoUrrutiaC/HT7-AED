
package ht7;

/**
 * @author Rodrigo Urrutia 16139
 * @author Kevin Macario 17369
 * @version 18.03.2018
 */

public class BinaryTree<E>
{
    protected E val; // value associated with node
    protected BinaryTree<E> parent; // parent of node
    protected BinaryTree<E> left, right; // children of node
    
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right, BinaryTree<E> parent){
        val=value;
        this.left=left;
        this.right=right;
        this.parent=parent;
    }
    
    public BinaryTree<E> left()
    // post: returns reference to (possibly empty) left subtree
    {
            return left;
    }

    public BinaryTree<E> right()
    // post: returns reference to (possibly empty) left subtree
    {
            return right;
    }

    public BinaryTree<E> parent()
    // post: returns reference to parent node, or null
    {
        return parent;
    }
    
    public void setLeft(BinaryTree<E> newLeft){
        this.left=newLeft;
    }
    
    public void setRight(BinaryTree<E> newRight){
        this.right=newRight;
    }
    
    public void setParent(BinaryTree<E> newParent){
        this.left=newParent;
    }
    
    public E value()
	// post: returns value associated with this node
	{
		return val;
	}
	
	public void setValue(E value)
	// post: sets the value associated with this node
	{
		val = value;
	}
    
}