
public class FlexHeap {
	
	private BinaryTree btree;
	private boolean minHeap;
	
	public FlexHeap(){
		btree = new BinaryTree();
		minHeap = true;
	}

	public int size(){
		return btree.size();
	}
	
	public boolean isEmpty(){	
		return (btree.size() == 0);
	}
	
	public void insert(Entry entry){
		btree.attach(entry);
		upHeap(btree.lastNode());
	}
	
	public Entry remove(){
		Entry temp = btree.replace( btree.root(), btree.entryAt(btree.lastNode()) );
		btree.remove(btree.lastNode());
		
		downHeap(btree.root());
		return temp;
	}
	
	public void toggleHeap() {
		
		BinaryTree tempTree = new BinaryTree();
		reorder(btree, tempTree);
		btree = tempTree;
		
		if(minHeap)
			minHeap = false;
		else
			minHeap = true;
	}
	
	public void switchMinHeap() {
		toggleHeap();
	}
	
	public void switchMaxHeap() {
		toggleHeap();
	}
	
	private void upHeap(int position) {
		if (!btree.isRoot(position)){
			
			int higherRank = higherRank(btree.parent(position), position);
			if(higherRank == position){
				swap(position, btree.parent(position));
				upHeap(btree.parent(position));				
			}
		}
	}

	private void downHeap(int position) {
		if (btree.isInternal(position)){
			int higherRank;
			
			if (btree.hasLeft(position))
				if (btree.hasRight(position)){
					higherRank = higherRank(btree.left(position), btree.right(position));
					higherRank = higherRank(position, higherRank);
				}
				else
					higherRank = higherRank(btree.left(position), position);
			else
				higherRank = higherRank(btree.right(position), position);
			
			if(position != higherRank){
				swap(position, higherRank);
				downHeap(higherRank);
			}
		}
	}
	
	private int higherRank(int position1, int position2){
		if (minHeap)
			if (btree.entryAt(position1).getKey() <= btree.entryAt(position2).getKey())
				return position1;
			else
				return position2;
		else
			if (btree.entryAt(position1).getKey() >= btree.entryAt(position2).getKey())
				return position1;
			else
				return position2;			
	}
	
	private void swap(int position1, int position2){
		Entry temp = btree.replace(position1, btree.entryAt(position2));
		btree.replace(position2, temp);
	}
	
	private void reorder(BinaryTree btree, BinaryTree tempTree) {
		if(!isEmpty()){
			Entry temp = remove();
			reorder(btree, tempTree);
			tempTree.attach(temp);
		}
	}
}
