
public class Driver {

	public static void main(String[] args) {
		FlexHeap fheap = new FlexHeap();
		
		int[] randomKeys = {23, 20, 89, 63, 17, 69, 64, 97, 11, 24, 35, 61, 16, 91, 66, 13, 77, 19, 10};
		
		System.out.println("add entries");
		for (int i = 0; i < randomKeys.length; i++)
			fheap.insert(new Entry(randomKeys[i],'e'));
		
		System.out.println("remove the entries: ");
		while(!fheap.isEmpty()){
			Entry removed = fheap.remove();
			System.out.print(removed.getKey() + ", ");
		}
		
		System.out.println("\n\nadd the entries again");
		for (int i = 0; i < randomKeys.length; i++)
			fheap.insert(new Entry(randomKeys[i],'e'));
		
		System.out.println("toggle heap a few times");
		fheap.switchMaxHeap();
		fheap.switchMinHeap();
		fheap.toggleHeap();
		
		System.out.println("remove the entries again:");
		while(!fheap.isEmpty()){
			Entry removed = fheap.remove();
			System.out.print(removed.getKey() + ", ");
		}
	}
}
