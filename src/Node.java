import java.util.ArrayList;

public class Node {
	
	private float key;
	private Node leftChild;
	private Node rightChild;
		
	public Node() {}
	public Node(float key)
	{
		this.key = key;
		this.leftChild= null;
		this.rightChild = null;
	}
	public float getKey() {
		return key;
	}
	public void setKey(float key) {
		this.key = key;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	 public Node insert(Node node, float key) 
	 {
		 if (node == null) 
		 {
			 node = new Node(key);
			 return node;
		 }
	     else if (node.getKey() > key) 
	     {
	    	 node.setLeftChild(insert(node.getLeftChild(), key));
	     } 
	     else if (node.getKey() < key)
	     {
	    	 node.setRightChild(insert(node.getRightChild(), key));
	     }
	        return node;
	}
	
	public boolean searchRec(Node node, float key) {
        if (node == null) {
            return false;
        } else if (node.getKey() == key) {
            return true;
        } else if (node.getKey() > key) {
            return searchRec(node.getLeftChild(), key);
        }
        return searchRec(node.getRightChild(), key);
    }
	
	
	public float Find(Node node, float ref, float value)
	{
		if(node == null)
		{
			return value;
		}
		else
		{
			if(ref >= node.getKey())
			{
				return Find(node.getRightChild(), ref, value);
			}
			else
			{
				value = node.getKey();
				return Find(node.getLeftChild(), ref, value);
			}
			
		}
	}
	
	public ArrayList<Float> FindRange(Node node, float min_val, float max_val, ArrayList<Float>tmp)
	{
		if(node == null)
		{
			return tmp;
		}
		else
		{
			if(node.getKey() > max_val)
			{
				return FindRange(node.getLeftChild(), min_val, max_val, tmp);
			}
			else if(node.getKey() < min_val)
			{
				return FindRange(node.getRightChild(), min_val, max_val, tmp);
			}
			else 
			{
				tmp.add(node.getKey());
				FindRange(node.getRightChild(), min_val, max_val, tmp);
				FindRange(node.getLeftChild(), min_val, max_val, tmp);
			}
			return tmp;
		}
	}
	
	public Node Delete(Node node, float key)
	{
		if(node == null) {
			System.out.println("Nie ma takiego elementu w drzewie");
			return null;
		}
		if(key < node.getKey())
			node.setLeftChild(Delete(node.getLeftChild(), key));
		else if(key > node.getKey())
			node.setRightChild(Delete(node.getRightChild(), key));
		else
		{
			if(node.getLeftChild() == null)
				return node.getRightChild();
			else if(node.getRightChild() == null)
				return node.getLeftChild();
			else
			{
				node.setKey(MinValue(node.getRightChild()));
				node.setRightChild(Delete(node.getRightChild(), node.getKey()));
			}
		}
		return node;
	}
	
	public float MinValue(Node node)
	{
		float tmp = node.getKey();
		if(node.getLeftChild() == null)
			return tmp;
		else {
			tmp = node.getLeftChild().getKey();
			return MaxValue(node.getLeftChild());
		}
	}
	
	public float MaxValue(Node node)
	{
		float tmp = node.getKey();
		if(node.getRightChild() == null)
			return tmp;
		else {
			tmp = node.getRightChild().getKey();
			return MaxValue(node.getRightChild());
		}
	}
	
	public void rec(Node node, int count)
	{
		if (node != null) 
        {
			
			for(int i=0;i <count; i++)
	       		System.out.print("   ");
			count++;
			System.out.println(node.getKey());
	        rec(node.getLeftChild(), count);
	        rec(node.getRightChild(), count);
        }
	}
	
	public void inorderRec(Node node)
	{
	   if (node != null)
	   {
		   inorderRec(node.getLeftChild());
		   System.out.print(node.getKey()+ " ");
		   inorderRec(node.getRightChild());
	   }
	}
	
	public void PreorderRec(Node node)
    {
        if (node != null) 
        {
	        System.out.print(node.getKey() + " ");
	        PreorderRec(node.getLeftChild());
	        PreorderRec(node.getRightChild());
        }
    }
	
	public void PostorderRec(Node node)
	{
	       if (node != null) 
	       {
	    	   PostorderRec(node.getLeftChild());
	    	   PostorderRec(node.getRightChild());
		       System.out.print(node.getKey() + " ");
	       }
	}

}
