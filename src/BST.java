import java.util.*;
public class BST {
	
	private Node root;
	
	public BST()
	{
		root = null;
	}
	public BST(float key)
	{
		root = new Node(key);
	}
	
	public void clear()
	{
		root = null;
	}
	 public void insert(float key) {
	       if(root == null)
	    	   root = new Node(key);
	       else
	    	   root.insert(root, key);
	    }
	 
	
	public boolean search(float key) {
        return root.searchRec(root, key);
    }
	
	public float findMin()
	{
		return root.MinValue(root);
	}
	
	public float findMax()
	{
		return root.MaxValue(root);
	}
	
	public float findGT(float ref)
	{
		if(root == null)
		{
			return Float.NaN;
		}
		float value=ref;
		value = root.Find(root, ref, value);
		if(value == ref)
		{
			return Float.NaN;
		}
		else
			return value;
	}
	
	
	
	public Float [] findInInterval(float min_val, float max_val)
	{
		ArrayList<Float>tmp = new ArrayList<Float>();
		sort(root.FindRange(root, min_val, max_val, tmp));
		Float[] array = new Float[tmp.size()];
   	 	array = tmp.toArray(array);
		return array;
	}
	
	public void sort(ArrayList<Float> array)
	{
		for (int i = 1; i < array.size(); ++i) {
			Float value = array.get(i),temp;
			int j; 
			for (j = i; j > 0 && (value.compareTo(temp=array.get(j-1))< 0); --j)
				array.set(j,  temp);
			array.set(j, value);
		}
	}
	
	public Node delete(float key)
	{
		if(root == null)
			return null;
		return root = root.Delete(root, key);
	}
	
	public void simpleDraw()
	{
		int count = 0;
		root.rec(root, count);
	}
	
		
	 public void inorder()
	 { 
		 root.inorderRec(root); 
	 }
	 

	public void preorder()
	 { 
		root.PreorderRec(root); 
	 }
	
	
	public void postorder()
	 { 
		root.PostorderRec(root); 
	 }
}
