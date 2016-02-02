
public class BinaryTree {
	
	ArrayList alist;
	
	public BinaryTree(){
		alist = new ArrayList();
		alist.add(0,null);
	}
	public int size(){
		return alist.size()-1;
	}
	public boolean isEmpty(){
		return (alist.size() == 0);
	}
/*
	public void Iterator(){
	}
	public void positions(){
	}
	*/
	public Entry replace(int position, Entry element){
		return alist.set(position, element);
	}
	public int root(){
		return 1;
	}
	public int parent(int position){
		if (isRoot(position)){
			System.out.println("Error, position is the root's");
			return -1;
		}
		if ( position % 2 == 0)
			return (position/2);
		else
			return ((position - 1)/2);
	}
	public int left(int position){
		if (!hasLeft(position)){
			System.out.println("Error, position doesn't have left");
			return -1;
		}
		return (position*2);
	}
	public int right(int position){
		if (!hasRight(position)){
			System.out.println("Error, position doesn't have right");
			return -1;
		}
		return ( position*2 + 1 );
	}
	public int sibling(int position){
		if (isRoot(position)){
			System.out.println("Error, position is the root's");
			return -1;
		}
		
		int sibling;
		
		if ( position % 2 == 0)
			sibling = position + 1;
		else 
			sibling = position - 1;
		
		if(alist.get(sibling) == null){
			System.out.println("Error, position is an only child's");
			return -1;
		}
		
		return sibling;

	}
/*	
	public void children(){
	}
	public void children(char v){
	}
*/
	public boolean hasLeft(int position){
		int leftChild = position * 2;
		if (leftChild >= alist.size())
			return false;
		return ( alist.get(leftChild) != null );
	}
	public boolean hasRight(int position){
		int rightChild = (position * 2) + 1;
		if (rightChild >= alist.size())
			return false;
		return ( alist.get(rightChild) != null );
	}
	public boolean isInternal(int position){
		return ( hasLeft(position) || hasRight(position) );
	}
	public boolean isExternal(int position){
		return !isInternal(position);
	}
	public boolean isRoot(int position){
		return (position == 1);
	}
	public Entry remove(int position){
		return alist.remove(position);
	}
	public void insertLeft(int position, Entry element){
		if (hasLeft(position))
			System.out.println("Error, position already has right");
		else
			alist.add(position*2, element);		
	}
	public void insertRight(int position, Entry element){
		if (hasRight(position))
			System.out.println("Error, position already has right");
		else
			alist.add(position*2 + 1, element);
	}
	
	public Entry entryAt(int position){
		return alist.get(position);
	}
	
	public void attach(Entry element){
		alist.add(alist.size(), element);
	}
	
	public int lastNode(){
		return alist.size() - 1;
	}	
}
